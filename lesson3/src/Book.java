import java.util.Scanner;

public class Book {
    private static String SCIENCE ="Khoa học tự nhiên";
    private static String LITERARY_ART = "Văn học nghệ thuật";
    private static String TELECOMMUNICATION = "Điện tử viễn thông";
    private static String INFORMATION_TECHNOLOGY = "Công nghệ thông tin";

    private static int AUTO_IDBOOK = 10000;

    private int ID;
    private String Name;
    private String Author;
    private String Major;
    private int Year;

    public Book() {
    }

    public Book(int ID, String name, String author, String major, int year) {
        this.ID = ID;
        Name = name;
        Author = author;
        Major = major;
        Year = year;
    }

    public static String getSCIENCE() {
        return SCIENCE;
    }

    public static void setSCIENCE(String SCIENCE) {
        Book.SCIENCE = SCIENCE;
    }

    public static String getLiteraryArt() {
        return LITERARY_ART;
    }

    public static void setLiteraryArt(String literaryArt) {
        LITERARY_ART = literaryArt;
    }

    public static String getTELECOMMUNICATION() {
        return TELECOMMUNICATION;
    }

    public static void setTELECOMMUNICATION(String TELECOMMUNICATION) {
        Book.TELECOMMUNICATION = TELECOMMUNICATION;
    }

    public static String getInformationTechnology() {
        return INFORMATION_TECHNOLOGY;
    }

    public static void setInformationTechnology(String informationTechnology) {
        INFORMATION_TECHNOLOGY = informationTechnology;
    }

    public static int getAutoIdbook() {
        return AUTO_IDBOOK;
    }

    public static void setAutoIdbook(int autoIdbook) {
        AUTO_IDBOOK = autoIdbook;
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

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Author='" + Author + '\'' +
                ", Major='" + Major + '\'' +
                ", Year='" + Year + '\'' +
                '}';
    }

    public void nhapTTS(){
        this.setID(Book.AUTO_IDBOOK);

        System.out.println("Nhap ten sach: ");
        this.setName(new Scanner(System.in).nextLine());
        System.out.println("Nhap ten tac gia: ");
        this.setAuthor(new Scanner(System.in).nextLine());
        System.out.println("Nhap nam xuat ban: ");
        this.setYear(new Scanner(System.in).nextInt());
        System.out.println("Chon chuyen nganh: ");
        System.out.println("1.Khoa hoc tu hien");
        System.out.println("2.Van hoc nghe thuat");
        System.out.println("3.Dien tu vien thong");
        System.out.println("4.Cong nghe thong tin");
        boolean isvalue = true;
        do{
            int choice = new Scanner(System.in).nextInt();
            switch (choice){
                case 1:
                    this.setMajor(Book.SCIENCE);
                    break;
                case 2:
                    this.setMajor(Book.LITERARY_ART);
                    break;
                case 3:
                    this.setMajor(Book.TELECOMMUNICATION);
                    break;
                case 4:
                    this.setMajor(Book.INFORMATION_TECHNOLOGY);
                    break;
                case 5:
                    System.out.println("Chon tu 1 den 4. hay chon lai!");
                    break;
            }
        }
        while (!isvalue);
        Book.AUTO_IDBOOK++;
    }
}
