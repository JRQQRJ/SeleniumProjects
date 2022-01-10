package com.selenium;

import java.util.Locale;

public class Interview {

    public static String revString(String str){
        String rev="";

//        for(int i=str.length()-1;i>=0;i--){
//           rev+=str.charAt(i);
//        }

        int strLength= str.length()-1;
        StringBuffer sb= new StringBuffer(str);
        System.out.println(sb.reverse());


        if(strLength>=0){
            rev+=str.charAt(strLength);
            strLength--;
        }

        return rev;
    }

    public static void main(String[] args) {
        System.out.println(revString("Anjali"));
    }
}
