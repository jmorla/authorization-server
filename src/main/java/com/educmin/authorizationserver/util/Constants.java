package com.educmin.authorizationserver.util;

public class Constants {

    /**
     * Educmin web client credentials
     * */
    public static final String CLIENT_ID = "helpdesk-web";
    public static final String CLIENT_PASSWORD = "s3cr3t@1";
    public static final String GRANT_TYPE = "password";
    public static final String[] SCOPES = {"read", "write"};
    public static final Integer EXPIRATION_TIME = 3600;
}
