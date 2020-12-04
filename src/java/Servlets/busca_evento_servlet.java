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
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gianluca Bensabat Calvano
 */
@WebServlet(name = "busca_evento_servlet", urlPatterns = {"/busca_evento_servlet"})
public class busca_evento_servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet busca_evento_servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet busca_evento_servlet at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        JPA_evento evento_mpr = new JPA_evento();
        List<Evento> eventos = evento_mpr.getNomeEventos(request.getParameter("evento_nome"));
        int tamanho = eventos.size();
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado de Consulta de evento</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Resultado da busca.</h2>");
            out.println(tamanho + " eventos com nome: " + request.getParameter("evento_nome") + "<br>");

            Iterator<Evento> eventosAsIterator = eventos.iterator();
            while (eventosAsIterator.hasNext()) {
                Evento evnt = eventosAsIterator.next();
                out.println("<p>" + "ID: " + evnt.getId() + " ; NOME: " + evnt.getNome() + " ; SIGLA: " + evnt.getSigla() + " ; ÁREA: " + evnt.getArea() + " ; INSTITUIÇÃO ORGANIZADORA: " + evnt.getInst_org() + "</p>");
            }
            out.println("<p><a href=./index.html>Página inicial</a></p>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
