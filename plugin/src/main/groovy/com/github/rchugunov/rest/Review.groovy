package com.github.rchugunov.rest


class Review {
    String reviewId;
    String authorName;
    List<Comment> comments;

    String getReviewId() {
        return reviewId
    }

    String getAuthorName() {
        return authorName
    }

    List<Comment> getComments() {
        return comments
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId='" + reviewId + '\'' +
                ", authorName='" + authorName + '\'' +
                ", comments=" + comments +
                '}';
    }


    class Comment {

        UserComment userComment;
        DeveloperComment developerComment;

        UserComment getUserComment() {
            return userComment
        }

        DeveloperComment getDeveloperComment() {
            return developerComment
        }

        @Override
        public String toString() {
            return "Comment{" +
                    "userComment=" + userComment +
                    ", developerComment=" + developerComment +
                    '}';
        }


        class UserComment {
            String text;
            LastModified lastModified;
            int starRating;
            String reviewerLanguage;
            String device;
            int androidOsVersion;
            int appVersionCode;
            String appVersionName;

            int getStarRating() {
                return starRating
            }

            String getReviewerLanguage() {
                return reviewerLanguage
            }

            String getDevice() {
                return device
            }

            int getAndroidOsVersion() {
                return androidOsVersion
            }

            int getAppVersionCode() {
                return appVersionCode
            }

            String getAppVersionName() {
                return appVersionName
            }

            String getText() {
                return text
            }

            LastModified getLastModified() {
                return lastModified
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

        class DeveloperComment {
            String text;
            LastModified lastModified;

            String getText() {
                return text
            }

            LastModified getLastModified() {
                return lastModified
            }

            @Override
            public String toString() {
                return "DeveloperComment{" +
                        "text='" + text + '\'' +
                        ", lastModified=" + lastModified +
                        '}';
            }
        }

        class LastModified {
            long seconds;
            int nanos;

            long getSeconds() {
                return seconds
            }

            int getNanos() {
                return nanos
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
