/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cryptography_project;

/**
 *
 * @author adamp
 */
public class VigenereCipher {

    //encrypts text using the Vigenere Cipher with the given key
    public static String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder(); //builds encrypted string
        key = key.toUpperCase();
        
        //loops through each character from string
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) { //only encrypt alphabet letters
                if (Character.isUpperCase(c)) {
                    //encrypt formula, uppercase letters
                    result.append((char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A'));
                } else {
                    //encrypt formula, lowercase letters
                    result.append((char) ((c + key.charAt(j) - 'A' - 'a') % 26 + 'a'));
                }
                //move to next character in encrypt key, ++j increments j before modulos dividing so it only stops when outcome is 0
                j = ++j % key.length(); 
            } else {
                result.append(c); //non-alphabet characters stay the same
            }
        }
        return result.toString(); //fully encrypted string
    }

    //decrypts text using the Vigenere Cipher with the given key, almost exact same except for one line (line 49/51)
    public static String decrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toUpperCase();

        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    //decrypt formula swaps signs "-" & "+" (basically reverses process)
                    result.append((char) ((c - key.charAt(j) + 26) % 26 + 'A'));
                } else {
                    //decrypt formula swaps signs "-" & "+" (basically reverses process)
                    result.append((char) ((c - key.charAt(j) + 'A' - 'a' + 26) % 26 + 'a')); 
                }
                j = ++j % key.length();
            } else {
                result.append(c);
            }
        }
        return result.toString(); //decrypted string
    }
}