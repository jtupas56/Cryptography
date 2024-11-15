package com.mycompany.cryptography_project.Records;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;

import javax.crypto.Cipher;

public class RSAEncryption
{

    private static PublicKey publicKey = null;
    private static PrivateKey privateKey = null;
    private static Cipher cipher;
    private static boolean decryptionOnly = false;

    public RSAEncryption() throws Exception
    {
        init();
    }

    //instatiated class used for decrypting purposes only with set private key
    public RSAEncryption(String privateKey) throws Exception
    {
        setPrivateKey(privateKey);
        cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        decryptionOnly = true;
    }

    //generates keys and cipher
    private void init() throws Exception
    {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

        // Initializing the key pair generator
        keyPairGen.initialize(2048);

        // Generating the pair of keys
        KeyPair pair = keyPairGen.generateKeyPair();

        publicKey = pair.getPublic();
        privateKey = pair.getPrivate();

        // Creating a Cipher object
        cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    }

    public byte[] encryptData(String jsonData) throws Exception
    {
        //fail safe to prevent improper use of class
        //this satement can be ignored if code is unchanged
        if (decryptionOnly)
        {
            throw new Exception("Class initialised using private key is for decryption purposed only, use default initialisation instead for encryption");
        }
        // Initializing a Cipher object
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        // Adding data to the cipher
        byte[] input = jsonData.getBytes();
        cipher.update(input);

        // encrypting the data
        byte[] cipherText = cipher.doFinal();

        return cipherText;
    }

    public String decryptData(byte[] encryptedData) throws Exception
    {
        // Initializing the same cipher for decryption
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        // Decrypting the text
        byte[] decipheredText = cipher.doFinal(encryptedData);
        
        return new String(decipheredText);
    }

    //encrypts a list of data
    public ArrayList<byte[]> encryptList(ArrayList<String> list) throws Exception
    {
        ArrayList<byte[]> encryptedList = new ArrayList<>();

        for (String value : list)
        {
            encryptedList.add(encryptData(value));
        }

        return encryptedList;
    }

    //decrypts a list of data
    public ArrayList<String> decryptList(ArrayList<byte[]> encryptedList) throws Exception
    {
        ArrayList<String> decryptedList = new ArrayList<>();

        for (byte value[] : encryptedList)
        {
            decryptedList.add(decryptData(value));
        }

        return decryptedList;
    }
    
    //default method if second argument left empty
    public ArrayList<String> longStringToList(String data)
    {
        return longStringToList(data, false);
    }

    //there is a byte limit for encryption and decryption, so this method splits the string into a list
    //encytion has 245 byte limit
    //decryption has 256 byte limit
    public ArrayList<String> longStringToList(String data, boolean isEncryptedData)
    {
        int maxBytes = 245;
        
        if (isEncryptedData)
        {
            maxBytes = 256;
        }
        ArrayList<String> list = new ArrayList<>();

        String currentString = "";
        int bytesUsed = 0;
        //loops through each character in the string
        for (int charIndex = 0; charIndex < data.length(); charIndex++)
        {
            //if the string has reached the max byte length, then it is added to the list
            if (bytesUsed >= maxBytes)
            {
                list.add(currentString);
                currentString = "";
                bytesUsed = 0;
            }

            //adds character to new string
            currentString += Character.toString(data.charAt(charIndex));
            //updates number of bytes used by string
            //StandardCharsets.ISO_8859_1 is an encoding method that prevents byte changes in conversion
            /*
            * if default encoding and decoding is used, there will be an inconsistancy in bytes because of how special symbols
            * are converted into bytes and vise versa
            */
            bytesUsed = currentString.getBytes(StandardCharsets.ISO_8859_1).length;
        }
        list.add(currentString);
        return list;
    }

    //converts list to a single string, used for stoing data into a file
    public String listToLongString(ArrayList<String> list)
    {
        String output = "";
        for (String value : list)
        {
            output += value;
        }
        return output;
    }

    //returns string version of private key for storage
    public String getPrivateKey()
    {
        // Encode the private key's bytes to Base64
        return Base64.getEncoder().encodeToString(privateKey.getEncoded());
    }

    //converts private key string into correct data type and stores it in global variable
    private void setPrivateKey(String keyString) throws Exception
    {
        // Decode the Base64 string to get private key bytes
        byte[] keyBytes = Base64.getDecoder().decode(keyString);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);

        // Use KeyFactory to recreate the private key
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        privateKey = keyFactory.generatePrivate(keySpec);
    }

    //converts list of bytes into a single string
    public String byteListToString(ArrayList<byte[]> encryptedList)
    {
        String output = "";

        for (byte[] value : encryptedList)
        {
            //converts bytes to string
            //see line 147 for encoding/decoding info
            output += new String(value, StandardCharsets.ISO_8859_1);
        }

        return output;
    }

    //converts values in list from string to bytes
    public ArrayList<byte[]> listToByteList(ArrayList<String> list) throws Exception
    {
        ArrayList<byte[]> byteList = new ArrayList<>();

        for (String value : list)
        {
            //see line 147 for encoding/decoding info
            byteList.add(value.getBytes(StandardCharsets.ISO_8859_1));
        }

        return byteList;
    }

}
