<%-- 
    Document   : editar_evento
    Created on : 06/10/2020, 14:06:03
    Author     : Gianluca Bensabat Calvano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar evento</title>
    </head>
    <body>
        <form action = "edita_evento_servlet" method = "POST">
            <h2>Digite o ID do evento que deseja alterar.</h2>
            ID: <input type = "text" name = "id" value=<%= request.getParameter("id")%>>
            <input type="submit" name="buscar" value="buscar">
        </form>
        <form action = "edita_evento_servlet" method = "POST">
            <h3>Resultado da busca:</h3>
            ID: <input type = "text" name = "id" value="<%=request.getAttribute("id")%>" readonly>*NÂO ALTERAVEL*<br>
            Nome: <input type = "text" name = "nome" value="<%=request.getAttribute("nome")%>"> <br>
            Sigla: <input type = "text" name = "sigla" value="<%=request.getAttribute("sigla")%>"> <br>
            Área: <input type = "text" name = "area" value="<%=request.getAttribute("area")%>"> <br>
            Instituição Organizadora<br><input type = "text" name = "inst_org" value="<%=request.getAttribute("inst_org")%>"> <br>
            <input type = "submit" name="alterar" value="alterar">
            <br><br>
            <input type = "submit" name="APAGAR" value="APAGAR">
            <br>
            <p><a href="./index.html">Página inicial</a></p>
        </form>
    </body>
</html>
