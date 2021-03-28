import answer.BorrowBook;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        menu();
    }

    private static int AllReader = new Scanner(System.in).nextInt();
    private static Reader[] readers = new Reader[AllReader];
    private static int AllBook = new Scanner(System.in).nextInt();
    private static Book[] books = new Book[AllBook];

    public static void menu() {
        do {
            int FuntionChoice = FuntionChoice();
            switch (FuntionChoice) {
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
        } while (true);
    }

    public static int FuntionChoice() {
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
            if (FuntionChoice >= 1 && FuntionChoice <= 6) {
                break;
            }
            if (FuntionChoice == 7) {
                System.exit(0);
            }
            System.out.println("Chon lai");
        } while (true);
        return FuntionChoice;
    }

    public static void CreatNewReader() {
        for (int i = 0; i < readers.length; i++) {
            Reader reaDer = new Reader();
            reaDer.nhapTTBD();
            readers[i] = reaDer;
        }
        for (int i = 0; i < readers.length; i++) {
            System.out.println(readers[i].toString());
        }
    }

    public static void CreatNewBook() {
        for (int i = 0; i < books.length; i++) {
            Book book = new Book();
            book.nhapTTS();
            books[i] = book;
        }
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].toString());
        }
    }

    /**
     * 1. Nhập số lượng người đọc muốn mượn sách (n thằng)
     * 2. For từ 0 đến n-1 (tưởng tượng n bạn đọc đang xếp hàng, và mình đang xử lý từng bạn đọc 1 lần)
     * *trong for là bạn đọc thứ i ==> cho bạn đọc thứ i mượn sách*
     * 2.1 Nhập số lượng đầu sách bạn đọc thứ i muốn mượn (gọi là k), nếu nhập quá 5 thì bắt nhập lại
     * 2.2 for từ 0 tới k-1 (hỏi xem nó muốn mượn những quyển gì)
     * 2.2.1 nhập id của đầu sách thứ j
     * 2.2.2 tìm kiếm trong "AllBook" xem có id mà nó vừa nhập không???
     * ==> không ==> in ra: id sách không tồn tại, yêu cầu nhập lại
     * 2.2.3 hỏi xem muốn mượn bao nhiêu quyển của đầu sách thứ j này
     * > 3 ==> hỏi lại
     * <= 3 --> ok, cho mượn (tức là set vào mảng book[] mà nó muốn mượn)
     * -----đủ k quyển thì thoát khỏi for
     * ------đủ n người mượn, thì dừng chức năng.
     */
    public static void borrowBook() {
        BorrowBook borrowBook = new BorrowBook();
        System.out.println("Nhập số lượng Reders muốn mượn sách: ");
        int n;
        do {
            n = new Scanner(System.in).nextInt();
            if (n > MainMenu.AllReader) {
                System.out.println("nhap lại! số lượng Reader nhỏ hơn tổng số Reader");
            }
        } while (n > MainMenu.AllReader);

        for (int i = 0; i < n; i++) {
            System.out.println("Reader thứ " + (i + 1) + " :");
            System.out.println("Nhập số lượng đầu Books Reader " + (i + 1) + " muốn mượn: ");
            int k;
            do {
                k = new Scanner(System.in).nextInt();
                if (k > 5) {
                    System.out.println("nhập lại! số lượng đầu Book nhỏ hơn 5 ");
                }
            } while (k > 5);

            for (int j = 0; j <= k - 1; j++) {
                System.out.println("Nhập Loại đầu sách thứ " + (j + 1) + " :");
                System.out.println("Chọn loại đầu sách: ");
                System.out.println("1.Khoa hoc tu hien");
                System.out.println("2.Van hoc nghe thuat");
                System.out.println("3.Dien tu vien thong");
                System.out.println("4.Cong nghe thong tin");
                boolean isvalue = true;
                do {
                    int choice = new Scanner(System.in).nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println(Book.SCIENCE);
                            isvalue = true;
                            break;
                        case 2:
                            System.out.println(Book.LITERARY_ART);
                            isvalue = true;
                            break;
                        case 3:
                            System.out.println(Book.TELECOMMUNICATION);
                            isvalue = true;
                            break;
                        case 4:
                            System.out.println(Book.INFORMATION_TECHNOLOGY);
                            isvalue = true;
                            break;
                        default:
                            System.out.println("Chon tu 1 den 4. hay chon lai!");
                            isvalue = false;
                            break;
                    }
                }
                while (!isvalue);

                for (int m = 0; m < books.length; m++) {
                    System.out.println("Nhập id sách thứ " + (m + 1) + " Reader muốn mượn: ");
                    Book book = new Book();
                    book.setID(new Scanner(System.in).nextInt());
                    System.out.println(book.getID());
                    do {
                        if (book.getID() != books[m].getID()) {
                            System.out.println("id không tồn tại! Nhập lại: ");
                            book.setID(new Scanner(System.in).nextInt());
                        }
                    } while (book.getID() != books[m].getID());
                }

                System.out.println("Nhập số lượng sách muốn mượn của đầu sách thứ: "+(i+1));
                int h;
                do{
                    h = new Scanner(System.in).nextInt();
                    if(h>3){
                        System.out.println("được phép mượn ít hơn 3 quyển! nhập lại");
                    }
                    else {
                        Book book = new Book();
                        book.setID(j);
                    }
                }while (h>3);
            }
        }
    }
}

