package org.example;

import java.io.FileReader;
import java.util.Properties;

public class PropertyUtility {
    private String path="src/main/resources/";
    private FileReader reader;
    private Properties properties;

    public String getProperty(String key){
        String value="";
        try{
            reader=new FileReader(path+"property.properties");
            properties=new Properties();
            properties.load(reader);
        }catch (Exception e){
            System.out.println(e);
        }
        value=properties.getProperty(key);
        return value;
    }
}
