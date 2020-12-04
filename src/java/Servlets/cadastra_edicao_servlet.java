/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidades.Edicao;
import JPA.JPA_edicao;
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
@WebServlet(name = "cadastra_edicao_servlet", urlPatterns = {"/cadastra_edicao_servlet"})
public class cadastra_edicao_servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cadastra_edicao_servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cadastra_edicao_servlet at " + request.getContextPath() + "</h1>");
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
            JPA_edicao edicao_mpr = new JPA_edicao();
            Edicao edicao = new Edicao();
            edicao.setEvento(edicao_mpr.getEventoUnico(request.getParameter("nome")));
            edicao.setNumero(Integer.parseInt(request.getParameter("numero")));
            edicao.setAno(request.getParameter("ano"));
            edicao.setDataini(request.getParameter("data_ini"));
            edicao.setDatafim(request.getParameter("data_fim"));
            edicao.setCidade(request.getParameter("cidade"));
            edicao.setPais(request.getParameter("pais"));
            edicao_mpr.setPersistir(edicao);
            out.println("Alteração efetuada.");
            out.println("<p><a href=./cadastrar_edicao.html>Voltar</a></p>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
