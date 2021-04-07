package bai02;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIOimpl implements FileIO{
    @Override
    public <T> void ghiFile(java.util.List<T> list, String filename) {
        File file = new File(filename);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            fos.close();
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public <T> java.util.List<T> docFile(String filename) {
        java.util.List<T> list = new ArrayList<>();
        File file = new File(filename);
        if (file.length() > 0) {
            try {
                file.createNewFile();
                FileInputStream fos = new FileInputStream(file);
                ObjectInputStream oos = new ObjectInputStream(fos);
                List<T> o = (List<T>) oos.readObject();
                list = o;
                fos.close();
                oos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }
}
