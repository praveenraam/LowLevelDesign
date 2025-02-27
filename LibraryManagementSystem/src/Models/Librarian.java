package Models;

public class Librarian {
    static Librarian lib = new Librarian();

    private Librarian(){
    };

    public static Librarian getLib() {
        return lib;
    }
}
