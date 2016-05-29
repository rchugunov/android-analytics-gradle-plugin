package com.github.rchugunov.rest

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

public interface GApiService {

    @FormUrlEncoded
    @POST("oauth2/v4/token")
    Call<GApiOAuthResponse> getTokenData(@Field("grant_type") String grantType,
                                         @Field("assertion") String jwt);
}
