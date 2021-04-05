import java.util.Scanner;

public class Book {
    private final static String SCIENCE = "Khoa học tự nhiên";
    private final static String LITERARY_ART = "Văn học nghệ thuật";
    private final static String TELECOMMUNICATION = "Điện tử viễn thông";
    private final static String INFORMATION_TECHNOLOGY = "Công nghệ thông tin";

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

    public static String getLiteraryArt() {
        return LITERARY_ART;
    }

    public static String getTELECOMMUNICATION() {
        return TELECOMMUNICATION;
    }

    public static String getInformationTechnology() {
        return INFORMATION_TECHNOLOGY;
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

    public void nhapTTS() {
        this.setID(Book.AUTO_IDBOOK);

        System.out.println("Nhập tên sách: ");
        this.setName(new Scanner(System.in).nextLine());

        System.out.println("Nhập tên tác giả: ");
        this.setAuthor(new Scanner(System.in).nextLine());

        System.out.println("Nhập năm xuất bản: ");
        boolean checked = true;
        do {
            this.Year =0;
            try {
                this.Year = new Scanner(System.in).nextInt();
                checked = true;
            }catch (Exception e){
            }
            if(this.Year<=0 || this.Year > 2021){
                System.out.print("Năm không thể âm, lớn hơn 2021 hoặc có chữ! Nhập lại: ");
                checked=false;
            }
        }while (!checked);

        System.out.println("Chọn chuyên ngành: ");
        System.out.println("1.Khoa học tự nhiên");
        System.out.println("2.Văn học nghệ thuật");
        System.out.println("3.Điện tử viễn thông");
        System.out.println("4.Công nghệ thông tin");
        boolean isvalue = true;
        do {
            int choice = 0;
            try {
                choice= new Scanner(System.in).nextInt();
                isvalue=true;
            }catch (Exception e){
            }
            // nhập chữ thì sao
            //done
            switch (choice) {
                case 1:
                    this.setMajor(Book.SCIENCE);
                    isvalue = true;
                    break;
                case 2:
                    this.setMajor(Book.LITERARY_ART);
                    isvalue = true;
                    break;
                case 3:
                    this.setMajor(Book.TELECOMMUNICATION);
                    isvalue = true;
                    break;
                case 4:
                    this.setMajor(Book.INFORMATION_TECHNOLOGY);
                    isvalue = true;
                    break;
                default:
                    System.out.println("Chọn từ 1 đến 4! Hãy chọn lại: ");
                    isvalue = false;
                    break;
            }
        }
        while (!isvalue);
        Book.AUTO_IDBOOK++;
    }
}
