package com.mycompany.cryptography_project.Records;

import java.io.IOException;
import java.util.ArrayList;

public class JSONFormatter 
{
    private static String dir = "src/main/java/com/mycompany/cryptography_project/Records/data/";
    
    public static ArrayList getJSONData() throws IOException
    {
        String data = FileReadWrite.readFromFile( dir + "patient_medical_records.json");
        data = data.replaceAll("\\[\r\n    \\{\r\n        ", "");
        data = data.replaceAll("\r\n    \\}\r\n\\]\r\n", "");
        data = data.replaceAll("        ", "");
        String rows[] = data.split("\r\n    \\},\r\n    \\{\r\n");

        ArrayList<ArrayList<String[]>> parsedData = new ArrayList<>();

        for (String row : rows)
        {
            ArrayList<String[]> field = new ArrayList<>();
            String details[] = row.split(",\r\n\"");

            for (String detail : details)
            {
                detail = detail.replaceAll("\"", "");
                String keyValues[] = detail.split(": ");
                
                field.add(keyValues);
            }
            parsedData.add(field);
        }
        
        return parsedData;
    }

    public static void main(String[] args) 
    {
        try
        {

            getJSONData();
            
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
