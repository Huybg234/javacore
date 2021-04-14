package test;

import java.io.IOException;

public class Key {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("java.home"));


        System.gc(); // garbage collector
        Runtime.getRuntime().exec("calc");

        Runtime runtime = Runtime.getRuntime();
        //số cpu
        System.out.println(runtime.availableProcessors());
    }
}
