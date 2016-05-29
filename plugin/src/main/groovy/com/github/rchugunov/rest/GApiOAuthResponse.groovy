package com.github.rchugunov.rest

import com.google.gson.annotations.SerializedName

public class GApiOAuthResponse {
    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("token_type")
    private String tokenType;
    @SerializedName("expires_in")
    private int expiresIn;

    String getAccessToken() {
        return accessToken
    }

    void setAccessToken(String accessToken) {
        this.accessToken = accessToken
    }

    String getTokenType() {
        return tokenType
    }

    void setTokenType(String tokenType) {
        this.tokenType = tokenType
    }

    int getExpiresIn() {
        return expiresIn
    }

    void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        GApiOAuthResponse that = (GApiOAuthResponse) o

        if (expiresIn != that.expiresIn) return false
        if (accessToken != that.accessToken) return false
        if (tokenType != that.tokenType) return false

        return true
    }

    int hashCode() {
        int result
        result = (accessToken != null ? accessToken.hashCode() : 0)
        result = 31 * result + (tokenType != null ? tokenType.hashCode() : 0)
        result = 31 * result + expiresIn
        return result
    }

    @Override
    public String toString() {
        return "GApiOAuthResponse{" +
                "accessToken='" + accessToken + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", expiresIn=" + expiresIn +
                '}';
    }
}
