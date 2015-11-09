package com.john.PropertyManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertyManager {
    private final static String APP_PROPERTIES_FILE = "add.properties";

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
        InputStream in = PropertyManager.class.getClassLoader().getResourceAsStream(APP_PROPERTIES_FILE);
        properties.load(in);
        in.close();
    }
}
