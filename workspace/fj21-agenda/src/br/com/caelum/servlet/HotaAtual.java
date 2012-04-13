package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HotaAtual extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("A hora certa é ");
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formato = new SimpleDateFormat("HH:mm");
		
		out.println(formato.format(cal.getTime()));
		out.println("</body>");
		out.println("</html>");
	}
}
