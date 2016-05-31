package com.github.rchugunov.android.analytics.sonar;

import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metrics;

import java.util.Collections;
import java.util.List;

public class AndroidAnalyticsMetrics implements Metrics {
    /**
     * The project name (as configured in the IDE).
     */
    public static final Metric GOOGLE_PLAY_RATING =
            new Metric.Builder(
                    "google_play_rating",
                    "Project name in IDE",
                    Metric.ValueType.INT)
                    .setDescription("The project name (as configured in the IDE)")
                    .setQualitative(false)
                    .setDomain(CoreMetrics.DOMAIN_GENERAL)
                    .create();

    public AndroidAnalyticsMetrics() {
        super();
    }

    @Override
    public List<Metric> getMetrics() {
        return Collections.singletonList(GOOGLE_PLAY_RATING);
    }
}
