package entity;

import java.util.Scanner;

public class Department {
    private int id;
    private String name;
    private String painted;
    private float workNumber;

    private static int AUTO_IDROOM = 100;

    public Department() {
    }

    public Department(int id, String name, String painted, float workNumber) {
        this.id = id;
        this.name = name;
        this.painted = painted;
        this.workNumber = workNumber;
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

    public float getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(int workNumber) {
        this.workNumber = workNumber;
    }

    public static int getAutoIdroom() {
        return AUTO_IDROOM;
    }

    public static void setAutoIdroom(int autoIdroom) {
        AUTO_IDROOM = autoIdroom;
    }

    public void inputRoomInformation() {
        this.setId(Department.AUTO_IDROOM);

        System.out.println("Nhập tên phòng: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập mô tả phòng: ");
        this.painted = new Scanner(System.in).nextLine();
        System.out.println("Nhập hệ số công việc: ");
        do {
            this.workNumber = new Scanner(System.in).nextInt();
            if (this.workNumber > 0 || this.workNumber <= 20) {
                break;
            }
        } while (true);
        Department.AUTO_IDROOM++;
    }

    public void outputRoomInformation() {
        System.out.println("Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", painted='" + painted + '\'' +
                ", worknumber=" + workNumber +
                '}');
    }


}
