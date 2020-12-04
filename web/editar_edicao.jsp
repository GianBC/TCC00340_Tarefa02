<%-- 
    Document   : editar_edicao
    Created on : 10/10/2020, 17:03:34
    Author     : Gianluca Bensabat Calvano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar edição</title>
    </head>
    <body>
        <form action = "edita_edicao_servlet" method = "POST">
            <h2>Digite o ID da edição que deseja alterar.</h2>
            ID: <input type = "text" name = "id" value=<%= request.getParameter("id")%>>
            <input type="submit" name="buscar" value="buscar">
        </form>
        <form action = "edita_edicao_servlet" method = "POST">
            <h3>Resultado da busca:</h3>
            ID: <input type = "text" name = "id" value="<%=request.getAttribute("id")%>" readonly>*NÂO ALTERAVEL*<br>
            Número: <input type = "text" name = "numero" value="<%=request.getAttribute("numero")%>"> <br>
            Ano: <input type = "text" name = "ano" value="<%=request.getAttribute("ano")%>"> <br>
            Data de início: <input type="text" name="data_ini" value="<%=request.getAttribute("data_ini")%>"> <br>
            Data final: <input type="text" name="data_fim" value="<%=request.getAttribute("data_fim")%>"> <br>
            Cidade sede: <input type="text" name="cidade" value="<%=request.getAttribute("cidade")%>"><br>
            País sede: <input type="text" name="pais" value="<%=request.getAttribute("pais")%>"><br>
            <input type = "submit" name="alterar" value="alterar">
            <br><br>
            <input type = "submit" name="APAGAR" value="APAGAR">
            <br>
            <p><a href="./index.html">Página inicial</a></p>
        </form>
    </body>
</html>
