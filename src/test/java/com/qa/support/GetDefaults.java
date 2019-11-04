package com.qa.support;

import java.util.Properties;

public class GetDefaults {

    public String getBrowserType() {return getValueOrDefault(System.getProperty("browser"), "chrome"); }

    public String getEnvironment() {return getValueOrDefault(System.getProperty("environment"), "test"); }

    public String getLanguage() {return getValueOrDefault(System.getProperty("language"), "es"); }

    public Properties getBrowserStackProps() {
        Properties prop = new Properties();
        if (getBrowserType().contains("browserstack-ie")){
            prop.setProperty("browserStackBroswer", "InternetExplorer");
            prop.setProperty("browserStackVersion", "11");
            prop.setProperty("browserStackPlatform", "WINDOWS");
        }else {
            prop.setProperty("browserStackBroswer", "chrome");
            prop.setProperty("browserStackVersion", "58");
            prop.setProperty("browserStackPlatform", "MAC");
        }
        return prop;
    }

    private static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    private static String getValueOrDefault(String value, String defaultValue) {
        return isNullOrEmpty(value) ? defaultValue : value;
    }

}