package codeByArrayList;

import java.util.Scanner;

public class Book {
    private int ID;
    private String Name;
    private String Author;
    private String Major;
    private int Year;

    private final static String NATURAL_SCIENCES = "Khoa học tự nhiên";
    private final static String LITERARY_ART = "Văn học nghệ thuật";
    private final static String TELECOMMUNICATION = "Điện tử viễn thông";
    private final static String INFORMATION_TECHNOLOGY = "Công nghệ thông tin";
    private static int Auto_BookID = 10000;

    public Book() {
    }

    public Book(int ID, String name, String author, String major, int year) {
        this.ID = ID;
        Name = name;
        Author = author;
        Major = major;
        Year = year;
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

    public static String getNatural_Sciences() {
        return NATURAL_SCIENCES;
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

    public static int getAuto_BookID() {
        return Auto_BookID;
    }

    public static void setAuto_BookID(int auto_BookID) {
        Auto_BookID = auto_BookID;
    }

    public void nhapTTS(){
        this.setID(Book.Auto_BookID);

        System.out.println("Nhập tên sách: ");
        this.setName(new Scanner(System.in).nextLine());

        System.out.println("Nhập tên tác giả: ");
        this.setAuthor(new Scanner(System.in).nextLine());

        System.out.println("Nhập năm xuất bản: ");
        boolean checkYear = true;
        do {
            this.Year = 0;
            try {
                this.Year = new Scanner(System.in).nextInt();
                checkYear = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.Year <=0 || this.Year>2021){
                System.out.println("Năm xuất bản phải lớn hơn 0 và nhỏ hơn 2021! Nhập lại: ");
                checkYear = false;
            }
        }while (!checkYear);

        System.out.println("Nhập loại sách:");
        System.out.println("1.Khoa học tự nhiên");
        System.out.println("2.Văn học nghệ thuật");
        System.out.println("3.Điện tử viễn thông");
        System.out.println("4.Công nghệ thông tin");
        boolean check = true;
        do {
            int choice = 0;
            try {
                choice = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            switch (choice){
                case 1:
                    this.setMajor(Book.NATURAL_SCIENCES);
                    check = true;
                    break;
                case 2:
                    this.setMajor(Book.LITERARY_ART);
                    check = true;
                    break;
                case 3:
                    this.setMajor(Book.TELECOMMUNICATION);
                    check = true;
                    break;
                case 4:
                    this.setMajor(Book.INFORMATION_TECHNOLOGY);
                    check = true;
                    break;
                default:
                    System.out.println("Nhập không hợp lệ! Vui lòng nhập lại");
                    check = false;
                    break;
            }
        }
        while (!check);
        Book.Auto_BookID++;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Author='" + Author + '\'' +
                ", Major='" + Major + '\'' +
                ", Year=" + Year +
                '}';
    }
}
