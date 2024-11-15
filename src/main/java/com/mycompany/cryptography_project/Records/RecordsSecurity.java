package com.mycompany.cryptography_project.Records;

import com.mycompany.cryptography_project.Records.FileReadWrite;
import com.mycompany.cryptography_project.Records.RSAEncryption;
import com.mycompany.cryptography_project.Records.JSONFormatter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

//this class handles data retrieval for the records
public class RecordsSecurity
{

    public static ArrayList<ArrayList<String[]>> retrieveData() throws IOException, Exception
    {
        //sets directory
        //note: this directory is only valid if the project is run via netbeans
        String dir = "src/main/java/com/mycompany/cryptography_project/Records/data/";
        //retrives private key from text file
        byte[] privateKey = FileReadWrite.readFromFile(dir + "privateKey.txt");

        //retrives encrypted data from text file
        byte[] encryptedData = FileReadWrite.readFromFile(dir + "encryptedData.txt");

        //instatiates class for decryption
        RSAEncryption rsa = new RSAEncryption(new String(privateKey));

        //converts the bytes into string then splits the data into list
        //StandardCharsets.ISO_8859_1 is an encoding method that prevents byte changes in conversion
        /*
        * if default encoding and decoding is used, there will be an inconsistancy in bytes because of how special symbols
        * are converted into bytes and vise versa
        */
        ArrayList<String> encryptedList = rsa.longStringToList(new String(encryptedData, StandardCharsets.ISO_8859_1), true);

        //converts string list to byte list
        ArrayList<byte[]> encryptedByteList = rsa.listToByteList(encryptedList);

        //decrypts list
        ArrayList<String> decryptedData = rsa.decryptList(encryptedByteList);

        //converts list into single string
        String stringData = rsa.listToLongString(decryptedData);

        //formats json data into list of data
        //see JSONFormatter.java for more info
        ArrayList<ArrayList<String[]>> data = JSONFormatter.parseList(stringData);

        return data;
    }
}
