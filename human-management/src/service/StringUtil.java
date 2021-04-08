package service;

public class StringUtil {

    public static boolean isEmptyString(String str) {
        return str == null || str.trim().equals("");
    }

}
