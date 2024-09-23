package org.repository;

import org.model.Student;

public interface StudentRepository {
     void insertStudent(Student student);
     void selectStudent();
     void updateStudent(Student student,int id);
     void deleteStudent(int id);

}
