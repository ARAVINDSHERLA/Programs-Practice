package com.j2ee.designpatterns.integrationtier.DataAccessObject;


import java.util.List;

public interface StudentDaoInterface {
   public List<Student> getAllStudents();
   public Student getStudent(int rollNo);
   public void updateStudent(Student student);
   public void deleteStudent(Student student);
}