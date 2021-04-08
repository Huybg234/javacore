package bai02;

import java.util.List;

public interface FileIO {
    <T> void ghiFile (java.util.List<T> list, String filename);
    <T> List<T> docFile(String filename);
}
