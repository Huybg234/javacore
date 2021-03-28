import java.util.Arrays;

public class BorrowBook {
    private Reader reader;
    private Book[] books;

    public BorrowBook() {
    }

    public BorrowBook(Reader reader, Book[] books) {
        this.reader = reader;
        this.books = books;
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

    @Override
    public String toString() {
        return "BorrowBook{" +
                "reaDer=" + reader +
                ", books=" + Arrays.toString(books) +
                '}';
    }
}
