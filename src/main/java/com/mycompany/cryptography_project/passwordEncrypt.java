/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.cryptography_project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Aaron
 */
public class passwordEncrypt {

    public static byte[] generateRandomSalt(int length){
        byte[] salt = new byte[length];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(salt);
        return salt;
    } 
     
    public static String hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException{
        int iterations = 65536;
        int keyLength = 256;
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keyLength);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hash = keyFactory.generateSecret(spec).getEncoded();
        return Base64.getEncoder().encodeToString(hash);
    }
      
    
    public static IvParameterSpec generateIv(){
        byte[] iv = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        return new IvParameterSpec(iv);
    }


    public static SecretKey getKeyFromPassword(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException{
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
        SecretKey secret = new SecretKeySpec(factory.generateSecret(spec).getEncoded(),"AES");
        return secret;
    }
        

    public static void encryptFile(String algorithm, SecretKey key, IvParameterSpec iv, File inputFile, File outputFile) throws NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, FileNotFoundException, IOException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException  {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        
        try(FileInputStream inputStream = new FileInputStream(inputFile);
            FileOutputStream outputStream = new FileOutputStream(outputFile)){
            
            outputStream.write(iv.getIV());
            
            byte[] buffer = new byte[64];
            int bytesRead;
            while((bytesRead =inputStream.read(buffer)) !=-1){
                byte[] output = cipher.update(buffer, 0, bytesRead);
                if(output!=null){
                    outputStream.write(output);
                }
            }
            byte[] outputBytes = cipher.doFinal();
            if(outputBytes!=null){
                outputStream.write(outputBytes);
            }

        }
    }   
                
    
  public static void decryptFile(String algorithm, SecretKey key,
                               File inputFile, File outputFile) throws IOException, NoSuchPaddingException,
                               NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException,
                               BadPaddingException, IllegalBlockSizeException {

    try (FileInputStream inputStream = new FileInputStream(inputFile);
         FileOutputStream outputStream = new FileOutputStream(outputFile)) {

        byte[] ivBytes = new byte[16];
        int ivLength = inputStream.read(ivBytes);
        if (ivLength != 16) {
            throw new IOException("Unable to read IV from file.");
        }
        IvParameterSpec iv = new IvParameterSpec(ivBytes);

        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);

        byte[] buffer = new byte[64];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byte[] output = cipher.update(buffer, 0, bytesRead);
            if (output != null) {
                outputStream.write(output);
            }
        }
        byte[] outputBytes = cipher.doFinal();
        if (outputBytes != null) {
            outputStream.write(outputBytes);
        }
    }
}
       
        
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

