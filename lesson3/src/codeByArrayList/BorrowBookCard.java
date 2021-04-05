package codeByArrayList;

public class BorrowBookCard {

    private Book book;
    private int quantity;

    public BorrowBookCard() {
    }

    public BorrowBookCard(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BorrowBookCard{" +
                "book=" + book +
                ", quantity=" + quantity +
                '}';
    }
}
