<jsp:useBean id="gameBean" scope="session" class="zadanie5.GameBean" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Игра в крестики-нолики с сервером</title>
    </head>
    <body>
        <h1>Крестики-нолики</h1>
        <form action="entryServlet" method="post">
            <input type="submit" name="User" value="Пользователь начинает..."><br/>
            <input type="submit" name="Computer" value="Сервер начинает...">
        </form>
    </body>
</html>
