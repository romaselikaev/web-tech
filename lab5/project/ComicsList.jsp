<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Список комиксов</title>
</head>
<body>
<%
  request.setCharacterEncoding("UTF-8");
  String name = request.getParameter("name");
  if (name == null || name.isEmpty()) {
      RequestDispatcher dispatcher = request.getServletContext()
          .getRequestDispatcher("/ErrorManager.jsp");
      dispatcher.forward(request, response);
      return;
  }
%>
  <h1>Список комиксов читателя <%= name %></h1>
  <%@ include file="ComicsListData.jsp" %>
</body>
</html>