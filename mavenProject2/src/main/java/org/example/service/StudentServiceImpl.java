package org.example.service;

import org.example.model.Student;

import java.util.List;

public interface StudentServiceImpl {
    void insertStudent(Student student);
    void insertMultiple(List<Student> studentList);
    Student selectStudent(int rollNo);
    List<Student> selectMultiple(List<Integer> rollNos);
    Student updateStudent(Student student);

    List<Student> updateMultiple(List<Student> students);
    boolean deleteStudent(int rollNo);
    List <Boolean> deleteMultiple(List<Integer> rollNos);

    public List<Student> selectAll();
    Boolean deletestudentall();
}
