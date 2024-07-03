package org.example;

import java.io.File;

public class ExcelUtility {
//String
    private String path="src/main/resources/";
    private File file;

    public void readDataFromExcel(int row,int column){
        file=new File(path+"SuperStoreUS-2015.xlsx");
        
    }
}
