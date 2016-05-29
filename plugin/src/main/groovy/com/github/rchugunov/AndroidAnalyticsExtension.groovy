package com.github.rchugunov

public class AndroidAnalyticsExtension {
    def File googleServiceAccountJson;

    File getGoogleServiceAccountJson() {
        return googleServiceAccountJson
    }

    void setGoogleServiceAccountJson(File googleServiceAccountJson) {
        this.googleServiceAccountJson = googleServiceAccountJson
    }
}
