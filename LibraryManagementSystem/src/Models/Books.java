package Models;

import java.util.HashMap;

public class Books {

    static Long totalNoOfBooks = 0L;
    static HashMap<Books,Boolean> booksSet = new HashMap<>();

    Long id;
    private String author;
    private String bookName;
    private Member currHolder;

    public Books(String bookName,String author){
        this.bookName = bookName;
        this.author = author;

        id = ++totalNoOfBooks;
        booksSet.put(this,true);
    }

    public static void removeBook(Long id){
        for(Books book : booksSet.keySet()){
            if(book.getId().equals(id)){
                booksSet.remove(book);
            }
        }
    }

    public static Books searchBook(String bookName) {
        for(Books book : booksSet.keySet()){
            if(book.getBookName().equals(bookName)){
                return book;
            }
        }
        return null;
    }

    public Long getId(){
        return id;
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
