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
@WebServlet(name = "edita_evento_servlet", urlPatterns = {"/edita_evento_servlet"})
public class edita_evento_servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet edita_evento_servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet edita_evento_servlet at " + request.getContextPath() + "</h1>");
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
            if (request.getParameter("buscar") != null) {
                try {
                    JPA_evento evento_mpr = new JPA_evento();
                    Evento evento;
                    long id = Long.parseLong(request.getParameter("id"));
                    evento = evento_mpr.getEventoPorID(id);
                    request.setAttribute("id", evento.getId());
                    request.setAttribute("nome", evento.getNome());
                    request.setAttribute("sigla", evento.getSigla());
                    request.setAttribute("area", evento.getArea());
                    request.setAttribute("inst_org", evento.getInst_org());
                    request.getRequestDispatcher("editar_evento.jsp").forward(request, response);
                } catch (Exception e) {
                    out.println(e);
                }
            } else if (request.getParameter("alterar") != null) {
                Evento evento = new Evento();
                JPA_evento evento_mpr = new JPA_evento();
                long id = Long.parseLong(request.getParameter("id"));
                evento.setNome(request.getParameter("nome"));
                evento.setSigla(request.getParameter("sigla"));
                evento.setArea(request.getParameter("area"));
                evento.setInst_org(request.getParameter("inst_org"));
                evento_mpr.setModificarEvento(id, evento);
                out.println("Alteração efetuada.");
                out.println("<p><a href=./editar_evento.jsp>Voltar</a></p>");
            } else if (request.getParameter("APAGAR") != null) {
                JPA_evento evento_mpr = new JPA_evento();
                long id = Long.parseLong(request.getParameter("id"));
                evento_mpr.setApagarEvento(id);
                out.println("Alteração efetuada.");
                out.println("<p><a href=./editar_evento.jsp>Voltar</a></p>");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
