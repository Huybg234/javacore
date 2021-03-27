package answer;

import java.util.Scanner;

public class MainMenu {

    private static Reader[] readers = new Reader[7];// nhiều hơn 7 thì sao ????
    private static Book[] books = new Book[7];// nhiều hơn 7 thì sao ????
    private static BorrowBook[] borrowBooks = new BorrowBook[7];// nhiều hơn 7 thì sao ????

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    createNewBooks();
                    break;
                case 2:
                    createNewReaders();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    sortBorrowList();
                    break;
                case 5:
                    //...
                    break;
                case 6:
                    System.exit(0);
            }

        } while (true);

    }

    private static int functionChoice() {
        System.out.println("---------- PHẦN MỀM QUẢN LÝ THƯ VIỆN ---------");
        System.out.println("1. Nhập đầu sách mới.");
        System.out.println("2. Nhập danh sách bạn đọc.");
        System.out.println("3. Cho mượn sách");
        System.out.println("4. Sắp xếp danh sách mượn sách.");
        System.out.println("5. Tìm kiếm danh sách mượn sách. ");
        System.out.println("6. Thoát.");
        System.out.print("Xin mời chọn chức năng: ");
        int functionChoice;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 1 && functionChoice <= 6) {
                break;
            }
            System.out.print("Chức năng chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        return functionChoice;
    }

    private static void createNewBooks() {
        // nhập đầu sách mới
    }

    private static void createNewReaders() {
        for (int i = 0; i < readers.length; i++) {
            Reader reader = new Reader();
            reader.createReaderInfo();
            readers[i] = reader;
        }
    }

    private static void borrowBook() {

        for (int i = 0; i < readers.length; i++) {
            Reader reader = readers[i];
            BorrowBook borrowBook = new BorrowBook();
            Book[] books = new Book[9]; // xử lý số 9
            borrowBook.setReader(reader);
            // cho mượn sách cho thằng thứ i
            System.out.println("Nhập số lượng sách muốn mượn: ");
            int n = 0;
            for (int j = 0; j < n; j++) {
                System.out.println(" Nhập id sách muốn mượn");
                // xử lý nhập id sách: tìm trong mảng books, cuốn nào có id như người dùng nhập thì lấy ra
                Book book = new Book();
                books[i] = book;
            }
            borrowBook.setBooks(books);
        }

    }

    private static void sortBorrowList() {
        do {
            int sortChoice;
            System.out.println("---------- SẮP XẾP DANH SÁCH MƯỢN SÁCH ---------");
            System.out.println("1. Theo tên.");
            System.out.println("2. Theo số lượng cuốn sách được mượn (giảm dần).");
            System.out.println("3. Thoát chức năng sắp xếp.");
            System.out.print("Xin mời chọn chức năng: ");
            do {
                sortChoice = new Scanner(System.in).nextInt();
                if (sortChoice >= 1 && sortChoice <= 3) {
                    break;
                }
                System.out.print("Chức năng chọn không hợp lệ, vui lòng chọn lại: ");
            } while (true);
            switch (sortChoice) {
                case 1:
                    // ...
                    break;
                case 2:
                    // ....
                    break;
                case 3:
                    return;
            }
        } while (true);
    }

}