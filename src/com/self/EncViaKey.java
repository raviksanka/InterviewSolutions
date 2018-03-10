package com.self;

public class EncViaKey {
	
	public static void main(String[] args) {
		System.out.println(secureChannel(2, "Oppeeened", "123"));
	}
	
	static String secureChannel(int operation, String message, String key) {
        if (!(operation == 1 || operation == 2))  {
            // Invalid operation to perform
            return "-1";
        } 
        if(message == null || message.trim().equals("")) {
            // No message to encode or decode
            return "-1";
        }
        StringBuilder output = new StringBuilder();
        char[] msgCharArr = message.toCharArray();
        int i = msgCharArr.length;
        char[] keyCharArr = key.toCharArray();
        int j = keyCharArr.length;
        if(operation == 1) {
            for(int k = 0; k<j && k<i;k++) {
                output.append(new String(new char[Character.getNumericValue(keyCharArr[k])]).replace("\0", String.valueOf(msgCharArr[k])));
            }
            if(j<i) {
                output.append(message.substring(j));
            }
        } else {
            int k = 0;
            for(char c:keyCharArr) {
                if(k<i) {
                    output.append(msgCharArr[k]);
                }
                k+=Character.getNumericValue(c);
            }
            if(k<i) {
                output.append(message.substring(k));
            }
        }
        return output.toString();
    }

}
