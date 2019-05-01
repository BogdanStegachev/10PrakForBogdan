/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prak10up;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author User
 */
public final class BookSimpleDAO implements BookDAO {
 private final List<Book> books= new ArrayList<>();
 
 @Override
 public Long addBook(Book book){
   Long id=generateBookId();
   book.setId(id);
   books.add(book);
   return id;
 }
 
 public BookSimpleDAO(){
     addBook(new Book("Алаев","Кашир",2019,56));
     addBook(new Book("Сапковский", "ВД", 2007, 42));
     addBook(new Book("Зеленский","АТС",1488,322));
 }
 
 @Override
 public void updateBook(Book book){
     Book oldContact=getBook(book.getId());
     if(oldContact!=null){
         oldContact.setAut(book.getAut());
         oldContact.setIzd(book.getIzd());
         oldContact.setId(book.getId());
         oldContact.setYear(book.getYear());
         oldContact.setCountp(book.getCountp());
     }
 }
 
 @Override
 public void deleteBook(Long BookID){
     for(Iterator<Book> it=books.iterator(); it.hasNext();){
         Book bk=it.next();
         if(bk.getId()==BookID){
             it.remove();
         }
     }
 }
 @Override
 public Book getBook(Long bID){
     for(Book book : books){
         if(book.getId()==bID){
             return book;
         }
     }
     return null;
 }
 @Override
public List<Book> findBook(){
     return books;
 }
 
 private Long generateBookId(){
     Long bId=Math.round(Math.random()*1000+ System.currentTimeMillis());
     while(getBook(bId)!=null){
         bId=Math.round(Math.random()*1000+System.currentTimeMillis());
     }
     return bId;
 }

}


