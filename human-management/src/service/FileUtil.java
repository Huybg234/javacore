package service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/**
 * @param <T>
 */
public class FileUtil<T extends Serializable> {

    public static <T> void writeDataToFile(List<T> data, String fileName) {

        if (DataUtil.isEmptyCollection(data)) {
            return;
        }

        if (StringUtil.isEmptyString(fileName)) {
            // TODO - thông báo tên file trống!!!! --> có thể bắt nhập lại
            return;
        }

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
