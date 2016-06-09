# Android analytics Gradle Plugin + SonarQube plugin (Measuring Google Play rating)

[![Build Status](https://travis-ci.org/rchugunov/android-analytics-gradle-plugin.svg?branch=master)](https://travis-ci.org/rchugunov/android-analytics-gradle-plugin) [![Code Climate](https://codeclimate.com/github/rchugunov/android-analytics-gradle-plugin/badges/gpa.svg)](https://codeclimate.com/github/rchugunov/android-analytics-gradle-plugin) [![Issue Count](https://codeclimate.com/github/rchugunov/android-analytics-gradle-plugin/badges/issue_count.svg)](https://codeclimate.com/github/rchugunov/android-analytics-gradle-plugin) [![Test Coverage](https://codeclimate.com/github/rchugunov/android-analytics-gradle-plugin/badges/coverage.svg)](https://codeclimate.com/github/rchugunov/android-analytics-gradle-plugin/coverage)

##Documentation in progress

If you contribute to this plugin you can deploy it fast

`./gradlew plugin:build plugin:install`

and connect to your own project

``` groovy
buildscript {
    repositories {
        mavenLocal()
        ...
    }
    dependencies {
        ...
        classpath 'com.github.rchugunov.android-analytics:plugin:0.1.5'
    }
}

apply plugin: 'android-analytics'
```

For general use just add this lines to your project's build.gradle

``` groovy
plugins {
    id "com.github.rchugunov.android-analytics" version "0.1.5"
}
```

configuration:

``` groovy
androidAnalytics {
    applicationId = 'your package_id the same from Google Play' // if not specified in defaultConfig

    googleServiceAccountJson file(...) // json file downloaded from Google Cloud Console (read next)
}
```

To get this plugin working you should create Service Account in Google Cloud https://developers.google.com/identity/protocols/OAuth2ServiceAccount#overview in project associated with your Google Play account.
  
  




