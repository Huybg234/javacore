package service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class FileUntil<T extends Serializable> {
    public static <T> void writeDataToFile(List<T> data, String filename) {
        if (DataUntil.isEmptyCollection(data)) {
            return;
        }

        do {
            if (StringUntil.isEmptyString(filename)) {
                System.out.println("Tên file không được để trống! Nhập lại:");
                filename = new Scanner(System.in).nextLine();
            } else {
                break;
            }
        } while (true);

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
