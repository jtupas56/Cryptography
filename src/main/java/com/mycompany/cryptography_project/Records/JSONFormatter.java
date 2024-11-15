package com.mycompany.cryptography_project.Records;

import java.util.ArrayList;

public class JSONFormatter 
{

    //since java does not have a built-in class for handling json, I have
    public static ArrayList<ArrayList<String[]>> parseList(String data)
    {
        data = data.replaceAll("\\[\n    \\{", "");
        data = data.replaceAll("    \\}\n\\]", "");
        data = data.replaceAll("        ", "");
        String rows[] = data.split("\n    \\},\n    \\{\n");

        ArrayList<ArrayList<String[]>> parsedData = new ArrayList<>();

        for (String row : rows)
        {
            ArrayList<String[]> field = new ArrayList<>();
            String details[] = row.split(",\n\"");

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

}
