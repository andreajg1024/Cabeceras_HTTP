package com.example.cabeceras_http.model;

import com.example.cabeceras_http.mapping.StudentsDto;
import com.example.cabeceras_http.model.Students;
import com.example.cabeceras_http.service.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/students.xls", "/students.html", "/students"})
public class Listar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {

        StudentService studentService = new StudentService();
        List<StudentsDto> students = studentService.listar();

        resp.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Lista de Estudiantes</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista de Estudiantes</h1>");
            out.println("<ul>");

            for (StudentsDto student : students) {
                out.println("<li>" + student.getName() + "</li>");
            }

            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
