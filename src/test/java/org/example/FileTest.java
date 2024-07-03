package org.example;

import org.junit.Test;

public class FileTest {

    FileUtility fileUtility=new FileUtility();

    @Test
    public void testReadFile(){
       // fileUtility.readtextFileUsingScanner("Deekay");
        fileUtility.readtextFileUsingBufferedReader("Deekay");
        fileUtility.writedatatoFile("Deekay");
    }
}
