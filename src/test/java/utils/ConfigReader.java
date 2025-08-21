package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import base.Baseclass;
import utils.ConfigReader;

public class ConfigReader extends Baseclass{
	 private static Properties prop;

	    // Load config.properties file
	    public static void loadConfig() {
	        try {
	            FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
	            prop = new Properties();
	            prop.load(fis);
	        } catch (IOException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Failed to load config.properties file.");
	        }
	    }

	    // Get value by key
	    public static String get(String key) {
	        if (prop == null) {
	            loadConfig();
	        }
	        return prop.getProperty(key);
	    }
}
