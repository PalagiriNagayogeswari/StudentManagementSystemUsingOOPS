package com.bridgelabz.servlet;

import com.bridgelabz.model.Student;
import com.bridgelabz.service.StudentService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/searchStudent")
public class SearchStudentServlet extends HttpServlet {

    StudentService service = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Student student = service.getStudent(id);

        if (student == null) {

            response.getWriter().println("Student Not Found");

            return;

        }

        response.getWriter().println("ID : " + student.getId());
        response.getWriter().println("Name : " + student.getName());
        response.getWriter().println("Email : " + student.getEmail());
        response.getWriter().println("Course : " + student.getCourse());
        response.getWriter().println("Marks : " + student.getMarks());

    }

}