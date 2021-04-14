package test;

import java.util.StringTokenizer;

public class StringInJava {

    public static void main(String[] args) {

//        String s1 = "Huy";
//        String s2 = "Nguyễn";
//        s1 += s2;
//        //String là một class của java
//        //s1, s2 là một object
//        //khi lấy s1 + s2 hệ thống sẽ tạo ra 1 vùng nhớ mới
//        System.out.println(s1);
        StringBuffer s1 = new StringBuffer("Huy");
        s1.append("Nguyễn").append("Quang");
        System.out.println(s1);

        /**
         * String là immutable
         */

        StringBuilder stringBuilder = new StringBuilder();
        /**
         * Sự khác biệt giữa StringBuilder và StringBuffer là các method của StringBuffer được synchronized --> liên quan tới thread và xung đột tài nguyên
         */

    }
}
