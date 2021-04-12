package entity;

import java.io.Serializable;
import java.util.Scanner;

public class Staff extends Person implements Serializable {
    private int id;
    private int salary;

    private static int Auto_Id = 1000;

    public Staff() {
    }

    public Staff(int id, int salary) {
        this.id = id;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static int getAuto_Id() {
        return Auto_Id;
    }

    public static void setAuto_Id(int auto_Id) {
        Auto_Id = auto_Id;
    }

    public void inputStaffInfo() {
        this.setId(Staff.Auto_Id);
        super.inputPersonInfo();
        System.out.println("Nhập bậc lương: ");
        boolean check = true;
        do {
            try {
                this.salary = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("không được có chữ!");
            }
            if (this.salary <= 0 || this.salary > 9) {
                System.out.print("Bậc lương trong khoảng 1 đến 9! Nhập lại: ");
                check = false;
            }
        } while (!check);
        Staff.Auto_Id++;
    }

    @Override
    public String toString() {
        return super.toString() + "Staff{" +
                "id=" + id +
                ", salary=" + salary +
                '}';
    }
}
