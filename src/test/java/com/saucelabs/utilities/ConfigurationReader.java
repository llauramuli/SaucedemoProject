package com.saucelabs.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    public static Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("./src/test/resources/configuration.properties");
            properties.load(file);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
