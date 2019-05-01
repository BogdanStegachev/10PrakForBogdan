
package prak10up.gui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import prak10up.Book;


public class BookModel extends AbstractTableModel {
   private static final String[] headers={"Автор","Издание","ID","Год издания","Количество страниц"};
   private List<Book> books;
   
   public BookModel(List<Book> books){
       this.books=books;
   }
   
   @Override
   public int getRowCount(){
       return books.size();
   }
   
   @Override
   public int getColumnCount(){
       return 5;
   }
   
   @Override
   public String getColumnName(int col){
       return headers[col];
   }
   
   @Override
   public Object getValueAt(int row,int col){
       Book book=books.get(row);
       switch(col){
           case 0:
               return book.getAut();
           case 1:
               return book.getIzd();
           case 2:
               return book.getId().toString();
           case 3:
               return book.getYear();
           default:
               return book.getCountp();
       }
   }
}
