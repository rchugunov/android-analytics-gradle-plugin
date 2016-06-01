package com.github.rchugunov.android.analytics.sonar;

import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metrics;

import java.util.Collections;
import java.util.List;

public class AndroidAnalyticsMetrics implements Metrics {
    /**
     * Google play rating
     */
    public static final Metric GOOGLE_PLAY_RATING =
            new Metric.Builder(
                    "google_play_rating",
                    "Google play rating",
                    Metric.ValueType.INT)
                    .setDescription("Daily app rating in Google Play")
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
