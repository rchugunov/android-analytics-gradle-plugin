package com.github.rchugunov.android.analytics.sonar.model;


import java.util.List;

public class GApiReviewsListResponse {

    private PageInfo pageInfo;
    private TokenPagination tokenPagination;
    private List<Review> reviews;

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public TokenPagination getTokenPagination() {
        return tokenPagination;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    @Override
    public String toString() {
        return "GApiReviewsListResponse{" +
                "pageInfo=" + pageInfo +
                ", tokenPagination=" + tokenPagination +
                ", reviews=" + reviews +
                '}';
    }

    public static class PageInfo {
        private int totalResults;
        private int resultPerPage;
        private int startIndex;

        public int getTotalResults() {
            return totalResults;
        }

        public int getResultPerPage() {
            return resultPerPage;
        }

        public int getStartIndex() {
            return startIndex;
        }

        @Override
        public String toString() {
            return "PageInfo{" +
                    "totalResults=" + totalResults +
                    ", resultPerPage=" + resultPerPage +
                    ", startIndex=" + startIndex +
                    '}';
        }
    }

    public static class TokenPagination {
        private String nextPageToken;
        private String previousPageToken;

        public String getNextPageToken() {
            return nextPageToken;
        }

        public String getPreviousPageToken() {
            return previousPageToken;
        }

        @Override
        public String toString() {
            return "TokenPagination{" +
                    "nextPageToken='" + nextPageToken + '\'' +
                    ", previousPageToken='" + previousPageToken + '\'' +
                    '}';
        }
    }
}
