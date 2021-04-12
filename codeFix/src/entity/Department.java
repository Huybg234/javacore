package entity;

import java.io.Serializable;
import java.util.Scanner;

public class Department implements Serializable {
    private int id;
    private String name;
    private String feature;
    private float workNumber;

    private static int Auto_id = 100;

    public Department() {
    }

    public Department(int id, String name, String feature, float workNumber) {
        this.id = id;
        this.name = name;
        this.feature = feature;
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

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public float getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(float workNumber) {
        this.workNumber = workNumber;
    }

    public static int getAuto_id() {
        return Auto_id;
    }

    public static void setAuto_id(int auto_id) {
        Auto_id = auto_id;
    }

    public void inputDepartmentInfo() {
        this.setId(Auto_id);

        System.out.println("Nhập tên phòng ban: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập mô tả phòng ban: ");
        this.feature = new Scanner(System.in).nextLine();
        System.out.println("Nhập hệ số công việc: ");
        boolean check = true;
        do {
            try {
                this.workNumber = new Scanner(System.in).nextFloat();
                check = true;
            } catch (Exception e) {
                System.out.println("Hệ số công việc không được có chữ!");
                break;
            }
            if (this.workNumber <= 0 || this.workNumber > 20) {
                System.out.print("Hệ số công việc trong khoảng 1 đến 20! Nhập lại: ");
                check = false;
            }
        } while (!check);
        Department.Auto_id++;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", feature='" + feature + '\'' +
                ", workNumber=" + workNumber +
                '}';
    }
}
