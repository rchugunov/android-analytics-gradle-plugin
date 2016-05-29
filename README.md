# Android analytics Gradle Plugin

At the moment you can install plugin in your local repository 

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
        classpath 'com.github.rchugunov.android-analytics:plugin:0.1.0'
    }
}

apply plugin: 'android-analytics'
```

in your project add

``` groovy
androidAnalytics {
    googleProjectId ''
}
```


