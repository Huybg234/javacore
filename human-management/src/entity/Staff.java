package entity;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Staff extends Person {

    private int id;
    private int salary;

    private static int AUTO_ID = 1000;

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

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    Person person = new Person();

    @Override
    public void inputInfo() {
        this.setId(Staff.AUTO_ID);

        super.inputInfo();
        System.out.print("Nhập bậc lương: ");
        do {
            try {
                this.salary = new Scanner(System.in).nextInt();
            } catch (InputMismatchException ex) {
                // TODO - thông báo lỗi --> bắt nhập lại
            }
            if (this.salary > 0 || this.salary <= 9) {
                break;
            }
            System.out.print("Bậc lương là một số nguyên từ 1-> 9, vui lòng nhập lại: ");
        } while (true);
        Staff.AUTO_ID++;
    }

    @Override
    public String toString() {
        return super.toString() + "Staff{" +
                "id=" + id +
                ", salary=" + salary +
                ", person=" + person.toString() +
                '}';
    }

}
