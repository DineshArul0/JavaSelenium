package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class ExcelUtility {
//String
    private String path="src/main/resources/";
    private File file;
    private FileInputStream fis;
    private Workbook workbook;
    DataFormatter formatter=new DataFormatter();


    public void readDataFromExcel(int rownum,int columnnum){
        file=new File(path+"SuperStoreUS-2015.xlsx");
        try{
            fis=new FileInputStream(file);
            workbook=new XSSFWorkbook(fis);
        }catch (Exception e){
            System.out.println(e);
        }
        Sheet sheet=workbook.getSheetAt(0);
        Row row=sheet.getRow(rownum);
        Cell cell=row.getCell(columnnum);
        String cellvalue=formatter.formatCellValue(cell);
        System.out.println(cellvalue);

    }
//map {(key,value),(key2,value2)}
    public List<LinkedHashMap<String,String>> getTestData(){
        //  will take each row as a list
        // each list will have a map key as first row and value as  te correcspoding row
        List<LinkedHashMap<String,String>> testData=new LinkedList<LinkedHashMap<String,String>>();
        List<String> firstRow=new LinkedList<>();

        file=new File(path+"SuperStoreUS-2015.xlsx");
        try{
            fis=new FileInputStream(file);
            workbook=new XSSFWorkbook(fis);
        }catch (Exception e){
            System.out.println(e);
        }

        Sheet sheet=workbook.getSheet("Orders");
        Row row;
        Cell cell;
        Iterator rowiterator= sheet.rowIterator();
        Iterator celliterator;
        while (rowiterator.hasNext()){
            row= (Row) rowiterator.next();
            celliterator=row.cellIterator();
            while (celliterator.hasNext()){
                firstRow.add(formatter.formatCellValue((Cell) celliterator.next()));
            }
            break;
        }
        int count=0;
        rowiterator= sheet.rowIterator();
        rowiterator.next();
        while (rowiterator.hasNext()){
            if(count==10){
               break;
            }
            LinkedHashMap<String,String> restrow=new LinkedHashMap<String,String>();
            row= (Row) rowiterator.next();
            celliterator=row.cellIterator();
            int firstrowindex=0;
            while (celliterator.hasNext()){
                cell= (Cell) celliterator.next();
                String cellvalue=formatter.formatCellValue(cell);
                restrow.put(firstRow.get(firstrowindex),cellvalue);
                firstrowindex++;
            }
            count++;
            testData.add(restrow);
        }
    for(LinkedHashMap<String,String> map:testData){
        System.out.println(map);
    }
     return testData;
    }

    public void writeData(){
        file=new File(path+"SuperStoreUS-2015.xlsx");
        try{
            fis=new FileInputStream(file);
            workbook=new XSSFWorkbook(fis);
        }catch (Exception e){
            System.out.println(e);
        }

        Sheet sheet=workbook.getSheet("Orders");
        Row row;
        Cell cell;

        row=sheet.getRow(10);
        LinkedList<String> rowvalues=new LinkedList<>();
        Iterator cellItereator=row.cellIterator();
        while (cellItereator.hasNext()){
            cell= (Cell) cellItereator.next();
            rowvalues.add(formatter.formatCellValue(cell));
        }

        row=sheet.createRow(2);
        int count=0;
        for(String eachvalue:rowvalues){
//            if(count==2){
//                eachvalue="changed value";
//            }
            cell=row.createCell(count);
            cell.setCellValue(eachvalue);
            count++;
        }
        try {
            FileOutputStream fos=new FileOutputStream(file);
            workbook.write(fos);
            fos.close();
            workbook.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void writeData(int rowtobemodified, String columnHeader, String value){
        file=new File(path+"SuperStoreUS-2015.xlsx");
        try{
            fis=new FileInputStream(file);
            workbook=new XSSFWorkbook(fis);
        }catch (Exception e){
            System.out.println(e);
        }

        Sheet sheet=workbook.getSheet("Orders");
        Row row;
        Cell cell;

        row=sheet.getRow(rowtobemodified);
        LinkedList<String> rowvalues=new LinkedList<>();
        Iterator cellItereator=row.cellIterator();
        while (cellItereator.hasNext()){
            cell= (Cell) cellItereator.next();
            rowvalues.add(formatter.formatCellValue(cell));
        }
        LinkedList<String> firstrow=new LinkedList<>();
        row =sheet.getRow(0);
        cellItereator=row.cellIterator();
        while (cellItereator.hasNext()){
            cell= (Cell) cellItereator.next();
            firstrow.add(formatter.formatCellValue(cell));
        }
        row=sheet.createRow(rowtobemodified);
        String writevalue="";
        for(int i=0;i<rowvalues.size();i++){
            writevalue=rowvalues.get(i);
            if(firstrow.get(i).equalsIgnoreCase(columnHeader)) {
                writevalue = value;
            }
            cell=row.createCell(i);
            cell.setCellValue(writevalue);
        }
        try {
            FileOutputStream fos=new FileOutputStream(file);
            workbook.write(fos);
            fos.close();
            workbook.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }


}
