package org.example;

import org.junit.Test;

public class FileTest {

    FileUtility fileUtility=new FileUtility();
    ExcelUtility excelUtility=new ExcelUtility();

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

    @Test
    public void writetoExcel(){
        excelUtility.writeData(1,"","");
    }
}
