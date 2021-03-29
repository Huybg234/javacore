import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Arrays;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
        menu();
    }

    private static Reader[] readers;
    private static Book[] books;
    private static BorrowBook[] borrowBooks;

    public static void menu() {
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    createNewReader();
                    break;
                case 2:
                    createNewBook();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    sortBorrowList();
                    break;
                case 5:
                    findBorrowListByName();
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

    private static boolean isValidBookAndReader() {
        return books != null && readers != null && books.length > 0 && readers.length > 0;
    }

    public static void createNewReader() {
        System.out.println("Nhập số lượng bạn đọc: ");
        int allReader = 0;
        boolean checked = true;
        do {
            try {
                allReader = new Scanner(System.in).nextInt();
                checked = true;
            } catch (Exception e) {
            }
            if (allReader <= 0) {
                System.out.print("Tổng số bạn đọc lớn hơn 0 và không có chữ! Nhập lại: ");
                checked = false;
            }
        } while (!checked);
//        if (allReader <= 0) {
//            // xử lý không được nhập số âm
//            // nhập chữ thì sao????
//        }
        //done
        readers = new Reader[allReader];
        for (int i = 0; i < readers.length; i++) {
            Reader reaDer = new Reader();
            reaDer.nhapTTBD();
            readers[i] = reaDer;
        }
        for (int i = 0; i < readers.length; i++) {
            System.out.println(readers[i]);
        }
    }

    public static void createNewBook() {
        System.out.println("Nhập số lượng sách: ");
        int allBook = 0;
        boolean checked = true;
        do {
            try {
                allBook = new Scanner(System.in).nextInt();
                checked = true;
            } catch (Exception e) {
            }
            if (allBook <= 0) {
                System.out.print("Tổng số sách lớn hơn 0 và không có chữ! Nhập lại: ");
                checked = false;
            }
        } while (!checked);
//        if (allBook <= 0) {
//            // xử lý không được nhập số âm
//            // nhập chữ thì sao????
//        }
        //done
        books = new Book[allBook];
        for (int i = 0; i < books.length; i++) {
            Book book = new Book();
            book.nhapTTS();
            books[i] = book;
        }
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
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
        if (!isValidBookAndReader()) {
            System.out.println("Bạn cần nhập danh sách bạn đọc và đầu sách trước khi cho mượn!");
            return;
        }

        System.out.println("Nhập số lượng bạn đọc muốn mượn sách: ");
        int n = 0;
        boolean checked = true;
        do {
            try {
                n = new Scanner(System.in).nextInt();
                checked = true;
            } catch (Exception e) {
            }
            if (n <= 0 || n > readers.length) {
                System.out.println("Nhập lại! số lượng bạn đọc muốn mượn sách phải lớn hơn 0,nhỏ hơn tổng sách và không có chữ: ");
                checked = false;
            }
            // check nhập số âm thì sao?????
            // nhập chữ thì sao????
            //done
        } while (!checked);

        borrowBooks = new BorrowBook[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập số lượng đầu sách mà bạn " + readers[i].getName() + " muốn mượn: ");
            int k = 0;
            do {
                try {
                    k = new Scanner(System.in).nextInt();
                    checked = true;
                } catch (Exception e) {
                }
                if (k <= 0 || k > 5 || k> readers.length) {
                    System.out.println("nhập lại! số lượng đầu sách lớn hơn 0, nhỏ hơn 5 và tổng sách,  không có chữ:  ");
                    checked = false;
                }
                // số âm thì sao????
                // nhập chữ thì sao????
                //done
            } while (!checked);

            Book[] bookList = new Book[k];
            for (int j = 0; j <= k - 1; j++) {
                System.out.println("Nhập id của đầu sách thứ " + (j + 1) + " mà bạn " + readers[i].getName() + " muốn mượn: ");
                int tempId;
                do {
                    tempId = new Scanner(System.in).nextInt();
                    Book book = searchBook(tempId);
                    if (book != null) {
                        System.out.print("Nhập số lượng cuốn bạn muốn mượn của sách " + book.getName() + ": ");
                        do {
                            try {
                                k = new Scanner(System.in).nextInt();
                                checked = true;
                            } catch (Exception e) {
                            }
                            if (k > 3 || k <= 0) {
                                System.out.println("Số lượng sách được cho phép mượn của một đầu sách lớn hơn 0, " +
                                        "không vượt quá 3 và không có chữ! nhập lại: ");
                                checked=false;
                            }
                            // số âm thì sao????
                            // nhập chữ thì sao????
                            //done
                        } while (!checked);
                        bookList[j] = book;
                        break;
                    }
                    System.out.print("Không có sách nào trong thư viện có ID vừa nhập, vui lòng nhập lại: ");
                } while (true);
            }

            BorrowBook borrowBook = new BorrowBook(readers[i], bookList);
            borrowBooks[i] = borrowBook;
        }

        // in ra kết quả
        System.out.println("Danh sách bảng mượn sách của các bạn đọc hiện tại là:");
        for (int i = 0; i < borrowBooks.length; i++) {
            System.out.println(borrowBooks[i]);
        }

        // dùng cách này cũng được
//        for (BorrowBook borrowBook: borrowBooks) {
//            System.out.println(borrowBook);
//        }

    }

    private static Book searchBook(int id) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getID() == id) {
                return books[i];
            }
        }
        return null;
    }

    private static void sortBorrowList() {
        if (borrowBooks == null || borrowBooks.length == 0) {
            System.out.println("Bạn cần nhập danh sách bạn đọc và đầu sách trước khi cho mượn!");
            return;
        }
        do {
            int sortChoice;
            System.out.println("---------- SẮP XẾP DANH SÁCH MƯỢN SÁCH ---------");
            System.out.println("1. Theo tên bạn đọc.");
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
                    sortBorrowListByReaderName();
                    break;
                case 2:
                    sortBorrowListByBookAmount();
                    break;
                case 3:
                    return;
            }
        } while (true);
    }

    // sử dụng thuật toán sắp xếp nổi bọt
    private static void sortBorrowListByReaderName() {
        if (borrowBooks == null || borrowBooks.length == 0) {
            System.out.println("Bạn cần nhập danh sách cho mượn trước khi sắp xếp!");
            return;
        }
        String n= "" ;
        for (int i = 0; i < borrowBooks.length; i++) {
            for (int j = 0; j < i - 1; j++) {
                if (borrowBooks[i].getReader().getName().compareTo(borrowBooks[j].getReader().getName())>0){

                }
            }
        }
        System.out.println(borrowBooks);
    }

    private static void sortBorrowListByBookAmount() {
        if (borrowBooks == null || borrowBooks.length == 0) {
            System.out.println("Bạn cần nhập danh sách cho mượn trước khi sắp xếp!");
            return;
        }

        for (int i = 0; i < borrowBooks.length; i++) {
            for (int j = 0; j < i - 1; j++) {

            }
        }
        System.out.println(borrowBooks);
    }

    private static void findBorrowListByName() {
        if (borrowBooks == null || borrowBooks.length == 0) {
            System.out.println("Bạn cần nhập danh sách bạn đọc và đầu sách trước khi cho mượn!");
            return;
        }

        System.out.print("Nhập tên bạn đọc muốn tìm kiếm: ");
        String tempName = new Scanner(System.in).nextLine();
        boolean isFound = false;
        for (int i = 0; i < borrowBooks.length; i++) {
            if (borrowBooks[i].getReader().getName().equals(tempName)) {
                System.out.println(borrowBooks[i].getReader());
                isFound = true;
            }
        }

        if (!isFound) {
            System.out.println("Không tìm thấy bạn đọc có tên '" + tempName + "' trong danh sách mượn sách");
        }
    }

}

