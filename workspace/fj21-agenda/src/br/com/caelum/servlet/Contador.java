package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Contador extends HttpServlet {
	private int contador = 0;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		log("Iniciando o Contador!");
	}
	public void destroy() {
		super.destroy();
		
		log("Finalizando o Contador!");
	}
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		this.contador++;
		PrintWriter pw = arg1.getWriter();
		pw.println(this.contador);
	}
	
}
