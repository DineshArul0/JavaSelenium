package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserUtility {
    public WebDriver driver;
    //manual way of gettting the driver
    //automatic way of getting the driver

    //manual
    public void initialzeBrowser(){
        String path="src/main/resources/drivers/";
        System.setProperty("webdriver.chrome.driver",path+"chromedriver.exe");
        driver=new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }
}
