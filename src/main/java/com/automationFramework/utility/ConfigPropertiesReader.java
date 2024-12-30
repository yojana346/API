package com.automationFramework.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertiesReader {
    public Properties initializeProperties(){
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream
                    ("src\\test\\resources\\config\\config.properties");
                properties.load(fis);
        } catch (IOException e) {
           e.getMessage();
        }
        return properties;
    }
}
