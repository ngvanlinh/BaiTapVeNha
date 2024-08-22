package BaiTapNgay19_8;

public class Book {
    private String nameBook;
    private String nameAuthor;
    private String ISBN;

    public Book() {
    }

    public Book(String nameBook, String nameAuthor, String ISBN) {
        this.nameBook = nameBook;
        this.nameAuthor = nameAuthor;
        this.ISBN = ISBN;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return
                "nameBook='" + nameBook + '\'' +
                ", nameAuthor='" + nameAuthor + '\'' +
                ", ISBN='" + ISBN + '\''
                ;
    }
}
