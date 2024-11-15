package com.mycompany.cryptography_project.Records;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReadWrite 
{
    //creates file using bytes to avoid any compression issue (maintain byte length)
    public static void writeToFile(String fileName, byte[] content) throws IOException
    {
        FileOutputStream outputStream = new FileOutputStream(fileName);
        outputStream.write(content);
        outputStream.flush();
    }

    //reads bytes from file
    public static byte[] readFromFile(String fileName) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(fileName);
        byte[] data = inputStream.readAllBytes();
        return data;
    }
}


