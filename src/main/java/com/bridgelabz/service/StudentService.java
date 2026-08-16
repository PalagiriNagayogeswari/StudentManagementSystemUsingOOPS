package com.bridgelabz.service;

import com.bridgelabz.dao.StudentDAO;
import com.bridgelabz.dao.StudentDAOImpl;
import com.bridgelabz.model.Student;

import java.util.List;

public class StudentService {

    StudentDAO dao = new StudentDAOImpl();

    public void addStudent(Student student){

        dao.addStudent(student);

    }

    public List<Student> getStudents(){

        return dao.getAllStudents();

    }

    public Student getStudent(int id){

        return dao.getStudentById(id);

    }

    public void updateStudent(Student student){

        dao.updateStudent(student);

    }

    public void deleteStudent(int id){

        dao.deleteStudent(id);

    }

}