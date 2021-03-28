import java.util.Scanner;

public class Reader {
    private int ID;
    private String Name;
    private String Address;
    private String PhoneNumber;
    private String ReaderType;

    private final static String STUDENT = "Sinh Vien";
    private final static String HIGHTSTUDENT = "Hoc Vien Cao Hoc";
    private final static String TEACHER = "Giao Vien";

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

        System.out.println("nhap hoTen :");
        this.Name = new Scanner(System.in).nextLine();

        System.out.println("nhap diaChi :");
        this.Address = new Scanner(System.in).nextLine();

        System.out.println("nhap sDT :");
        this.PhoneNumber = new Scanner(System.in).nextLine();

        System.out.println("Chon loaiBD :");
        System.out.println("1.Sinh Vien");
        System.out.println("2.Hoc Vien Cao Hoc");
        System.out.println("3.Giao Vien");

        boolean isValue = true;
        do {
            int choice = new Scanner(System.in).nextInt();
            // nhập chữ thì sao
            switch (choice) {
                case 1:
                    this.setReaderType(Reader.STUDENT);
                    isValue = true;
                    break;
                case 2:
                    this.setReaderType(Reader.HIGHTSTUDENT);
                    isValue = true;
                    break;
                case 3:
                    this.setReaderType(Reader.TEACHER);
                    isValue = true;
                    break;
                default:
                    isValue = false;
                    System.out.println("Nhap sai. Hay nhap tu 1 den 3");
                    break;
            }
        } while (!isValue);
        Reader.AUTO_ID++;
    }
}
