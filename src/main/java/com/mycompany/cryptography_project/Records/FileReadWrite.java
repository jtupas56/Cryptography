package com.mycompany.cryptography_project.Records;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReadWrite 
{
    
    /* public static void main(String[] args) {
        String fileName = "output.txt";
        String content = "Hello, this is a sample text written to the file!";

        writeToFile(fileName, content);
        readFromFile(fileName);
    } */

//    public static void writeToFile(String fileName, String content) throws IOException
//    {
//        FileWriter writer = new FileWriter(fileName);
//
//        writer.write(content);
//        writer.flush();
//    }
//
//    public static String readFromFile(String fileName) throws IOException
//    {
//        FileReader reader = new FileReader(fileName);
//        BufferedReader bufferedReader = new BufferedReader(reader);
//
//        String line;
//        String output = "";
//        while ((line = bufferedReader.readLine()) != null) 
//        {
//            output += line + "\r\n";
//        }
//
//        return output;
//    }
    
        public static void writeToFile(String fileName, byte[] content) throws IOException
        {
        FileOutputStream outputStream = new FileOutputStream(fileName);
        outputStream.write(content);
        outputStream.flush();


    }

    public static byte[] readFromFile(String fileName) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(fileName);
        byte[] data = inputStream.readAllBytes();
        return data;

    }
}


