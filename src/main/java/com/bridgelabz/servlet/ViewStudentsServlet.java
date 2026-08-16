package com.bridgelabz.servlet;

import com.bridgelabz.model.Student;
import com.bridgelabz.service.StudentService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/viewStudents")
public class ViewStudentsServlet extends HttpServlet {

    StudentService service = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();

        List<Student> students = service.getStudents();

        if (students.isEmpty()) {

            out.println("No Students Found");

            return;
        }

        for (Student s : students) {

            out.println("---------------------------");
            out.println("ID      : " + s.getId());
            out.println("Name    : " + s.getName());
            out.println("Email   : " + s.getEmail());
            out.println("Course  : " + s.getCourse());
            out.println("Marks   : " + s.getMarks());

        }

    }

}