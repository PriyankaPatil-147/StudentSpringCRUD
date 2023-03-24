package org.example.repo;

import org.example.model.Student;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentRepo implements StudentRepoImpl {

    @Override
    public void insertStudent(Student student) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "");
            Statement st = con.createStatement();
            st.executeUpdate("insert into stud3 values('" + student.getRollno() + "','" + student.getName() + "','" + student.getEmail() + "')");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
        @Override
        public Student selectStudent(int rollNo)
        {
            Student student = new Student();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from stud3 where rollNo = '" + rollNo + "'");
                while (rs.next()) {
                    student.setRollno(rs.getInt(1));
                    student.setName(rs.getString(2));
                    student.setEmail(rs.getString(3));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            return student;
        }

        @Override
        public Student updateStudent(Student student){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","");
                Statement st = con.createStatement();
                st.executeUpdate("update stud3 set name='"+student.getName()+"',email='"+student.getEmail()+"' where rollNo='"+student.getRollno()+"'");
            }
            catch (Exception e){
                System.out.println(e);
            }
            return selectStudent(student.getRollno());
    }

    @Override
    public boolean deleteStudent(int rollNo){
        boolean result=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","");
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete from stud3 where rollNo='"+rollNo+"'");
            if (count>0){
                result = true;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
    @Override
    public List<Student> selectAll()
    {
        List<Student> studentList=new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from stud3");
            while (rs.next()) {
                Student student=new Student();
                student.setRollno(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
                studentList.add(student);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return studentList;
    }
    @Override
    public Boolean deletestudentall(){
        Boolean result=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","");
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete from stud3");
            if (count>0){
                result = true;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
}



