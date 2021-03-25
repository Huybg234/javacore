import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Controller2 implements Controller {

    @Override
    public <T> void ghiFile(List<T> list, String filename){
        File file = new File(filename);
        try {
            file.createNewFile();
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
    public <T> void docFile(String filename) {
        List<T> list = new ArrayList<>();
        File file = new File(filename);
        if (file.length() > 0) {
            try {
                file.createNewFile();
                FileInputStream fos = new FileInputStream(file);
                ObjectInputStream oos = new ObjectInputStream(fos);
                Object o = oos.readObject();
                list = (List<T>) o;
                fos.close();
                oos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return;
    }

}
