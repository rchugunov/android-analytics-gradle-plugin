package com.github.rchugunov.auth;


public class JWTClaim {
    private String iss;
    private String scope;
    private String aud;
    private long exp;
    private long iat;

    public JWTClaim() {
    }

    public JWTClaim(String iss, String scope, String aud, long exp, long iat) {
        this.iss = iss;
        this.scope = scope;
        this.aud = aud;
        this.exp = exp;
        this.iat = iat;
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAud() {
        return aud;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }

    public long getIat() {
        return iat;
    }

    public void setIat(long iat) {
        this.iat = iat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JWTClaim jwtClaim = (JWTClaim) o;

        if (exp != jwtClaim.exp) return false;
        if (iat != jwtClaim.iat) return false;
        if (iss != null ? !iss.equals(jwtClaim.iss) : jwtClaim.iss != null) return false;
        if (scope != null ? !scope.equals(jwtClaim.scope) : jwtClaim.scope != null) return false;
        return aud != null ? aud.equals(jwtClaim.aud) : jwtClaim.aud == null;

    }

    @Override
    public int hashCode() {
        int result = iss != null ? iss.hashCode() : 0;
        result = 31 * result + (scope != null ? scope.hashCode() : 0);
        result = 31 * result + (aud != null ? aud.hashCode() : 0);
        result = 31 * result + (int) (exp ^ (exp >>> 32));
        result = 31 * result + (int) (iat ^ (iat >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "JWTClaim{" +
                "iss='" + iss + '\'' +
                ", scope='" + scope + '\'' +
                ", aud='" + aud + '\'' +
                ", exp=" + exp +
                ", iat=" + iat +
                '}';
    }
}
