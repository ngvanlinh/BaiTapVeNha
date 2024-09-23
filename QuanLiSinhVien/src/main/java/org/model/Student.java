package org.model;

public class Student {
    private int id;
    private String nameStudent,address;

    public Student(int id, String nameStudent, String address) {
        this.id = id;
        this.nameStudent = nameStudent;
        this.address = address;
    }

    public Student() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", nameStudent='" + nameStudent + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
