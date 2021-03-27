package answer;

import java.util.Scanner;

public class Reader {

    public static final String STUDENT = "Sinh viên";
    public static final String POST_GRADUATED_STUDENT = "Học viên cao học";
    public static final String TEACHER = "Giáo viên";

    private static int AUTO_ID = 10000;

    private int id;
    private String fullName;
    private String address;
    private String phoneNumber;
    private String type;

    public Reader() {
    }

    public Reader(int id, String fullName, String address, String phoneNumber, String type) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    public static String getSTUDENT() {
        return STUDENT;
    }

    public static String getPostGraduatedStudent() {
        return POST_GRADUATED_STUDENT;
    }

    public static String getTEACHER() {
        return TEACHER;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public void createReaderInfo() {
        this.setId(Reader.AUTO_ID);

        System.out.print("Nhập họ tên của bạn đọc: ");
        this.setFullName(new Scanner(System.in).nextLine());

        System.out.print("Nhập địa chỉ của bạn đọc: ");
        this.setAddress(new Scanner(System.in).nextLine());

        System.out.print("Nhập SDT của bạn đọc: ");
        this.setPhoneNumber(new Scanner(System.in).nextLine());


        System.out.println("Chọn loại bạn đọc: ");
        System.out.println("1. Sinh viên");
        System.out.println("2. Học viên cao học");
        System.out.println("3. Giáo viên");
        System.out.print("Lựa chọn của bạn là: ");
        boolean isValidType = true;
        do {
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    this.setType(Reader.STUDENT);
                    isValidType = true;
                    break;
                case 2:
                    this.setType(Reader.POST_GRADUATED_STUDENT);
                    isValidType = true;
                    break;
                case 3:
                    this.setType(Reader.TEACHER);
                    isValidType = true;
                    break;
                default:
                    isValidType = false;
                    System.out.print("Loại bạn đọc vừa chọn không hợp lệ, vui lòng chọn lại: ");
                    break;
            }
        } while (!isValidType);
        Reader.AUTO_ID += 1;
    }

}
