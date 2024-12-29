package com.Managers;

import com.Reader.ConfigFileReader;

public class AllManagers {


    private static final ConfigFileReader reader = new ConfigFileReader();

    public AllManagers() {
    }

    public static String getUrl() {
        return reader.getURL();
    }

    public static long getTimeout() {
        return reader.getTimeout();
    }


}
