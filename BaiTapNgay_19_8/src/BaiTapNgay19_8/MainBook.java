package BaiTapNgay19_8;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MainBook {
    public static void main(String[] args) throws Exception {
        Library lb = new Library();

        Book b1 = new Book("Người lái đò sông Đà","Nguyễn Tuân","b001");
        Book b2 = new Book("Vợ Nhặt","Kim Lân","b002");
        Book b3 = new Book("Thu Điếu","Nguyễn Khuyến","b003");
        Book b4 = new Book("Truyện Kiều","Nguyễn Du","b004");
        Book b5 = new Book("Quạt Giấy","Hồ Xuân Hương","b005");

        lb.addBook(b1);
        lb.addBook(b2);
        lb.addBook(b3);
        lb.addBook(b4);
        lb.addBook(b5);
        System.out.println("hãy lựa chọn chức năng: \n" +
                "1: in thông tin sách \n" +
                "2:mượn sách\n" +
                "3:trả sách\n");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==1){
            // in thông tin
            lb.displayBooks();
        }else if(n==2){
            // mượn sách
            System.out.println("+++++++Mượn Sách+++++++++++");
            lb.borrowBook("b002","Nguyễn văn A");
            lb.borrowBook("b001","Nguyễn văn B");
            lb.borrowBook("b003","Nguyễn văn C");
            lb.displayInfo();
        }else if(n==3){
            //trả sách
            System.out.println("==========trả sách=========");
            lb.borrower("b004");
        }


    }
}
