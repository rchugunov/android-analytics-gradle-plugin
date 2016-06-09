package com.github.rchugunov

import org.gradle.api.Plugin
import org.gradle.api.Project

public class AndroidAnalyticsPlugin implements Plugin<Project> {

    static final def ANDROID_ANALYTICS = "androidAnalytics"
    static final def ANALYTICS_TASK_NAME = "getAnalytics";

    @Override
    void apply(Project project) {
        project.getExtensions().create(ANDROID_ANALYTICS, AndroidAnalyticsExtension)

        createTask(project)

        project.subprojects.each { project1 -> createTask(project1) }
    }

    private AndroidAnalyticsTask createTask(final Project project) {

        AndroidAnalyticsTask androidAnalyticsTask = project
                .getTasks()
                .create(ANALYTICS_TASK_NAME, AndroidAnalyticsTask.class);

        androidAnalyticsTask.setDescription("Retrieves " + project + " analytics.");

//        ConventionMapping conventionMapping = new DslObject(androidAnalyticsTask).getConventionMapping();
//        conventionMapping.map("properties", { ->
//            Map<String, Object> properties = Maps.newLinkedHashMap();
//            computeSonarProperties(project, properties, actionBroadcastMap, "");
//            return properties;
//        });

        return androidAnalyticsTask;
    }
}
