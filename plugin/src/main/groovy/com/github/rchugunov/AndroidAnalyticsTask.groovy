package com.github.rchugunov

import com.github.rchugunov.auth.GApiServiceAccountPrivateData
import com.github.rchugunov.auth.JWTSigningHelper
import com.github.rchugunov.rest.GApiOAuthResponse
import com.github.rchugunov.rest.GApiRestClient
import com.github.rchugunov.rest.GApiReviewsListResponse
import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.StopActionException
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.TaskExecutionException
import retrofit2.Call
import retrofit2.Response

public class AndroidAnalyticsTask extends DefaultTask {

    Gson gson = new Gson()

    @TaskAction
    public void run() {

        if (!project.getPlugins().hasPlugin("com.android.application")) {
            throw new TaskExecutionException(this,
                    new StopActionException("Android analytics work only with Android projects. \r\n" +
                            "Add 'com.android.application' plugin and set up at least one Android module"))
        }

        File json = project.androidAnalytics.googleServiceAccountJson

        GApiServiceAccountPrivateData privateData =
                gson.fromJson(new JsonReader(new FileReader(json)),
                        GApiServiceAccountPrivateData.class)

        JWTSigningHelper helper = new JWTSigningHelper(privateData.getClientEmail(),
                { ->
                    privateData.getPrivateKey()
                })

        String assertion = helper.getSignatureBase64()
        GApiRestClient client = GApiRestClient.getInstance()
        Call<GApiOAuthResponse> responseCall = client
                .getService()
                .getTokenData("urn:ietf:params:oauth:grant-type:jwt-bearer", assertion)

        String authToken = null;

        try {
            Response<GApiOAuthResponse> response = responseCall.execute()
            logger.info("Auth status " + response.code())
            logger.debug("Auth token " + response.body().getAccessToken())
            authToken = response.body().getAccessToken();
        } catch (Exception e) {
            logger.quiet(e.toString(), e)
        }

        if (authToken == null || authToken.length() == 0) {
            throw new TaskExecutionException(this, new StopActionException("Could not authorize in Google API (oauth2)"))
        }

        ReviewsHelper reviewsHelper = new ReviewsHelper(project, authToken)
        GApiReviewsListResponse response = reviewsHelper.loadReviews()

        if (response != null) {
            String reviews = gson.toJson(response)

            if (reviews != null && reviews.length() > 0) {
                File buildReport = new File(project.buildDir, "android.analytics/reviews.json")
                if (!buildReport.exists()) {
                    buildReport.getParentFile().mkdirs()
                    buildReport.createNewFile()
                }
                FileWriter fileWriter = new FileWriter(buildReport)
                fileWriter.write(reviews)
                fileWriter.close()
            }
        }
    }
}
