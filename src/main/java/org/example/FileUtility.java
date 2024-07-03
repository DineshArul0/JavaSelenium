package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.logging.Logger;

public class FileUtility {

    private String path="src/main/resources/";
    private File file;
    private Scanner scanner;
    private BufferedReader bufferedReader;
    private FileWriter writer;

    public void readtextFileUsingScanner(String FileNameInresources){
         path=path+FileNameInresources+".txt";
         file=new File(path);
        //Scanner
        try{
            scanner=new Scanner(file);
            String str="";
            while (scanner.hasNext()){
                str=scanner.nextLine();
                System.out.println(str);
            }

            scanner.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void readtextFileUsingBufferedReader(String FileNameInresources){
        String path="src/main/resources/"+FileNameInresources+".txt";
        File file=new File(path);
        //BufferedReader
        try{
            bufferedReader=new BufferedReader(new FileReader(file));
            String str=bufferedReader.readLine();
            while (str!=null){
                System.out.println(str);
                str=bufferedReader.readLine();
            }
bufferedReader.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void writedatatoFile(String fileNameinResource){
        path=path+fileNameinResource+".txt";
        file=new File(path);
        try {
            writer=new FileWriter(file,true);
            writer.write("\nWelcome");
            writer.flush();
            writer.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
