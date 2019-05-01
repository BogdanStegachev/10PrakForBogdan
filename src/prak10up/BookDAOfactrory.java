package prak10up;

public class BookDAOfactrory {

    public static BookDAO getBookDAO() {
        return new BookSimpleDAO();
    }
}
