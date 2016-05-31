package com.github.rchugunov.android.analytics.sonar.model;


import java.util.List;

public class Review {
    private String reviewId;
    private String authorName;
    private List<Comment> comments;

    public String getReviewId() {
        return reviewId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId='" + reviewId + '\'' +
                ", authorName='" + authorName + '\'' +
                ", comments=" + comments +
                '}';
    }

    public static class Comment {

        private UserComment userComment;
        private DeveloperComment developerComment;

        public UserComment getUserComment() {
            return userComment;
        }

        public DeveloperComment getDeveloperComment() {
            return developerComment;
        }

        @Override
        public String toString() {
            return "Comment{" +
                    "userComment=" + userComment +
                    ", developerComment=" + developerComment +
                    '}';
        }

        public static class UserComment {
            private String text;
            private LastModified lastModified;
            private int starRating;
            private String reviewerLanguage;
            private String device;
            private int androidOsVersion;
            private int appVersionCode;
            private String appVersionName;

            public String getText() {
                return text;
            }

            public LastModified getLastModified() {
                return lastModified;
            }

            public int getStarRating() {
                return starRating;
            }

            public String getReviewerLanguage() {
                return reviewerLanguage;
            }

            public String getDevice() {
                return device;
            }

            public int getAndroidOsVersion() {
                return androidOsVersion;
            }

            public int getAppVersionCode() {
                return appVersionCode;
            }

            public String getAppVersionName() {
                return appVersionName;
            }

            @Override
            public String toString() {
                return "UserComment{" +
                        "text='" + text + '\'' +
                        ", lastModified=" + lastModified +
                        ", starRating=" + starRating +
                        ", reviewerLanguage='" + reviewerLanguage + '\'' +
                        ", device='" + device + '\'' +
                        ", androidOsVersion=" + androidOsVersion +
                        ", appVersionCode=" + appVersionCode +
                        ", appVersionName='" + appVersionName + '\'' +
                        '}';
            }
        }

        public static class DeveloperComment {
            private String text;
            private LastModified lastModified;

            public String getText() {
                return text;
            }

            public LastModified getLastModified() {
                return lastModified;
            }

            @Override
            public String toString() {
                return "DeveloperComment{" +
                        "text='" + text + '\'' +
                        ", lastModified=" + lastModified +
                        '}';
            }
        }

        public static class LastModified {
            private long seconds;
            private int nanos;

            public long getSeconds() {
                return seconds;
            }

            public int getNanos() {
                return nanos;
            }

            @Override
            public String toString() {
                return "LastModified{" +
                        "seconds=" + seconds +
                        ", nanos=" + nanos +
                        '}';
            }
        }
    }
}
