package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.caelum.jdbc.excecao.FalhaConexaoException;

public class ConnectionFactury {
	public Connection getConnection() {
		System.out.println("Conectando ao banco");
		try {
			return DriverManager.getConnection("jdbc:mysql://mysql01.castrodieselautopeca.hospedagemdesites.ws/castrodieselau", "castrodieselau", "a123mudar");
		} catch (SQLException e) {
			throw new FalhaConexaoException("Falha na conexão!");
		}
	}
}
