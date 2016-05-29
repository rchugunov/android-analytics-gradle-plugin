package com.github.rchugunov.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory;


public class GApiRestClient {

    private static final ENDPOINT = "https://www.googleapis.com/"

    public GApiService service;

    private static GApiRestClient client;

    public static GApiRestClient getInstance() {
        if (client == null) {
            client = new GApiRestClient()
        }
        return client
    }

    private GApiRestClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(GApiService.class);
    }

    GApiService getService() {
        return service
    }
}
