package com.qa.support;

public class EnumConstants {

    public static final int DEFAULT_VERY_EXTENDED_ELEMENT_TIMEOUT_IN_SECONDS = 120;
    public static final int DEFAULT_EXTENDED_ELEMENT_TIMEOUT_IN_SECONDS = 30;
    public static final int DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS_20 = 20;
    public static final int DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS = 10;
    public static final int DEFAULT_AD_ELEMENT_TIMEOUT_IN_SECONDS = 6;
    public static final int DEFAULT_ELEMENT_SHORT_TIMEOUT_IN_SECONDS = 5;
    public static final int DEFAULT_ELEMENT_VERY_SHORT_TIMEOUT_IN_SECONDS = 1;

    public enum Platform {
        api,ios,android
    }

    public enum MenuBar{
        Contacts,Home,Calendar
    }

}
