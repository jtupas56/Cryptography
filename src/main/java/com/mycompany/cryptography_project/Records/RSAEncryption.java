package com.mycompany.cryptography_project.Records;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;

import javax.crypto.Cipher;

public class RSAEncryption {

    private static PublicKey publicKey = null;
    private static PrivateKey privateKey = null;
    private static Cipher cipher;
    private static boolean decryptionOnly = false;

    public RSAEncryption() throws Exception 
    {
        init();
    }

    public RSAEncryption(String key) throws Exception
    {
        setPrivateKey(key);
        cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        decryptionOnly = true;
    }

    /* public static void main(String args[]) throws Exception {
        init();
        String jsonString = JSONReader.readJsonFromFile("patient_medical_records.json");
        System.out.println(jsonString);
        /*
         * jsonString = jsonString.replaceAll(" ", "?");
         * ArrayList<byte[]> encryptedData = encryptList(longStringToList(jsonString));
         * ArrayList<String> decryptedData = decryptList(encryptedData);
         * System.out.println(decryptedData.get(0).replaceAll("\\?", " "));
         *
    } */

    private void init() throws Exception {
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
        // System.out.println(new String(cipherText, "UTF8"));

        // Initializing the same cipher for decryption
        // cipher.init(Cipher.DECRYPT_MODE, privateKey);

        // Decrypting the text
        // byte[] decipheredText = cipher.doFinal(cipherText);

        return (cipherText);
    }

    public String decryptData(byte[] encryptedData) throws Exception {

        // Initializing the same cipher for decryption
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        // Decrypting the text
        byte[] decipheredText = cipher.doFinal(encryptedData);
        return new String(decipheredText);
    }

    public ArrayList<byte[]> encryptList(ArrayList<String> list) throws Exception {
        ArrayList<byte[]> encryptedList = new ArrayList<>();

        for (String value : list) {
            encryptedList.add(encryptData(value));
        }

        return encryptedList;
    }

    public ArrayList<String> decryptList(ArrayList<byte[]> encryptedList) throws Exception {
        ArrayList<String> decryptedList = new ArrayList<>();

        for (byte value[] : encryptedList) {
            decryptedList.add(decryptData(value));
        }

        return decryptedList;
    }

    public ArrayList<String> longStringToList(String data) {
        ArrayList<String> list = new ArrayList<>();

        String currentString = "";
        int bytesUsed = 0;
        for (int charIndex = 0; charIndex < data.length(); charIndex++) {
            if (bytesUsed == 245) {
                list.add(currentString);
                currentString = "";
                bytesUsed = 0;
            }

            currentString += Character.toString(data.charAt(charIndex));
            bytesUsed++;
        }
        list.add(currentString);
        return list;
    }

    public String listToLongString(ArrayList<String> list) {
        String output = "";
        for (String value : list) {
            output += value;
        }
        return output;
    }

    public String getPrivateKey() 
    {
        // Encode the private key's bytes to Base64
        return Base64.getEncoder().encodeToString(privateKey.getEncoded());
    }

    private void setPrivateKey(String keyString) throws Exception 
    {
        // Decode the Base64 string to get private key bytes
        byte[] keyBytes = Base64.getDecoder().decode(keyString);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);

        // Use KeyFactory to recreate the private key
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        privateKey = keyFactory.generatePrivate(keySpec);
    }

    public String byteListToString(ArrayList<byte[]> encryptedList)
    {
        String output = "";

        for (byte[] value : encryptedList)
        {
            output += new String(value);
        }

        return output;
    }

}
