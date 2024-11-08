package com.mycompany.cryptography_project.Records;

import com.mycompany.cryptography_project.Records.FileReadWrite;
import com.mycompany.cryptography_project.Records.RSAEncryption;
import com.mycompany.cryptography_project.Records.JSONFormatter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class RecordsSecurity
{

    public static ArrayList<ArrayList<String[]>> retrieveData() throws IOException, Exception
    {
        String dir = "src/main/java/com/mycompany/cryptography_project/Records/data/";
        byte[] privateKey = FileReadWrite.readFromFile(dir + "privateKey.txt");

        byte[] encryptedData = FileReadWrite.readFromFile(dir + "encryptedData.txt");

        RSAEncryption rsa = new RSAEncryption(new String(privateKey));

        ArrayList<String> encryptedList = rsa.longStringToList(new String(encryptedData, StandardCharsets.ISO_8859_1), true);

        ArrayList<byte[]> encryptedByteList = rsa.listToByteList(encryptedList);

        ArrayList<String> decryptedData = rsa.decryptList(encryptedByteList);

        String stringData = rsa.listToLongString(decryptedData);

        ArrayList<ArrayList<String[]>> data = JSONFormatter.parseList(stringData);

        return data;
    }
}
