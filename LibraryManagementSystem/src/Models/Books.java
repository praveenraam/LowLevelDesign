package Models;

import java.util.HashSet;

public class Books {

    static Long totalNoOfBooks = 0L;
    static HashSet<Books> booksSet = new HashSet<>();

    Long id;
    private String author;
    private String bookName;
    private Member currHolder;

    public Books(String bookName,String author){
        this.bookName = bookName;
        this.author = author;

        id = ++totalNoOfBooks;
        booksSet.add(this);
    }

    public static void removeBook(Books book){
        booksSet.remove(book);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Member getCurrHolder() {
        return currHolder;
    }

    public void setCurrHolder(Member currHolder) {
        this.currHolder = currHolder;
    }
}
