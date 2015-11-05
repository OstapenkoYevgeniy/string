package com.john.PropertyManager;


import com.john.App;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertyManager {
    private final static String DEFAULT_PROPERTIES_FILE = "default.properties";
    private final static String REGEX_PROPERTIES_FILE = "regex.properties";

    public static PropertyManager instance = null;
    private Properties properties = new Properties();

    private PropertyManager() {
    }

    public static PropertyManager getInstance() throws IOException {
        if (instance == null) {
            instance = new PropertyManager();
            instance.loadProperties();
        }
        return (instance);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    private void loadProperties() throws IOException {
        InputStream in = App.class.getClassLoader().getResourceAsStream(DEFAULT_PROPERTIES_FILE);
        properties.load(in);
        in.close();

        in = App.class.getClassLoader().getResourceAsStream(REGEX_PROPERTIES_FILE);
        properties.load(in);
        in.close();
    }
}
