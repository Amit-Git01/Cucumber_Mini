package com.Reader;

import com.Constants.DriverType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;

    public ConfigFileReader() {
        String filePath = "src/main/resources/config.properties";

        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            properties = new Properties();
            properties.load(fis);
            fis.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found in the path : " + filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public DriverType getBrowserType() {
        String browser = properties.getProperty("browser");
        return switch (browser) {
            case "chrome" -> DriverType.CHROME;
            case "edge" -> DriverType.EDGE;
            case "firefox" -> DriverType.FIREFOX;
            default -> throw new RuntimeException("Browser not match with config browser : " + browser);
        };
    }

    public String getURL() {
        String url = properties.getProperty("url");
        if(url != null)
            return url;
        else
            throw new RuntimeException("Url not found in config file");
    }

    public long getTimeout() {
        String timeout = properties.getProperty("timeout");
        if (timeout != null) {
            return Long.parseLong(timeout);
        } else {
            throw new RuntimeException("timeout not specified in the config file");
        }
    }

}
