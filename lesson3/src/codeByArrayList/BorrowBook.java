package codeByArrayList;

import java.util.ArrayList;

public class BorrowBook {
    private Reader reader;
    private ArrayList<Book> books;
    private ArrayList<Integer> quantity;
    private int totalBook;

    public BorrowBook() {
    }

    public BorrowBook(Reader reader, ArrayList<Book> books, ArrayList<Integer> quantity) {
        this.reader = reader;
        this.books = books;
        this.quantity = quantity;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(ArrayList<Integer> quantity) {
        this.quantity = quantity;
    }

    public int getTotalBook() {
        return totalBook;
    }

    public void setTotalBook(int totalBook) {
        this.totalBook = totalBook;
    }

    @Override
    public String toString() {
        return "BorrowBook{" +
                "reader=" + reader +
                ", books=" + books +
                ", quantity=" + quantity +
                '}';
    }
}
