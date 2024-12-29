package com.Managers;

public class FileManager {

    private static final FileManager fileManager = new FileManager();

    private FileManager() {};

    public static FileManager getInstance() {
        return fileManager;
    }

    public AllManagers getAllManager() {
        return new AllManagers();
    }
}
