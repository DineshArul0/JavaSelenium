package org.example;

import org.junit.Test;

public class BrowserTest {
    BrowserUtility browserUtility=new BrowserUtility();

    @Test
    public void setupBrowsr(){
        browserUtility.initialzeBrowser();
    }
}
