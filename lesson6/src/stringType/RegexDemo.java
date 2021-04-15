package test;

import java.util.Scanner;

public class RegexDemo {

    public static void main(String[] args) {

        /**
         * RegEx: Regular expression (biểu thức chính quy)
         */
        // B18DCCN270 <-------
        // N18DCCN270

        // B18CCCN270
        // B18LTCN270
        String regex = "^(B|N)(\\d){2}DCCN(\\d){3}";


        String studentID = new Scanner(System.in).nextLine();
        System.out.println(studentID.matches(regex));

        String a = new String("sdafhsd");

       Object o  =new Object();

       Class aClass;

    }

}
