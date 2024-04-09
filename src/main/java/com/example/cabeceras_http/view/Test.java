package com.example.cabeceras_http.view;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@WebServlet(value="/test")
public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException,
            IOException{
        response.setContentType("text/html");
        String metodoHttp = req.getMethod(); // Método HTTP utilizado en la solicitud (GET, POST, etc.)
        String requestUri = req.getRequestURI(); // URI de la solicitud
        String requestUrl = req.getRequestURL().toString(); // URL completa de la solicitud
        String contexPath = req.getContextPath(); // Contexto de la aplicación web
        String servletPath = req.getServletPath(); // Ruta del servlet en la URL
        String ipCliente = req.getRemoteAddr(); // Dirección IP del cliente que realizó la solicitud
        String ip = req.getLocalAddr(); // Dirección IP del servidor
        int port = req.getLocalPort(); // Puerto del servidor
        String scheme = req.getScheme(); // Protocolo utilizado (http, https)
        String host = req.getHeader("host"); // Nombre del host al que se realizó la solicitud
        // Construir URLs basadas en la información de la petición
        String url = scheme + "://" + host + contexPath + servletPath; // URL completa basada en la información de la solicitud
        String url2 = scheme + "://" + ip + ":" + port + contexPath + servletPath; // Otra URL completa basada en la información de la solicitud
        try  (PrintWriter out = response.getWriter()) {
            // Generar la respuesta HTML
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println(" <head>");
            out.println(" <meta charset=\"UTF-8\">");
            out.println(" <title>Cabeceras HTTP Request</title>");
            out.println(" </head>");
            out.println(" <body>");
            out.println(" <h1>Cabeceras HTTP Request!</h1>");
            out.println("<ul>");
            // Mostrar información de la petición
            out.println("<li>metodo http: " + metodoHttp + "</li>");
            out.println("<li>request uri: " + requestUri + "</li>");
            out.println("<li>request url: " + requestUrl + "</li>");
            out.println("<li>context path: " + contexPath + "</li>");
            out.println("<li>servlet path: " + servletPath + "</li>");
            out.println("<li>ip local: " + ip + "</li>");
            out.println("<li>ip cliente: " + ipCliente + "</li>");
            out.println("<li>puerto local: " + port + "</li>");
            out.println("<li>scheme: " + scheme + "</li>");
            out.println("<li>host: " + host + "</li>");
            out.println("<li>url: " + url + "</li>");
            out.println("<li>url2: " + url2 + "</li>");

            // Mostrar todas las cabeceras recibidas en la petición
            Enumeration<String> headerNames = req.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String cabecera = headerNames.nextElement();
                out.println("<li>"+ cabecera + ": " + req.getHeader(cabecera) + "</li>");
            }
            out.println("</ul>");
            out.println(" </body>");
            out.println("</html>");

        }
    }
}

// Las cabeceras HTTP proporcionan información adicional sobre la solicitud,
// lo que permite personalizar la respuesta y mejorar la seguridad y la experiencia del usuario.
