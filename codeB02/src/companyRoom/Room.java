package companyRoom;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Room implements Serializable {
    private int id;
    private String name;
    private String painted;
    private int worknumber;

    private static int AUTO_IDROOM = 100;

    public Room() {
    }

    public Room(int id, String name, String painted, int worknumber) {
        this.id = id;
        this.name = name;
        this.painted = painted;
        this.worknumber = worknumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPainted() {
        return painted;
    }

    public void setPainted(String painted) {
        this.painted = painted;
    }

    public int getWorknumber() {
        return worknumber;
    }

    public void setWorknumber(int worknumber) {
        this.worknumber = worknumber;
    }

    public static int getAutoIdroom() {
        return AUTO_IDROOM;
    }

    public static void setAutoIdroom(int autoIdroom) {
        AUTO_IDROOM = autoIdroom;
    }

    public void inputRoomInformation() {
        this.setId(Room.AUTO_IDROOM);

        System.out.println("Nhập tên phòng: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập mô tả phòng: ");
        this.painted = new Scanner(System.in).nextLine();
        System.out.println("Nhập hệ số công việc: ");
        do {
            this.worknumber = new Scanner(System.in).nextInt();
            if (this.worknumber > 0 || this.worknumber <= 20) {
                break;
            }
        } while (true);
        Room.AUTO_IDROOM++;
    }

    public void outputRoomInformation() {
        System.out.println("Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", painted='" + painted + '\'' +
                ", worknumber=" + worknumber +
                '}');
    }

    public void ghiFile() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("DSP.txt", true))) {
            objectOutputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
