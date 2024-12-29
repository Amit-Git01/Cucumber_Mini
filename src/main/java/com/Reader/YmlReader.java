package com.Reader;

import com.Constants.LocatorType;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class YmlReader {

    Map<?, ?> locators;

    public YmlReader() {
        String path = "src/main/resources/locators.yml";
        try {
            FileInputStream fis = new FileInputStream(new File(path));
            Yaml yml = new Yaml();
            locators = yml.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String[] readYml(String page, String elementName) {

        Map<String, String> key = (Map<String, String>) ((Map<String, Object>) locators.get(page))
                .get(elementName);
        String type = key.get("type");
        String value = key.get("value");
        String name = key.get("name");

//        System.out.println(type + " " + value);
        return new String[]{type, value, name};
    }

    public LocatorType getLocatorType(String page, String elementName) {

        String[] values = readYml(page, elementName);
        String type = values[0];
        String name = values[2];

        return switch (type) {
            case "id" -> LocatorType.ID;
            case "xpath" -> LocatorType.XPATH;
            case "cssSelector" -> LocatorType.CSS_SELECTOR;
            case "tagName" -> LocatorType.TAG_NAME;
            case "linkText" -> LocatorType.LINK_TEXT;
            case "className" -> LocatorType.CLASS_NAME;
            case "name" -> LocatorType.NAME;
            case "partialLinkText" -> LocatorType.PARTIAL_LINK_TEXT;
            default -> throw new RuntimeException("Locator not specified in file : " + type + " "+ name);
        };
    }

    public String getLocatorValue(String page, String elementName) {
        String[] values = readYml(page, elementName);
        return values[1];
    }


}
