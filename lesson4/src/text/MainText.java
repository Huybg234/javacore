package text;

import java.io.*;
import java.util.Scanner;
/*
đọc dùng while
ghi dùng for
 */
public class MainText {
    public static void main(String[] args) {
//        PrintWrite_TC();
//        Scanner_TC();
//        BufferWriter_TC();
//        BufferReader_TC();
//        OutputStreamWriter_TC();
        InputStreamReader_TC();
    }

    private static void PrintWrite_TC() {
        try (PrintWriter printWriter = new PrintWriter(new File("demoWriter.txt"))) {
            printWriter.println("you are so beautiful");
            printWriter.println("So I love you");
            printWriter.println("Will you marry me");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void Scanner_TC(){
        try (Scanner scanner = new Scanner(new File("demoWriter.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void BufferWriter_TC(){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("demoBufferWriter.txt"))) {
            bufferedWriter.write("Nam Quốc sơn hà Nam Đế cư");
            bufferedWriter.newLine();
            bufferedWriter.write("Tuyệt nhiên định phận tại thiên thư");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void BufferReader_TC(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("demoBufferWriter.txt"))) {
            while (true){
                String read = bufferedReader.readLine();
                if(read==null){
                    break;
                }
                System.out.println(read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void OutputStreamWriter_TC(){
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("demoOutputSteamWriter.txt"))) {
            outputStreamWriter.write("The King\n");
            outputStreamWriter.write("the Queen");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void InputStreamReader_TC(){
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("demoOutputSteamWriter.txt"))) {
            char[] array = new char[100];
            inputStreamReader.read(array);
            System.out.println(array);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
