package codeByArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    private static ArrayList<Reader> readers = new ArrayList<>();
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<BorrowBook> borrowBooks = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    CreatNewReader();
                    break;
                case 2:
                    CreatNewBook();
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

    public static int functionChoice() {
        System.out.println("--------Phần mềm quản lý mượn sách thư viện-----------");
        System.out.println("1.Nhập danh sách bạn đọc");
        System.out.println("2.Nhập danh sách đầu sách mới");
        System.out.println("3.Quản lý mượn sách");
        System.out.println("4.Sắp xếp danh sách");
        System.out.println("5.Tìm kiếm và hiển thị danh sách mượn sách theo tên bạn đọc");
        System.out.println("6.Thoát");
        System.out.print("Xin mời chọn chức năng: ");
        int functionChoice;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 1 && functionChoice <= 6) {
                break;
            }
            System.out.println("Nhập không hợp lệ! Vui lòng nhập lại");
        } while (true);
        return functionChoice;
    }

    private static boolean isValidBookAndReader() {
        return books != null && readers != null && books.size() > 0 && readers.size() > 0;
    }

    public static void CreatNewReader() {
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
        for (int i = 0; i < allReader; i++) {
            Reader reader = new Reader();
            reader.nhapTTBD();
            readers.add(reader);
        }
//        System.out.println(readers.size());
        for (int i = 0; i < readers.size(); i++) {
            System.out.println(readers.get(i));
        }
    }

    public static void CreatNewBook() {
        System.out.println("Nhập số lượng đầu sách");
        int allBook = 0;
        boolean check = true;
        do {
            try {
                allBook = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (allBook <= 0) {
                System.out.println("Tổng số đầu sách lớn hơn 0 và không có chữ! nhập lại:");
                check = false;
            }
        } while (!check);
        for (int i = 0; i < allBook; i++) {
            Book book = new Book();
            book.nhapTTS();
            books.add(book);
        }
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }

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
            if (n <= 0 || n > readers.size()) {
                System.out.println("Nhập lại! số lượng bạn đọc muốn mượn sách phải lớn hơn 0,nhỏ hơn tổng sách và không có chữ: ");
                checked = false;
            }
            // check nhập số âm thì sao?????
            // nhập chữ thì sao????
            //done
        } while (!checked);

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập số lượng đầu sách mà bạn " + readers.get(i).getName() + " muốn mượn: ");
            int k = 0;
            do {
                try {
                    k = new Scanner(System.in).nextInt();
                    checked = true;
                } catch (Exception e) {
                    System.out.print("Số lượng phải là một số không phải kí tự khác, vui lòng nhập lại: ");// <-------------------------------------------------------
                    continue;
                }
                if (k <= 0 || k > 5 || k > books.size()) {
                    System.out.println("nhập lại! số lượng đầu sách lớn hơn 0, nhỏ hơn 5 và tổng sách, không có chữ:  ");
                    checked = false;
                }
                // số âm thì sao????
                // nhập chữ thì sao????
                //done
            } while (!checked);
            ArrayList<Book> bookList = new ArrayList<>();
            ArrayList<Integer> quantityList = new ArrayList<>();
            for (int j = 0; j <= k - 1; j++) {
                System.out.println("Nhập id của đầu sách thứ " + (j + 1) + " mà bạn " + readers.get(i).getName() + " muốn mượn: ");
                int tempId;
                do {
                    tempId = new Scanner(System.in).nextInt();
                    Book book = searchBook(tempId);
                    int m = 0;
                    if (book != null) {
                        System.out.print("Nhập số lượng cuốn bạn muốn mượn của sách " + book.getName() + ": ");
                        do {
                            try {
                                m = new Scanner(System.in).nextInt();
                                checked = true;
                            } catch (Exception e) {
                            }
                            if (m > 3 || m <= 0) {
                                System.out.println("Số lượng sách được cho phép mượn của một đầu sách lớn hơn 0, " +
                                        "không vượt quá 3 và không có chữ! nhập lại: ");
                                checked = false;
                            }
                            // số âm thì sao????
                            // nhập chữ thì sao????
                            //done
                        } while (!checked);
                        bookList.add(book);
                        quantityList.add(m);
                        break;
                    }
                    System.out.print("Không có sách nào trong thư viện có ID vừa nhập, vui lòng nhập lại: ");
                } while (true);
            }

            BorrowBook borrowBook = new BorrowBook(readers.get(i), bookList, quantityList);
            borrowBooks.add(borrowBook);
        }
        // in ra kết quả
        System.out.println("Danh sách bảng mượn sách của các bạn đọc hiện tại là:");
        for (int i = 0; i < borrowBooks.size(); i++) {
            System.out.println(borrowBooks.get(i));
        }
    }

    private static Book searchBook(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getID() == id) {
                return books.get(i);
            }
        }
        return null;
    }

    private static void sortBorrowList() {
        if (borrowBooks == null || borrowBooks.size() == 0) {
            System.out.println("Bạn cần nhập danh sách cho mượn trước khi sắp xếp!");
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

    private static void sortBorrowListByReaderName() {
        for (int i = 0; i < borrowBooks.size(); i++) {
            for (int j = i+1; j < borrowBooks.size(); j++) {
                if (borrowBooks.get(i).getReader().getName().compareTo(borrowBooks.get(j).getReader().getName()) > 0) {
                    BorrowBook temp = borrowBooks.get(i);
                    borrowBooks.set(i, borrowBooks.get(j));
                    borrowBooks.set(j, temp);
                }
            }
        }
        for (int i=0; i< borrowBooks.size();i++){
            System.out.println(borrowBooks.get(i));
        }
    }

    private static void sortBorrowListByBookAmount() {
        // tính tổng số lượng sách từng thằng mượn
        for (int i = 0; i < borrowBooks.size(); i++) {
            BorrowBook borrowBook = borrowBooks.get(i);
            books = borrowBook.getBooks();
            ArrayList<Integer>quantity = borrowBook.getQuantity();
            int tempTotal = 0;
            for (int j = 0; j < books.size(); j++) {
                tempTotal += quantity.get(j);
            }
            borrowBook.setTotalBook(tempTotal);
        }

        // sắp xếp nổi bọt
        for (int i = 0; i < borrowBooks.size(); i++) {
            for (int j = i + 1; j < borrowBooks.size(); j++) {
                if (borrowBooks.get(i).getTotalBook() < borrowBooks.get(j).getTotalBook()) {
                    BorrowBook temp = borrowBooks.get(i);
                    borrowBooks.set(i, borrowBooks.get(j));
                    borrowBooks.set(j, temp);
                }
            }
        }
        for (int i=0; i< borrowBooks.size(); i++){
            System.out.println(borrowBooks.get(i));
        }
    }

    private static void findBorrowListByName() {
        if (borrowBooks == null || borrowBooks.size() == 0) {
            System.out.println("Bạn cần nhập danh sách mượn sách trước khi tìm kiếm!");
            return;
        }

        System.out.print("Nhập tên bạn đọc muốn tìm kiếm: ");
        String tempName = new Scanner(System.in).nextLine();
        boolean isFound = false;
        for (int i = 0; i < borrowBooks.size(); i++) {
            if (borrowBooks.get(i).getReader().getName().equals(tempName)) {
                System.out.println(borrowBooks.get(i).getReader());
                isFound = true;
            }
        }

        if (!isFound) {
            System.out.println("Không tìm thấy bạn đọc có tên '" + tempName + "' trong danh sách mượn sách");
        }
    }
}
