package prak10up;

import java.util.List;

public interface BookDAO {

    public Long addBook(Book book);

    public void updateBook(Book book);

    public void deleteBook(Long id);

    public Book getBook(Long id);

    public List<Book> findBook();
}
