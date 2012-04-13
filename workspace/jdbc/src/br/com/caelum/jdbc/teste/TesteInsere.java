package br.com.caelum.jdbc.teste;

import static java.util.Calendar.MARCH;

import java.sql.SQLException;
import java.util.GregorianCalendar;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TesteInsere {
	public static void main(String[] args) throws SQLException {
		Contato contato = new Contato();
		contato.setNome("Luiz");
		contato.setEmail("luiz@eu.com");
		contato.setEndereco("13 15 Street");
		contato.setDataNascimento(new GregorianCalendar(1983, MARCH, 15));
		
		ContatoDAO contatoDao = new ContatoDAO();
		contatoDao.adiciona(contato);
		
		System.out.println("Gravado!");
	}
}
