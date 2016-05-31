package com.github.rchugunov.android.analytics.sonar;

import org.sonar.api.Extension;
import org.sonar.api.SonarPlugin;

import java.util.Arrays;
import java.util.List;

public class AndroidAnalyticsSonarPlugin extends SonarPlugin {

    public AndroidAnalyticsSonarPlugin() {
        super();
    }

    /**
     * Defines the plugin extensions: metrics and sensor.
     *
     * @return the list of extensions for this plugin
     */
    public List<Class<? extends Extension>> getExtensions() {
        return Arrays.asList(
                AndroidAnalyticsMetrics.class,
                AndroidAnalyticsSensor.class);
    }
}
