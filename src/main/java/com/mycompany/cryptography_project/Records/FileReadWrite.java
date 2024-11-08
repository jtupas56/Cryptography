package com.mycompany.cryptography_project.Records;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileReadWrite 
{
    
    /* public static void main(String[] args) {
        String fileName = "output.txt";
        String content = "Hello, this is a sample text written to the file!";

        writeToFile(fileName, content);
        readFromFile(fileName);
    } */

    public static void writeToFile(String fileName, String content) throws IOException
    {
        FileWriter writer = new FileWriter(fileName);

        writer.write(content);
        writer.flush();
    }

    public static String readFromFile(String fileName) throws IOException
    {
        FileReader reader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        String output = "";
        while ((line = bufferedReader.readLine()) != null) 
        {
            output += line + "\r\n";
        }

        return output;
    }
}


