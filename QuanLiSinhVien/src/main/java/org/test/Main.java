package org.test;

import org.model.Student;
import org.service.StudentService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static StudentService studentService = new StudentService();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("nhập chức năng cần sử lí: ");
        System.out.println("1: in thông tin sinh viên \n"+
                            "2: thêm mới 1 sinh viên\n" +
                            "3: sửa thông tin sinh viên theo id\n" +
                                "4: xóa sinh viên theo id\n");
        int n = scan.nextInt();
            if (n == 1) {
                selectStudent();
            } else if (n == 2) {
                testInsertDB();
                selectStudent();
            } else if (n == 3) {
                updateStudent();
                selectStudent();
            } else if (n == 4) {
                deleteStudent();
                selectStudent();
            }



    }
    static void testInsertDB() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap MSV: ");
        int id = scan.nextInt();
        System.out.println("Nhap Ten: ");
        String nameStudent = scan.next();
        System.out.println("Nhap DC: ");
        String address = scan.next();

        Student std = new Student(id, nameStudent, address);
        studentService.insertStudent(std);
    }
    static void selectStudent(){
        System.out.println("After inserting records:");
        studentService.selectStudent();
    }
    static void updateStudent(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap MSV cần update: ");
        int id = scan.nextInt();
        System.out.println("Nhap Ten cần sửa: ");
        String nameStudent = scan.next();
        System.out.println("Nhap DC cần sửa: ");
        String address = scan.next();

        Student std = new Student(id,nameStudent, address);
        studentService.updateStudent(std,id);
    }
    static void deleteStudent(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap MSV cần xóa: ");
        int id = scan.nextInt();
        studentService.deleteStudent(id);
    }
}