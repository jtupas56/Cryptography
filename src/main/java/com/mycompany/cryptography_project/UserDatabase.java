/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cryptography_project;

/**
 *
 * @author adamp
 */
import java.util.HashMap;

public class UserDatabase {
    
    //private hashmap to store encrypted IDs & non-encrypted passwords
    private HashMap<String, String> userMap; 

    public UserDatabase() {
        userMap = new HashMap<>();
        
        //add encrypted IDs and non-encrypted passwords
        userMap.put(VigenereCipher.encrypt("ADAM123", "KEY"), "321adam");
        userMap.put(VigenereCipher.encrypt("AARON234", "KEY"), "432aaron");
        userMap.put(VigenereCipher.encrypt("DOM345", "KEY"), "543dom");
        userMap.put(VigenereCipher.encrypt("JOSH456", "KEY"), "654josh");
        userMap.put(VigenereCipher.encrypt("12ADMIN34", "KEY"), "43admin21");
    }

    //validates user login by checking if decrypted ID match and if password is correct
    public boolean validateLogin(String id, String password) {
        for (String encryptedId : userMap.keySet()) {
            //decrypt the encrypted ID to compare
            String decryptedId = VigenereCipher.decrypt(encryptedId, "KEY");
            if (decryptedId.equals(id) && userMap.get(encryptedId).equals(password)) {
                return true; //successful login
            }
        }
        return false; //invalid login
    }
}