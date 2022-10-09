package com.naukma.utility;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilCore {

    public static int generateInt(int upperbound) {
        Random rand = new Random();
        //generate random values from 0-24
        return rand.nextInt(upperbound);
    }

    public static String generateString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public static boolean checkLogin(String login){
        if(login == null)
            return false;
        Pattern pat = Pattern.compile("(^[a-zA-Z0-9]{3,16}$)", Pattern.CASE_INSENSITIVE);
        Matcher mat = pat.matcher(login.trim());
        return (login.trim().length() > 0) && mat.find();
    }
}
