package com.github.rchugunov.rest


class Review {
    String reviewId;

    String getReviewId() {
        return reviewId
    }


    @Override
    public String toString() {
        return "Review{" +
                "reviewId='" + reviewId + '\'' +
                '}';
    }
}
