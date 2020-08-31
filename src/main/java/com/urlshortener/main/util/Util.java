package com.urlshortener.main.util;

public class Util {
    private static final String CHAR_SEQ = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String convertDecimalToBase62(long n) {
        String base62 = "";
        while (n > 0) {
            long rem = n % 62;
            if (rem >= 0 && rem <= 9) {
                base62 = rem + base62;
            } else if (rem >= 10 && rem <= 35) {
                base62 = (char) (rem - 10 + 'a') + base62;
            } else {
                base62 = (char) (rem - 36 + 'A') + base62;
            }
            n = n / 62;
        }
        return base62;
    }

    public static long convertBase62ToDecimal(String n) {
        long res = 0;
        long curr = 1;
        for (int i = n.length() - 1; i >= 0; i--) {
            res += (CHAR_SEQ.indexOf(n.charAt(i)) * curr);
            curr *= 62;
        }
        return res;
    }

}
