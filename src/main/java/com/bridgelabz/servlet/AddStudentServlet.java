package com.bridgelabz.servlet;

import com.bridgelabz.model.Student;
import com.bridgelabz.service.StudentService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

    StudentService service = new StudentService();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("name");

        String email = request.getParameter("email");

        String course = request.getParameter("course");

        int marks =
                Integer.parseInt(request.getParameter("marks"));

        Student student =
                new Student(name, email, course, marks);

        service.addStudent(student);

        response.getWriter()
                .println("Student Added Successfully");

    }

}