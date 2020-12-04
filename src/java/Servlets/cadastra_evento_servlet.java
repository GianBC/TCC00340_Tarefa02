/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidades.Evento;
import JPA.JPA_evento;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gianluca Bensabat Calvano
 */
@WebServlet(name = "cadastra_evento_servlet", urlPatterns = {"/cadastra_evento_servlet"})
public class cadastra_evento_servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cadastra_evento_servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cadastra_evento_servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html;charset=UTF-8");
            JPA_evento evento_mpr = new JPA_evento();
            Evento evento = new Evento();
            evento.setNome(request.getParameter("nome"));
            evento.setSigla(request.getParameter("sigla"));
            evento.setArea(request.getParameter("area"));
            evento.setInst_org(request.getParameter("inst_org"));
            evento_mpr.setPersistir(evento);
            out.println("Alteração efetuada.");
            out.println("<p><a href=./index.html>Página inicial</a></p>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
