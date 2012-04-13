package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class AdicionaContatoServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			
			Contato contato = new Contato();
			contato.setNome(request.getParameter("nome"));
			contato.setEmail(request.getParameter("email"));
			contato.setEndereco(request.getParameter("endereco"));
			
			String data = request.getParameter("data");
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			Date dt = formatador.parse(data);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dt);
			
			contato.setDataNascimento(cal);
			
			ContatoDAO dao = new ContatoDAO();
			dao.adiciona(contato);
			
			out.println("<html>");
			out.println("<body>");
			out.println("Contato "+ contato.getNome() +" adicionado com sucesso!");
			out.println("</body>");
			out.println("</html>");
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
	}
}
