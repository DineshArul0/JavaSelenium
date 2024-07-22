package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserTest {
    BrowserUtility browserUtility=new BrowserUtility();
    WebDriver driver;
    @Test
    public void formAuthenticatorValidation(){

        browserUtility.initialzeBrowser();
        driver=browserUtility.driver;
        driver.manage().window().maximize();
        //click on form authenticator
        driver.findElement(By.xpath("//a[text()='Form Authentication']")).click();
        //find the username text box and enter the username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //find the password text box and enter the password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //find the login button and then click
        driver.findElement(By.cssSelector("button.radius")).click();
        //Verify the text msg succussful text msg
        //get the text
        String successMsg=driver.findElement(By.xpath("//div[@id='flash']")).getText();
        successMsg=successMsg.split("!")[0];
        String expectedMsg="You logged into a secure area";
        System.out.println("successMsg -----"+successMsg);
        System.out.println("expectedMsg -----"+expectedMsg);
        Assert.assertEquals(expectedMsg,successMsg);
        driver.navigate().back();
        //Negative scenario
        //Entering the wrong password and erify the msg
        //clear the username and type new username
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //entering the wrong passowrd
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("dfsdfsdfsdf!");
        //click on the login butoon
        driver.findElement(By.cssSelector("button.radius")).click();
        //Verify the error msg
        String errorMsg=driver.findElement(By.xpath("//div[@id='flash']")).getText();
        errorMsg=errorMsg.split("!")[0];
        expectedMsg="Your password is invalid";
        Assert.assertEquals(expectedMsg,errorMsg);
    }
}
