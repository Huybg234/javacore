package binary;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MainBinary {
    public static void main(String[] args) {
//        FileOutputStream_TC();
//        FileInputStream_TC();
//        BufferedOutputStream_TC();
//        BufferedInputStream_TC();
//        DataOutputStream_TC();
//        DataInputStream_TC();
//        PushbackInputStream();
//        LineNumberInputStream();
//        ObjectOutputStream();
//        ObjectInputStream();
//        PipedOut_InputStream();
//        PrintStream();
//        FilterOutputStream();
        FilterInputStream_TC();
    }

    private static void FileOutputStream_TC() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("demoBinary.txt")) {
            fileOutputStream.write("A\n".getBytes(StandardCharsets.UTF_8));
            fileOutputStream.write("B".getBytes(StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void FileInputStream_TC() {
        try (FileInputStream fileInputStream = new FileInputStream("demoBinary.txt")) {
            int i = fileInputStream.read();
            System.out.println((char) i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void BufferedOutputStream_TC() {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("demoBinaryBuffer.txt"))) {
            bufferedOutputStream.write("H\n".getBytes(StandardCharsets.UTF_8));
            bufferedOutputStream.write("K".getBytes(StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void BufferedInputStream_TC() {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("demoBinaryBuffer.txt"))) {
            int i = bufferedInputStream.read();
            System.out.println((char) i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void DataOutputStream_TC() {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("demoBinaryData.txt"))) {
            dataOutputStream.write("A".getBytes(StandardCharsets.UTF_8));
            dataOutputStream.write("B".getBytes(StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void DataInputStream_TC() {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("demoBinaryData.txt"))) {
            int i = dataInputStream.read();
            System.out.println((char) i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void PushbackInputStream() {
        try (PushbackInputStream pushbackInputStream = new PushbackInputStream(new FileInputStream("demoBinaryData.txt"))) {
            int i = pushbackInputStream.read();
            System.out.println((char) i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void LineNumberInputStream() {
        try (LineNumberInputStream lineNumberInputStream = new LineNumberInputStream(new FileInputStream("demoBinaryData.txt"))) {
            int i = lineNumberInputStream.read();
            System.out.println((char) i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ObjectOutputStream() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("demoBinaryOBject.txt"))) {
            objectOutputStream.write("A\n".getBytes(StandardCharsets.UTF_8));
            objectOutputStream.write("B\n".getBytes(StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ObjectInputStream() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("demoBinaryOBject.txt"))) {
            int i = objectInputStream.read();
            System.out.println((char) i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void PipedOut_InputStream() {
        try (PipedOutputStream pipedOutputStream = new PipedOutputStream();
             PipedInputStream pipedInputStream = new PipedInputStream()) {
            pipedInputStream.connect(pipedOutputStream);
            pipedOutputStream.write("C".getBytes());
            System.out.println((char) pipedInputStream.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void PrintStream() {
        try (PrintStream printStream = new PrintStream(new FileOutputStream("demoBinaryPrint.txt"))) {
            String a;
            printStream.println(a="You are mine");
            System.out.println(a);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void FilterOutputStream(){
        try (FilterOutputStream filterOutputStream = new FilterOutputStream(new FileOutputStream("demoBinaryFilter.txt"))) {
            filterOutputStream.write("K".getBytes(StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void FilterInputStream_TC(){
        try (FilterInputStream filterInputStream = new BufferedInputStream(new FileInputStream("demoBinaryFilter.txt"))){
            int i = filterInputStream.read();
            System.out.println((char) i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
