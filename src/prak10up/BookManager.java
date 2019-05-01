package prak10up;

import java.util.List;

public class BookManager {

    private BookDAO dao;

    public BookManager() {
        dao = BookDAOfactrory.getBookDAO();
    }

    public Long addBook(Book book) {
        return dao.addBook(book);
    }

    public void deleteBook(Long bId) {
        dao.deleteBook(bId);
    }

    public void updateBook(Book book) {
        dao.updateBook(book);
    }

    public Book getBook(Long Id) {
        return dao.getBook(Id);
    }

    public List<Book> findBook() {
        return dao.findBook();
    }
}
