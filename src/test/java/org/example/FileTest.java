package org.example;

import org.junit.Test;

public class FileTest {

    FileUtility fileUtility=new FileUtility();
    ExcelUtility excelUtility=new ExcelUtility();
    PropertyUtility propertyUtility=new PropertyUtility();

    //@Test
    public void testReadFile(){
       // fileUtility.readtextFileUsingScanner("Deekay");
        fileUtility.readtextFileUsingBufferedReader("Deekay");
        fileUtility.writedatatoFile("Deekay");
    }

    //@Test
    public void testReadExcel(){
        excelUtility.readDataFromExcel(1,2);
    }

    //@Test
    public void readfirstRow(){
        excelUtility.getTestData();
    }

   // @Test
    public void writetoExcel(){
        excelUtility.writeData(12,"Ship Mode","Advanced Mode");
        excelUtility.writeData(14,"Customer Segment", "Private");

    }
   // @Test
    public void testPropertyUtils(){
        String testtype=propertyUtility.getProperty("TestType");
        String env=propertyUtility.getProperty("Environment");
        System.out.println("testtype   ====="+testtype);
        System.out.println("env   ====="+env);
    }
}
