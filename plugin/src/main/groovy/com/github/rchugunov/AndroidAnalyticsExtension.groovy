package com.github.rchugunov

import org.gradle.api.Plugin
import org.gradle.api.Project


public class AndroidAnalyticsExtension {
    def String googleProjectId;

    String getGoogleProjectId() {
        return googleProjectId
    }

    void setGoogleProjectId(String googleProjectId) {
        this.googleProjectId = googleProjectId
    }
}
