package com.github.rchugunov.android.analytics.sonar.model


class GApiReviewsListResponse {

    PageInfo pageInfo;
    TokenPagination tokenPagination;
    List<Review> reviews;

    PageInfo getPageInfo() {
        return pageInfo
    }

    TokenPagination getTokenPagination() {
        return tokenPagination
    }

    List<Review> getReviews() {
        return reviews
    }

    @Override
    public String toString() {
        return "GApiReviewsListResponse{" +
                "pageInfo=" + pageInfo +
                ", tokenPagination=" + tokenPagination +
                ", reviews=" + reviews +
                '}';
    }

    class PageInfo {
        int totalResults;
        int resultPerPage;
        int startIndex;

        int getTotalResults() {
            return totalResults
        }

        int getResultPerPage() {
            return resultPerPage
        }

        int getStartIndex() {
            return startIndex
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

    class TokenPagination {
        String nextPageToken;
        String previousPageToken;

        String getNextPageToken() {
            return nextPageToken
        }

        String getPreviousPageToken() {
            return previousPageToken
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
