package Models;

import java.util.HashSet;

public class Member {
    static Long totalNoOfMembers = 0L;
    static HashSet<Member> MemberList = new HashSet<>();
    Long id;
    private String name;
    private String email;
    private String password;
    private HashSet<Books> borrowedBooksSet;

    public Member(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
        borrowedBooksSet = new HashSet<>();

        id = ++totalNoOfMembers;
        MemberList.add(this);
    }

    public static void removeMember(Member member){
        MemberList.remove(member);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashSet<Books> getBorrowedBooksSet() {
        return borrowedBooksSet;
    }

    public void borrowBook(Books borrowedBook) {
        this.borrowedBooksSet.add(borrowedBook);
    }

    public void returnBook(Books returnedBook) {
        this.borrowedBooksSet.remove(returnedBook);
    }
}
