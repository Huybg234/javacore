import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        menu();
    }
    private static int AllReader;
    private static int AllBook;
    public static void menu(){
        do {
            int FuntionChoice = FuntionChoice();
            System.out.println("Chọn thao tác");
            System.out.println("1.Creat new reader");
            System.out.println("2.Creat new book");
            System.out.println("3.BorowBook");
            FuntionChoice = new Scanner(System.in).nextInt();
            switch (FuntionChoice){
                case 1:
                    CreatNewReader();
                    break;
                case 2:
                    CreatNewBook();
                    break;
                case 3:
                    borrowBook();
                    break;
            }
        }while(true);
    }

    public static int FuntionChoice(){
        System.out.println("-----QUẢN LÝ THƯ VIỆN------------");
        System.out.println("---1.danh sách bạn đọc------------");
        System.out.println("----2.danh sách đầu sách------");
        System.out.println("-----3.bảng quản lý mượn sách---------");
        System.out.println("------4.sắp xếp theo tên---------");
        System.out.println("-------5.sắp xếp theo số lượng sách được mượn-------");
        System.out.println("-------6.tìm kiếm và hiển thị danh sách mượn sách theo tên--------");
        System.out.println("-------7.kết thúc chương trình-----------");
        System.out.println("-----Chọn chức năng: ");
        int FuntionChoice;
        do {
            FuntionChoice = new Scanner(System.in).nextInt();
            if(FuntionChoice >= 1 && FuntionChoice <=6 ){
                break;
            }
            if(FuntionChoice ==7){
                System.exit(0);
            }
            System.out.println("Chon lai");
        }while(true);
        return FuntionChoice;
    }

    public static void CreatNewReader(){
        System.out.println("Nhập tổng số Reader: ");
        MainMenu.AllReader = new Scanner(System.in).nextInt();
        Reader[] readers = new Reader[MainMenu.AllReader];
        for(int i = 0; i < readers.length; i++ ){
            Reader reaDer = new Reader();
            reaDer.nhapTTBD();
            readers[i]= reaDer;
        }
        for(int i = 0; i< readers.length; i++){
            System.out.println(readers[i].toString());
        }
    }

    public static void CreatNewBook(){
        System.out.println("Nhập tổng số Book: ");
        MainMenu.AllBook = new Scanner(System.in).nextInt();
        Book[] books = new Book[MainMenu.AllBook];
        for(int i=0; i<books.length;i++ ){
            Book book = new Book();
            book.nhapTTS();
            books[i]=book;
        }
        for(int i=0; i<books.length;i++){
            System.out.println(books[i].toString());
        }
    }

    public static void borrowBook(){

        System.out.println("Nhập số lượng Reders muốn mượn sách: ");
        int n;
        do {
            System.out.println("Nhập số lượng Reader: ");
            n = new Scanner(System.in).nextInt();
            if(n>MainMenu.AllReader){
                System.out.println("nhap lại! số lượng Reader nhỏ hơn tổng số Reader");
            }
        }while (n>MainMenu.AllReader);
        Reader[] readers = new Reader[n];

        System.out.println("Nhập số lượng Books được phép mượn: ");
        int m;
        do {
            System.out.println("Nhập số lượng Book: ");
            m = new Scanner(System.in).nextInt();
            if(m>MainMenu.AllBook){
                System.out.println("nhap lai số lượng Book nhỏ hơn tổng số Book");
            }
        }while (m>MainMenu.AllBook);
        Book[] books = new Book[m];

        for (int i = 0; i < readers.length; i++){
            Reader reaDer = readers[i];
            BorrowBook borrowBook = new BorrowBook();
            borrowBook.setReaDer(reaDer);
            System.out.println("Nhập số lượng sách Readers muốn mượn: ");
            int x;
            do {
                System.out.println("Nhập số lượng Book muốn mượn: ");
                x = new Scanner(System.in).nextInt();
                if(x>m){
                    System.out.println("nhap lai! số lượng Book muốn mượn nhỏ hơn số Book được phép mượn");
                }
            }while (x>m);
            for(int j=0; j<x; j++){
                System.out.println("Nhập id sách muốn mượn: ");
                Book book = books[j];
                books[j].setID(new Scanner(System.in).nextInt());
                
            }
        }
    }
}
