import java.util.List;

public interface Controller {
    <T> void ghiFile (List<T> list, String filename);
    <T> void docFile(String filename);
}
