package com.qa.support;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigProperties {

    GetDefaults getDefaults = new GetDefaults();

    public String getPropertyValue(String property) {
        String propertyValue = "";
        Properties prop = new Properties();
        InputStream input = null;
        try {
            String filename = getDefaults.getEnvironment()+"_config.properties";
            input = getClass().getClassLoader().getResourceAsStream(filename);
            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);
                return filename;
            }
            prop.load(input);
            if(property.equals("url")){
                if(getDefaults.getLanguage().equals("es")) {
                    propertyValue = prop.getProperty("es_url");
                }
            }else{
                propertyValue = prop.getProperty(property);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return propertyValue;
    }

}