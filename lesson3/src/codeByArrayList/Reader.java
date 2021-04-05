package codeByArrayList;

import java.util.Scanner;

public class Reader {
    private int ID;
    private String Name;
    private String Address;
    private String PhoneNumber;
    private String ReaderType;

    private final static String STUDENT = "Sinh viên";
    private final static String HIGHTSTUDENT = "Học viên cao học";
    private final static String TEACHER = "Giáo Viên";

    private static int AUTO_ID = 10000;

    public Reader() {
    }

    public Reader(int ID, String name, String address, String phoneNumber, String readerType) {
        this.ID = ID;
        this.Name = name;
        this.Address = address;
        this.PhoneNumber = phoneNumber;
        this.ReaderType = readerType;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getReaderType() {
        return ReaderType;
    }

    public void setReaderType(String readerType) {
        ReaderType = readerType;
    }

    public static String getSTUDENT() {
        return STUDENT;
    }

    public static String getHIGHTSTUDENT() {
        return HIGHTSTUDENT;
    }

    public static String getTEACHER() {
        return TEACHER;
    }

    @Override
    public String toString() {
        return "BanDoc{" +
                "idbanDoc=" + ID +
                ", hoTen='" + Name + '\'' +
                ", diaChi='" + Address + '\'' +
                ", sDT='" + PhoneNumber + '\'' +
                ", loaiBD='" + ReaderType + '\'' +
                '}';
    }

    public void nhapTTBD() {

        this.setID(Reader.AUTO_ID);
        System.out.println("Nhập họ tên bạn đọc : ");
        this.Name = new Scanner(System.in).nextLine();

        System.out.println("Nhập địa chỉ bạn đọc : ");
        this.Address = new Scanner(System.in).nextLine();

        System.out.println("Nhập số điện thoại bạn đọc : ");
        this.PhoneNumber = new Scanner(System.in).nextLine();

        System.out.println("Chon loại bạn đọc: ");
        System.out.println("1.Sinh Viên");
        System.out.println("2.Học viên cao học");
        System.out.println("3.Giáo Viên");

        boolean isValue = true;
        do {
            int choice = 0;
            try {
                choice = new Scanner(System.in).nextInt();
                isValue = true;
            } catch (Exception e) {
            }
            switch (choice) {
                case 1:
                    this.setReaderType(Reader.STUDENT);
                    System.out.println("Sinh viên");
                    isValue = true;
                    break;
                case 2:
                    this.setReaderType(Reader.HIGHTSTUDENT);
                    System.out.println("Sinh viên cao học");
                    isValue = true;
                    break;
                case 3:
                    this.setReaderType(Reader.TEACHER);
                    System.out.println("Giáo viên");
                    isValue = true;
                    break;
                default:
                    isValue = false;
                    System.out.println("Nhập sai! hãy nhập từ 1 đến 3");
                    break;
            }
        } while (!isValue);
        Reader.AUTO_ID++;
    }
}
