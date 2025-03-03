package Models;

public class Librarian {
    static Librarian lib = new Librarian();

    String password = 'password';

    private Librarian(){
    };

    public static Librarian getLib() {
        return lib;
    }

}
