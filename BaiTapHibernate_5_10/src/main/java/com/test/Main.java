package com.test;

import com.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class Main {
    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        Main ME = new Main();

        // Add few employee records in database
        Integer empID1 = ME.addStudent("Zara", "11a1", "Hà Nội",9);
        Integer empID2 = ME.addStudent("Daisy", "10a2", "Hà Bắc",8);
        Integer empID3 = ME.addStudent("John", "12a3", "Hà Đông",6);

        // List down all the employees
        ME.listEmployees();

        // Update employee's records
        ME.updateEmployee(empID1, "David","11a5","Hà Trung",6);

        // Delete an employee from the database
        ME.deleteEmployee(empID2);

        // List down new list of the employees
        ME.listEmployees();
    }

    // Method to CREATE an employee in the database
    public Integer addStudent(String hoTen, String lop,String diaChi, int diem) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer StudentID = null;
        try {
            tx = session.beginTransaction();
            Student student  = new Student(hoTen,lop,diaChi,diem);
            StudentID = (Integer) session.save(student);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return StudentID;
    }

    // Method to READ all the employees
    public void listEmployees() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List students = session.createQuery("FROM Student").list();
            for (Iterator iterator = students.iterator(); iterator.hasNext(); ) {
                Student student = (Student) iterator.next();
                System.out.print("HọTên " + student.getHoTen());
                System.out.print("  Lop: " + student.getLop());
                System.out.println("Dia chỉ: " + student.getDiaChi());
                System.out.println("Diểm: " + student.getDiem());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Method to UPDATE salary for an employee
    public void updateEmployee(Integer StudentID,String hoTen,String Lop,String diaChi, int diem) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Student student = (Student) session.get(Student.class, StudentID);

            student.setHoTen(hoTen);
            student.setLop(Lop);
            student.setDiaChi(diaChi);
            student.setDiem(diem);
            session.update(student);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Method to DELETE an employee from the records
    public void deleteEmployee(Integer StudentID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Student student = (Student) session.get(Student.class, StudentID);
            session.delete(student);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
