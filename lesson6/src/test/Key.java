package test;

public class Key {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("java.home"));

        Runtime runtime = Runtime.getRuntime();
        //số cpu
        System.out.println(runtime.availableProcessors());
    }
}
