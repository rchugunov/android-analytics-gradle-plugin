package com.github.rchugunov

import org.gradle.api.Plugin
import org.gradle.api.Project


public class AndroidAnalyticsPlugin implements Plugin<Project> {

    static final def ANDROID_ANALYTICS = "androidAnalytics"

    @Override
    void apply(Project project) {
        project.getExtensions().add(ANDROID_ANALYTICS, AndroidAnalyticsExtension)
    }
}
