import java.util.Scanner;

public class MainMenu {
    private static ReaDer[] reaDers = new ReaDer[2];
    private static Book[] books = new Book[2];
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        do {
            int FuntionChoice = FuntionChoice();
            System.out.println("Chon thao tac");
            System.out.println("1.Creat new reader");
            System.out.println("2.Creat new book");
            System.out.println("7.Exit");
            FuntionChoice = new Scanner(System.in).nextInt();
            switch (FuntionChoice){
                case 1:
                    CreatNewReader();
                    break;
                case 2:
                    CreatNewBook();
                    break;
                case 7:
                    System.exit(0);
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
            if(FuntionChoice >= 1 && FuntionChoice <=7 ){
                break;
            }
            System.out.println("Chon lai");
        }while(true);
        return FuntionChoice;
    }

    public static void CreatNewReader(){
        for(int i=0;i < reaDers.length;i++ ){
            ReaDer reaDer = new ReaDer();
            reaDer.nhapTTBD();
            reaDers[i]= reaDer;
        }
        for(int i=0;i<reaDers.length;i++){
            System.out.println(reaDers[i].toString());
        }
    }

    public static void CreatNewBook(){
        for(int i=0; i<books.length;i++ ){
            Book book = new Book();
            book.nhapTTS();
            books[i]=book;
        }
        for(int i=0; i<books.length;i++){
            System.out.println(books[i].toString());
        }
    }
}
