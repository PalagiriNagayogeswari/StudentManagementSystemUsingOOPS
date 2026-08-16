package com.bridgelabz.servlet;

import com.bridgelabz.model.Student;
import com.bridgelabz.service.StudentService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {

    StudentService service = new StudentService();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        int id =
                Integer.parseInt(request.getParameter("id"));

        String name =
                request.getParameter("name");

        String email =
                request.getParameter("email");

        String course =
                request.getParameter("course");

        int marks =
                Integer.parseInt(request.getParameter("marks"));

        Student student =
                new Student(id, name, email, course, marks);

        service.updateStudent(student);

        response.getWriter()
                .println("Student Updated Successfully");

    }

}