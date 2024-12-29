package com.Models;

import com.Managers.FileManager;
import org.openqa.selenium.WebDriver;

public class TestBase {

    public WebDriver driver;

    FileManager fileManager;
    public TestBase() {
        this.driver = FileManager.getInstance().getAllManager().createLocalDriver();
    }
}
