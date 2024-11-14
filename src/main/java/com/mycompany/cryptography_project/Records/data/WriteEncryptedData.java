package com.mycompany.cryptography_project.Records.data;

import java.io.IOException;
import java.util.ArrayList;
import com.mycompany.cryptography_project.Records.FileReadWrite;
import com.mycompany.cryptography_project.Records.RSAEncryption;
import java.nio.charset.StandardCharsets;

public class WriteEncryptedData 
{
    public static void main(String[] args) 
    {
        try 
        {
            //System.out.println(System.getProperty("user.dir"));
            String dir = "src/main/java/com/mycompany/cryptography_project/Records/data/";
            
            String jsonString = new String(FileReadWrite.readFromFile( dir + "patient_medical_records.json"));
            RSAEncryption rsa = new RSAEncryption();
            ArrayList<String> listOfData = rsa.longStringToList(jsonString);

            ArrayList<byte[]> encryptedListBytes = rsa.encryptList(listOfData);

            String encryptedData = rsa.byteListToString(encryptedListBytes);
           
            FileReadWrite.writeToFile( dir + "encryptedData.txt", encryptedData.getBytes(StandardCharsets.ISO_8859_1));

            String privateKey = rsa.getPrivateKey();

            FileReadWrite.writeToFile( dir + "privateKey.txt", privateKey.getBytes(StandardCharsets.ISO_8859_1));

            System.out.println("write successful");
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            System.exit(0);
        }
    }    
}
