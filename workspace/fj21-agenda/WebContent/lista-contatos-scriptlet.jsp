<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="br.com.caelum.jdbc.modelo.Contato"%>
<%@page import="java.util.List"%>
<%@page import="br.com.caelum.jdbc.dao.ContatoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<%
			ContatoDAO dao = new ContatoDAO();
			List<Contato> contatos = dao.getLista();
			
			for (Contato contato : contatos){
		%>
				<tr><%= contato.getNome() %></tr>
				<tr><%= contato.getEmail() %></tr>
				<tr><%= contato.getEndereco() %></tr>
				<%
					Calendar data = Calendar.getInstance();
					data = contato.getDataNascimento();
					SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
				%>
				<tr><%= formatador.format(data) %></tr>
		<% 				
			}
		%>
	</table>
</body>
</html>