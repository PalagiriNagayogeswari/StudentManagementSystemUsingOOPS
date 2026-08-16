package com.bridgelabz.dao;

import com.bridgelabz.dao.StudentDAO;
import com.bridgelabz.model.Student;
import com.bridgelabz.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    Connection con;

    public StudentDAOImpl() {
        con = DBConnection.getConnection();
    }

    @Override
    public void addStudent(Student student) {

        String sql = "INSERT INTO students(name,email,course,marks) VALUES(?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            ps.setInt(4, student.getMarks());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Added Successfully.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try {

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                Student student = new Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setCourse(rs.getString("course"));
                student.setMarks(rs.getInt("marks"));

                students.add(student);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;

    }

    @Override
    public Student getStudentById(int id) {

        Student student = null;

        String sql = "SELECT * FROM students WHERE id=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                student = new Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setCourse(rs.getString("course"));
                student.setMarks(rs.getInt("marks"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;

    }

    @Override
    public void updateStudent(Student student) {

        String sql = "UPDATE students SET name=?, email=?, course=?, marks=? WHERE id=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            ps.setInt(4, student.getMarks());
            ps.setInt(5, student.getId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Updated Successfully.");
            } else {
                System.out.println("Student Not Found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Deleted Successfully.");
            } else {
                System.out.println("Student Not Found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}