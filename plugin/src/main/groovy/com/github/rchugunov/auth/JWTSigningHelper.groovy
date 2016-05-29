package com.github.rchugunov.auth

import com.google.api.client.googleapis.auth.oauth2.OAuth2Utils
import com.google.api.client.util.PemReader
import com.google.api.client.util.SecurityUtils
import com.google.api.client.util.StringUtils
import com.google.gson.Gson

import java.security.KeyFactory
import java.security.NoSuchAlgorithmException
import java.security.PrivateKey
import java.security.Signature
import java.security.spec.InvalidKeySpecException
import java.security.spec.PKCS8EncodedKeySpec

public class JWTSigningHelper {
    private final static String JWT_HEADER = "{\"alg\":\"RS256\",\"typ\":\"JWT\"}";
    private final static String JWT_HEADER_BASE64 = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9";

    private final static String TOKEN_URI = "https://www.googleapis.com/oauth2/v4/token";
    private final static String SCOPES = "https://www.googleapis.com/auth/androidpublisher " +
            "https://www.googleapis.com/auth/analytics.readonly";

    private final JWTClaim claim;
    private final Closure<String> privateKey;
    private Gson gson;

    JWTSigningHelper(String clientEmail, Closure<String> privateKey) {
        claim = new JWTClaim(clientEmail,
                SCOPES,
                TOKEN_URI,
                (long) (System.currentTimeMillis() / 1000 + 1800),
                (long) (System.currentTimeMillis() / 1000))
        this.privateKey = privateKey;
        this.gson = new Gson();
    }

    public String getSignatureBase64() throws NoSuchAlgorithmException, IOException {
        Base64.Encoder encoder = Base64.getEncoder();
        String claim = gson.toJson(claim);
        byte[] claimBase64 = encoder.encode(claim.getBytes())

        String shortCleanSignature = JWT_HEADER_BASE64 + "." + new String(claimBase64, "UTF-8")
        byte[] data = StringUtils.getBytesUtf8(shortCleanSignature);
        Signature signature = getSha256WithRsaSignatureAlgorithm();
        PrivateKey privateKey = privateKeyFromPkcs8(this.privateKey.call())
        signature.initSign(privateKey)
        signature.update(data)
        byte[] lastPartSignature = signature.sign()

        return shortCleanSignature + "." + encoder.encodeToString(lastPartSignature)
    }

    public static Signature getSha256WithRsaSignatureAlgorithm() throws NoSuchAlgorithmException {
        return Signature.getInstance("SHA256withRSA");
    }

    private static PrivateKey privateKeyFromPkcs8(String privateKeyPem) throws IOException {
        Reader reader = new StringReader(privateKeyPem);
        PemReader.Section section = PemReader.readFirstSectionAndClose(reader, "PRIVATE KEY");
        if (section == null) {
            throw new IOException("Invalid PKCS8 data.");
        }
        byte[] bytes = section.getBase64DecodedBytes();
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
        Exception unexpectedException = null;
        try {
            KeyFactory keyFactory = SecurityUtils.getRsaKeyFactory();
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
            return privateKey;
        } catch (NoSuchAlgorithmException exception) {
            unexpectedException = exception;
        } catch (InvalidKeySpecException exception) {
            unexpectedException = exception;
        }
        throw OAuth2Utils.exceptionWithCause(
                new IOException("Unexpected exception reading PKCS data"), unexpectedException);
    }

    JWTClaim getClaim() {
        return claim
    }
}
