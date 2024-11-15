package com.mycompany.cryptography_project.Records.data;

import java.io.IOException;
import java.util.ArrayList;
import com.mycompany.cryptography_project.Records.FileReadWrite;
import com.mycompany.cryptography_project.Records.RSAEncryption;
import java.nio.charset.StandardCharsets;

//creates encrypted data
//used for updating data or reset data in case of issues with decryption
public class WriteEncryptedData 
{
    public static void main(String[] args) 
    {
        try 
        {
            //directory only valid if project run via netbeans
            String dir = "src/main/java/com/mycompany/cryptography_project/Records/data/";
            
            //reads json file
            String jsonString = new String(FileReadWrite.readFromFile( dir + "patient_medical_records.json"));
            RSAEncryption rsa = new RSAEncryption();
            //converts splits string into list
            ArrayList<String> listOfData = rsa.longStringToList(jsonString);

            //encrypts list
            ArrayList<byte[]> encryptedListBytes = rsa.encryptList(listOfData);

            //converts list back to string
            String encryptedData = rsa.byteListToString(encryptedListBytes);
           
            //converts string to bytes and stores it on text file
            //StandardCharsets.ISO_8859_1 is an encoding method that prevents byte changes in conversion
            /*
            * if default encoding and decoding is used, there will be an inconsistancy in bytes because of how special symbols
            * are converted into bytes and vise versa
            */
            FileReadWrite.writeToFile( dir + "encryptedData.txt", encryptedData.getBytes(StandardCharsets.ISO_8859_1));

            String privateKey = rsa.getPrivateKey();

            //see line 32
            FileReadWrite.writeToFile( dir + "privateKey.txt", privateKey.getBytes(StandardCharsets.ISO_8859_1));

            //confirmation message to ensure opperation is successful
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
