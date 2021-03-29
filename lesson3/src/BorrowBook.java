import java.util.Arrays;

public class BorrowBook {
    private Reader reader;
    private Book[] books;
    private int[] quantity;
    private int totalBook;

    public BorrowBook() {
    }

    public BorrowBook(Reader reader, Book[] books, int[] quantity) {
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

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public int getTotalBook() {
        return totalBook;
    }

    public void setTotalBook(int totalBook) {
        this.totalBook = totalBook;
    }

    public int[] getQuantity() {
        return quantity;
    }

    public void setQuantity(int[] quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BorrowBook{" +
                "reaDer=" + reader +
                ", books=" + Arrays.toString(books) +
                '}';
    }
}
