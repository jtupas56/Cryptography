package com.mycompany.cryptography_project.Records;

import java.util.ArrayList;

//since java does not have a built-in class for handling json, I have made a class to handle json data
public class JSONFormatter 
{

    //this method formats a single string into and arraylist to easily access the data
    /*
    * Structure explanation:
    * First list stores rows of data (list.get(i))
    * Second list stores fields within row (list.get(i).get(j))
    * And final list seperates field name and value using array (array[0] = field name, array[1] = value)
    * 
    * because this method a single string, I used arraylist for simplicity since a normal array needs to have a predifined lenght
    */
    public static ArrayList<ArrayList<String[]>> parseList(String data)
    {
        //I got the regex values by copying and pasting from the terminal using a print statement
        
        //removes begining structure of json
        data = data.replaceAll("\\[\n    \\{", "");
        //removes ending structure of json
        data = data.replaceAll("    \\}\n\\]", "");
        //removes indentation
        data = data.replaceAll("        ", "");
        //splits data into rows
        String rows[] = data.split("\n    \\},\n    \\{\n");

        ArrayList<ArrayList<String[]>> parsedData = new ArrayList<>();

        for (String row : rows)
        {
            ArrayList<String[]> field = new ArrayList<>();
            //splits data in row into fields
            String details[] = row.split(",\n\"");

            for (String detail : details)
            {
                //removes quotation marks
                detail = detail.replaceAll("\"", "");
                //splits data within field into field name and value
                String keyValues[] = detail.split(": ");
                
                //adds field info into row info
                field.add(keyValues);
            }
            //adds row info into list
            parsedData.add(field);
        }
        
        //returns list
        return parsedData;
    }

}
