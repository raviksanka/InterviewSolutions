package com.self;

// Caesar Cipher technique - simply a type of substitution cipher.
//  each letter of a given text is replaced by a letter some fixed number of positions down the alphabet.
//    For example with a shift of 1, A would be replaced by B

class CaesarCipher {
    // Encrypts text using a shift od s 
    public static StringBuffer encrypt(String text, int s) {
        StringBuffer result= new StringBuffer();
        for (int i=0; i<text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char)(((int)text.charAt(i) + s - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char)(((int)text.charAt(i) + s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }
    // Driver code 
    public static void main(String[] args) {
        String text = "ATTACKATONCE";
        int s = 4;
        System.out.println("Text  : " + text);
        System.out.println("Shift : " + s);
        System.out.println("Cipher: " + encrypt(text, s));
    }
  
}
