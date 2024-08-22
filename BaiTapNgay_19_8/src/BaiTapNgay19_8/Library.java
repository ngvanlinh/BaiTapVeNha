package BaiTapNgay19_8;

import java.util.*;

public class Library {
    private List<Book>  books = new ArrayList<>();
    private Set<String> borrowedBooks = new HashSet<>();
    private Map<String, String> borrowedBy = new HashMap<>();


    // them vào thư viện
    public void addBook(Book book) {
        books.add(book);
    }

    // mượn sách
    public void borrowBook(String ISBN, String borrower) throws Exception {
        if (borrowedBooks.contains(ISBN)) {
            throw new Exception("Sách này đã đuợc mượn");

        } else {
            borrowedBooks.add(ISBN);
            borrowedBy.put(ISBN, borrower);
            System.out.println("mượn sách thành công ");
        }
    }

    //trả sách
    public void borrower(String ISBN) throws Exception {
        if (borrowedBooks.contains(ISBN)) {
            borrowedBooks.remove(ISBN);
            borrowedBy.remove(ISBN);
            System.out.println("cuốn sách " + ISBN + " đã được trả thành công " );
        } else {
            throw new Exception("cuốn sách này chưa được mượn");
        }
    }

    //in thoing tin sach
    public void displayBooks() {
        for (Book b : books) {
            System.out.println(b);
        }
    }
    // in thông tin ngươi mượn
    public void displayInfo(){
        Set<String> set = borrowedBy.keySet();
        for (String key: set){
            System.out.println("Mã Sách: " + key + " --- tên người mượn: " +borrowedBy.get(key));
        }
    }

}
