package com.github.rchugunov

public class AndroidAnalyticsExtension {
    def File googleServiceAccountJson;
    String applicationId;

    File getGoogleServiceAccountJson() {
        return googleServiceAccountJson
    }

    void setGoogleServiceAccountJson(File googleServiceAccountJson) {
        this.googleServiceAccountJson = googleServiceAccountJson
    }

    String getApplicationId() {
        return applicationId
    }

    void setApplicationId(String applicationId) {
        this.applicationId = applicationId
    }
}
