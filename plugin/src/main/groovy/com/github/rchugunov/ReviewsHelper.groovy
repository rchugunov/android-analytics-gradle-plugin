package com.github.rchugunov

import com.github.rchugunov.rest.GApiRestClient
import com.github.rchugunov.rest.GApiReviewsListResponse
import org.gradle.api.Project
import org.gradle.api.tasks.StopActionException
import org.gradle.api.tasks.TaskExecutionException
import retrofit2.Call
import retrofit2.Response


class ReviewsHelper {
    String authToken;
    Project project

    def ReviewsHelper(Project project, String authToken) {
        this.authToken = authToken
        this.project = project
    }

    def void loadReviews() {
        try {
            GApiRestClient restClient = GApiRestClient.getInstance()
            Call<GApiReviewsListResponse> responseCall = restClient.getService()
                    .getReviews(project.android.flavorapplicationId, "Bearer " + authToken)
            Response<GApiReviewsListResponse> response = responseCall.execute()

            if (response.body() != null) {
                project.logger.quiet(response.body().toString())
            } else {
                project.logger.quiet(response.message())
                project.logger.quiet("Request " + responseCall.request().toString())
                project.logger.quiet("Result " + response.code())
                if (response.errorBody() != null) {
                    project.logger.quiet(response.errorBody().string())
                }
                throw new TaskExecutionException(project.getTasks().getByPath(AndroidAnalyticsPlugin.ANALYTICS_TASK_NAME),
                        new StopActionException())
            }
        } catch (Exception e) {
            throw new TaskExecutionException(project.getTasks().getByPath(AndroidAnalyticsPlugin.ANALYTICS_TASK_NAME), e)
        }
    }
}
