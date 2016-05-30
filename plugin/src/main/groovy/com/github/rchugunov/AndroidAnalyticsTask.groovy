package com.github.rchugunov

import com.github.rchugunov.auth.GApiServiceAccountPrivateData
import com.github.rchugunov.auth.JWTSigningHelper
import com.github.rchugunov.rest.GApiOAuthResponse
import com.github.rchugunov.rest.GApiRestClient
import com.google.api.client.auth.oauth2.Credential
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import com.google.api.services.androidpublisher.AndroidPublisher
import com.google.api.services.androidpublisher.AndroidPublisherScopes
import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import retrofit2.Call
import retrofit2.Response

import java.security.GeneralSecurityException

public class AndroidAnalyticsTask extends DefaultTask {

    @TaskAction
    public void run() {
        File json = project.androidAnalytics.googleServiceAccountJson

        GApiServiceAccountPrivateData privateData =
                new Gson().fromJson(new JsonReader(new FileReader(json)),
                        GApiServiceAccountPrivateData.class)

        JWTSigningHelper helper = new JWTSigningHelper(privateData.getClientEmail(),
                { ->
                    privateData.getPrivateKey()
                })

        String assertion = helper.getSignatureBase64()
        logger.quiet(helper.getClaim().toString())
        logger.quiet(assertion)
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
            logger.quiet("Could not authorize in Google API (oauth2)")
            return
        }

        ReviewsHelper reviewsHelper = new ReviewsHelper(project, authToken)
        reviewsHelper.loadReviews()
    }

    private Credential authorizeWithServiceAccount(String serviceAccountEmail, File json)
            throws GeneralSecurityException, IOException {

        project.logger.info(String.format("Authorizing using Service Account: %s", serviceAccountEmail));

        GoogleCredential credential = GoogleCredential.fromStream(new FileInputStream(json))
                .createScoped(Collections.singleton(AndroidPublisherScopes.ANDROIDPUBLISHER));
        AndroidPublisher androidPublisher = new AndroidPublisher.Builder(null, null, null).build()
        androidPublisher.edits();
        return credential;
    }
}
