/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidades.Edicao;
import Entidades.Evento;
import JPA.JPA_edicao;
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
@WebServlet(name = "busca_edicao_servlet", urlPatterns = {"/busca_edicao_servlet"})
public class busca_edicao_servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet busca_edicao_servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet busca_edicao_servlet at " + request.getContextPath() + "</h1>");
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
        JPA_edicao edicao_mpr = new JPA_edicao();
        Evento evento = edicao_mpr.getEventoUnico(request.getParameter("evento_nome"));
        List<Edicao> edicoes = evento.getEdicoes();
        int tamanho = edicoes.size();
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado de consulta de todas as edições para um evento.</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Resultado da busca.</h2>");
            out.println(tamanho + " ediçoes pertencentes ao evento: " + request.getParameter("evento_nome") + "<br>");

            Iterator<Edicao> edicoesAsIterator = edicoes.iterator();
            while (edicoesAsIterator.hasNext()) {
                Edicao edi = edicoesAsIterator.next();
                out.println("<p>" + "ID: " + edi.getId() + " ; NÚMERO: " + edi.getNumero() + " ; ANO: " + edi.getAno() + " ; DATA INICIAL: " + edi.getDataini() + " ; DATA FINAL: " + edi.getDatafim() + " ; CIDADE: " + edi.getCidade() + " ; PAÍS: " + edi.getPais() + "</p>");
            }
            out.println("<p><a href=./index.html>Página inicial</a></p>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
