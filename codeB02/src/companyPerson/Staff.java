package companyPerson;

import java.io.*;
import java.util.Scanner;

public class Staff extends Person implements Serializable {
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

    public void inputStaffInformation() {
        this.setId(Staff.AUTO_ID);

        person.InputPerson();
//        super.InputPerson();
        System.out.println("Nhập bậc lương: ");
        do {
            this.salary = new Scanner(System.in).nextInt();
            if (this.salary > 0 || this.salary <= 9) {
                break;
            }
        } while (true);
        Staff.AUTO_ID++;
    }

    public void OutputStaffInformation() {
        System.out.println(this.id+ ", " + person.getName() + ", " + person.getAddress() + ", " + person.getPhonenumber() + ", " + this.salary);
    }

    public void ghiFile() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("DSNV.txt", true))) {
            objectOutputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @Override
////    public String toString() {
////        return "Staff{" +
////                "id=" + id +
////                ", salary=" + salary +
////                ", person=" + person.toString() +
////                '}';
////    }
}
