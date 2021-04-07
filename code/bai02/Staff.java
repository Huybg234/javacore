package bai02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Staff {
    private int id;
    private String name;
    private String address;
    private String phonenumber;
    private int salary;

    private static int AUTO_ID = 1000;

    public Staff() {
    }

    public Staff(int id, String name, String address, String phonenumber, int salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phonenumber = phonenumber;
        this.salary = salary;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public void inputStaffInformation(){
        this.setId(Staff.AUTO_ID);

        System.out.println("Nhập họ tên nhân viên: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập địa chỉ nhân viên: ");
        this.address = new Scanner(System.in).nextLine();
        System.out.println("Nhập số điện thoại nhân viên: ");
        this.phonenumber = new Scanner(System.in).nextLine();
        System.out.println("Nhập bậc lương: ");
        do {
            this.salary = new Scanner(System.in).nextInt();
            if(this.salary > 0 || this.salary <= 9 ){
                break;
            }
        }while (true);
        Staff.AUTO_ID++;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", salary=" + salary +
                '}';
    }
}
