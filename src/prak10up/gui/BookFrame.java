package prak10up.gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import prak10up.Book;
import prak10up.BookManager;


public class BookFrame extends JFrame implements ActionListener {
private static final String LOAD="LOAD";
private static final String ADD="ADD";
private static final String EDIT="EDIT";
private static final String DELETE="DELETE";

private final BookManager bookManager=new BookManager();
private final JTable bookTable=new JTable();

public BookFrame(){
    bookTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    GridBagLayout gridbag=new GridBagLayout();
     GridBagConstraints gbc=new GridBagConstraints();
     gbc.gridwidth=GridBagConstraints.REMAINDER;
     gbc.fill=GridBagConstraints.BOTH;
     gbc.insets=new Insets(5,5,0,5);
     JPanel btnPanel=new JPanel();
     btnPanel.setLayout(gridbag);
     btnPanel.add(CreateButton(gridbag,gbc,"Обновить",LOAD));
     btnPanel.add(CreateButton(gridbag,gbc,"Добавить",ADD));
     btnPanel.add(CreateButton(gridbag,gbc,"Исправить",EDIT));
     btnPanel.add(CreateButton(gridbag,gbc,"Удалить",DELETE));
     JPanel left=new JPanel();
     left.setLayout(new BorderLayout());
     left.add(btnPanel,BorderLayout.NORTH);
     add(left,BorderLayout.WEST);
     add(new JScrollPane(bookTable),BorderLayout.CENTER);
     setBounds(100,200,900,400);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     loadBook();
}

private JButton CreateButton(GridBagLayout gridbag,GridBagConstraints gbc,String title,String action){
    JButton button=new JButton(title);
    button.setActionCommand(action);
    button.addActionListener(this);
    gridbag.setConstraints(button, gbc);
    return button;
}

@Override
public void actionPerformed(ActionEvent ae){
    String action=ae.getActionCommand();
    switch(action){
        case LOAD:
            loadBook();
            break;
        case ADD:
            addBook();
            break;
        case EDIT:
            editBook();
            break;
        case DELETE:
            deleteBook();
            break;
            
    }
}

private void loadBook(){
    List<Book> books=bookManager.findBook();
    BookModel bm=new BookModel(books);
    bookTable.setModel(bm);
}

private void addBook(){
    EditBookDialog ebd=new EditBookDialog();
    saveBook(ebd);
}

private void editBook(){
    int sr=bookTable.getSelectedRow();
    if(sr!=-1){
        Long id=Long.parseLong(bookTable.getModel().getValueAt(sr,0).toString());
   Book bks=bookManager.getBook(id);
   EditBookDialog ebd=new EditBookDialog(bookManager.getBook(id));
   saveBook(ebd);
    }else{
        JOptionPane.showMessageDialog(this,"Вы должны выделить строку для редактирования ");
    }
}

private void deleteBook(){
    int sr=bookTable.getSelectedRow();
    if(sr!=-1){
        Long id=Long.parseLong(bookTable.getModel().getValueAt(sr,0).toString());
        bookManager.deleteBook(id);
        loadBook();
    }else{
        JOptionPane.showMessageDialog(this, "Вы должны  выделить строку для удаления");
    
    }
}

private void saveBook(EditBookDialog ebd){
    if(ebd.isSave()){
        Book bks=ebd.getBook();
        if(bks.getId()!=null){
            bookManager.updateBook(bks);
        }else{
            bookManager.addBook(bks);
        }
        loadBook();
    }
}
}
