package prak10up.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.BorderFactory;
import prak10up.Book;

public class EditBookDialog extends JDialog implements ActionListener {

    private static final String SAVE = "SAVE";
    private static final String CANCEL = "CANCEL";
    private static final int PAD = 10;
    private static final int W_L = 100;
    private static final int W_T = 300;
    private static final int W_B = 120;
    private static final int H_B = 25;

    private final JTextPane txtAuthor = new JTextPane();
    private final JTextPane txtIzd = new JTextPane();
    private final JTextPane txtYear = new JTextPane();
    private final JTextPane txtCountP = new JTextPane();

    private Long bookId = null;
    private boolean save = false;

    public EditBookDialog() {
        this(null);
    }

    public EditBookDialog(Book book) {
        setLayout(null);
        buildFields();
        initFields(book);
        buildButtons();
        setModal(true);
        setResizable(false);
        setBounds(300, 300, 450, 200);
        setVisible(true);
    }

    private void buildFields() {
        JLabel lblAuthor = new JLabel("Автор:");
        lblAuthor.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAuthor.setBounds(new Rectangle(PAD, 0 * H_B + PAD, W_L, H_B));
        add(lblAuthor);
        txtAuthor.setBounds(new Rectangle(W_L + 2 * PAD, 0 * H_B + PAD, W_T, H_B));
        txtAuthor.setBorder(BorderFactory.createEtchedBorder());
        add(txtAuthor);

        JLabel lblIzd = new JLabel("Издание:");
        lblIzd.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAuthor.setBounds(new Rectangle(PAD, 2 * H_B + PAD, W_L, H_B));
        add(lblAuthor);
        txtIzd.setBounds(new Rectangle(W_L + 2 * PAD, 1 * H_B + PAD, W_T, H_B));
        txtIzd.setBorder(BorderFactory.createEtchedBorder());
        add(txtIzd);

        JLabel lblYear = new JLabel("Год издания:");
        lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAuthor.setBounds(new Rectangle(PAD, 2 * H_B + PAD, W_L, H_B));
        add(lblAuthor);
        txtAuthor.setBounds(new Rectangle(W_L + 2 * PAD, 2 * H_B + PAD, W_T, H_B));
        txtAuthor.setBorder(BorderFactory.createEtchedBorder());
        add(txtAuthor);

        JLabel lblCountP = new JLabel("Количество страниц:");
        lblCountP.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAuthor.setBounds(new Rectangle(PAD, 3 * H_B + PAD, W_L, H_B));
        add(lblAuthor);
        txtAuthor.setBounds(new Rectangle(W_L + 2 * PAD, 3 * H_B + PAD, W_T, H_B));
        txtAuthor.setBorder(BorderFactory.createEtchedBorder());
        add(txtAuthor);
    }

    private void initFields(Book book) {
        if (book != null) {
            bookId = book.getId();
            txtAuthor.setText(book.getAut());
            txtIzd.setText(book.getIzd());
            txtYear.setText(Long.toString(book.getYear()));
            txtCountP.setText(Long.toString(book.getCountp()));
        }
    }

    private void buildButtons() {
        JButton btnSave = new JButton("SAVE");
        btnSave.setActionCommand(SAVE);
        btnSave.addActionListener(this);
        btnSave.setBounds(new Rectangle(PAD, 5 * H_B + PAD, W_B, H_B));
        JButton btnCancel = new JButton("CANCEL");
        btnCancel.setActionCommand(CANCEL);
        btnCancel.addActionListener(this);
        btnCancel.setBounds(new Rectangle(W_B + 2 * PAD, 5 * H_B + PAD, W_B, H_B));
        add(btnCancel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        save = SAVE.equals(action);
        setVisible(false);
    }

    public boolean isSave() {
        return save;
    }

    public Book getBook() {
        Book book = new Book(txtAuthor.getText(), txtIzd.getText(), bookId, Integer.parseInt(txtYear.getText()), Integer.parseInt(txtCountP.getText()));
        return book;
    }
}
