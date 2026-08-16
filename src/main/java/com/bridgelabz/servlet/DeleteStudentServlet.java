package com.bridgelabz.servlet;

import com.bridgelabz.service.StudentService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;


@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {

    StudentService service = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        int id =
                Integer.parseInt(request.getParameter("id"));

        service.deleteStudent(id);

        response.getWriter()
                .println("Student Deleted Successfully");

    }

}