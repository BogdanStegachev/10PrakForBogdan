package prak10up;

public class Book {

    private Long id;
    private String author;
    private int year;
    private String izd;
    private int countp;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAut(String author) {
        this.author = author;
    }

    public String getAut() {
        return author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setIzd(String izd) {
        this.izd = izd;
    }

    public String getIzd() {
        return izd;
    }

    public void setCountp(int countp) {
        this.countp = countp;
    }

    public int getCountp() {
        return countp;
    }

    public Book() {
    }

    public Book(String author, String izd,int year,int countp) {
        this.author = author;
        this.izd = izd;
        this.year = year;
        this.countp = countp;
    }

    public Book(String author, String izd, Long id, int year,int countp) {
        this.author = author;
        this.izd = izd;
        this.id = id;
        this.year = year;
        this.countp = countp;
    }

    @Override
    public String toString() {
        return "Book{" + "author=" + author
                + ", Izdanie=" + izd
                + ", BookId=" + id
                + ", YearIzd=" + year
                + ", CountPage=" + countp + '}';
    }
}
