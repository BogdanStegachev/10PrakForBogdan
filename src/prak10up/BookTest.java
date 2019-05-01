/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prak10up;

import java.util.List;

/**
 *
 * @author User
 */
public class BookTest {

    public static void main(String[] args) {
        BookManager bk = new BookManager();
        Book b1 = new Book("Алаев","Кашир",2019,56);
        Book b2 = new Book("Сапковский", "ВД", 2007, 42);
        Book b3 = new Book("Зеленский","АТС",1488,322);
        System.out.println("ADD CONTACT =========");
        Long bId1 = bk.addBook(b1);
        Long bId2 = bk.addBook(b2);
        Long bId3 = bk.addBook(b3);
        List<Book> result1 = bk.findBook();
        for (Book b : result1) {
            System.out.println(b);
        }
        System.out.println("UPDATE CONTACT =========");
        Book change = new Book("Андрей","Труш",bId1, 123, 123);
        bk.updateBook(change);
        List<Book> result2 = bk.findBook();
        for (Book b : result2) {
            System.out.println(b);
        }
        System.out.println("DELETE CONTACT ==========");
        bk.deleteBook(bId1);
        List<Book> result3 = bk.findBook();
        for (Book b : result3) {
            System.out.println(b);
        }
        System.out.println("GET CONTACT ==========");
        Book book = bk.getBook(bId2);
        System.out.println(book);
    }
}
