package com.github.rchugunov.rest

import retrofit2.Call
import retrofit2.http.*

public interface GApiService {

    @FormUrlEncoded
    @POST("oauth2/v4/token")
    Call<GApiOAuthResponse> getTokenData(@Field("grant_type") String grantType,
                                         @Field("assertion") String jwt);

    @GET("androidpublisher/v2/applications/{package_name}/reviews")
    Call<GApiReviewsListResponse> getReviews(
            @Path("package_name") packageName, @Header("Authorization") token);


}
