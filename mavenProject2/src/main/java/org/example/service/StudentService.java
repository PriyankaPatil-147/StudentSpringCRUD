package org.example.service;

import org.example.model.Student;
import org.example.repo.StudentRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements StudentServiceImpl {

    @Autowired
    StudentRepoImpl repo;

    @Override
    public void insertStudent(Student student) {

        repo.insertStudent(student);
    }

    @Override
    public void insertMultiple(List<Student> studentList) {
        for (int i = 0; i < studentList.size(); i++) {
            repo.insertStudent(studentList.get(i));
        }
    }

    @Override
    public Student selectStudent(int rollNo) {
        return repo.selectStudent(rollNo);
    }

    @Override
    public List<Student> selectMultiple(List<Integer> rollNos) {
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < rollNos.size(); i++) {
            studentList.add(repo.selectStudent(rollNos.get(i)));
        }
        return studentList;
    }
    @Override
    public Student updateStudent(Student student) {
        return repo.updateStudent(student);
    }

    @Override
    public List<Student> updateMultiple(List<Student> students) {
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            studentList.add(repo.updateStudent(students.get(i)));
        }
        return studentList;
    }

    @Override
    public boolean deleteStudent(int rollNo) {
        return repo.deleteStudent(rollNo);
    }

    @Override
    public List<Boolean> deleteMultiple(List<Integer> rollNos) {
        List<Boolean> studentList = new ArrayList<>();
        for(int i = 0; i < rollNos.size(); i++)
        {
            Boolean b1 = repo.deleteStudent(rollNos.get(i));
            studentList.add(b1);
        }
        return studentList;
    }

    @Override
    public List<Student> selectAll(){
        return repo.selectAll();
    }
    @Override
    public Boolean deletestudentall(){

        return repo.deletestudentall();
    }

}