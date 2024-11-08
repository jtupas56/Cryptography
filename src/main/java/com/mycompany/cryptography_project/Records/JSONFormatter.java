package com.mycompany.cryptography_project.Records;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class JSONFormatter 
{
    
    private static void addTableValues() throws IOException
    {
        String data = FileReadWrite.readFromFile("patient_medical_records.json");
        data = data.replaceAll("\\[\r\n    \\{\r\n        ", "");
        data = data.replaceAll("\r\n    \\}\r\n\\]\r\n", "");
        data = data.replaceAll("        ", "");
        String rows[] = data.split("\r\n    \\},\r\n    \\{\r\n");

        /* ArrayList<HashMap<String, String>> parsedData = new ArrayList<>();

        for (String row : rows)
        {
            String details[] = row.split(",\"");
            HashMap<String, String> map = new HashMap<>();

            for (String detail : details)
            {
                detail = detail.replaceAll("\"", "");
                String keyValues[] = detail.split(": ");
                
                map.put(keyValues[0], keyValues[1]);
            }
            parsedData.add(map);
        }
        HashMap<String, String> map = parsedData.get(0);
        
        for (String key : map.keySet())
        {
            System.out.println(key + ": " + map.get(key));
        } */

        //todo
    }

    public static void main(String[] args) 
    {
        try
        {

            System.out.println(FileReadWrite.readFromFile("patient_medical_records.json"));
            
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
