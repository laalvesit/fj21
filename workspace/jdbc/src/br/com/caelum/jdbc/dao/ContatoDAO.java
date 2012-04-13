package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactury;
import br.com.caelum.jdbc.excecao.AdicionaContatoException;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDAO {
	private Connection connection;
	
	public ContatoDAO() {
		this.connection = new ConnectionFactury().getConnection();
	}
	
	public void adiciona(Contato contato){
		String sql = "INSERT INTO contatos (nome, email, endereco, dataNascimento) values (?, ?, ?, ?)";
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.execute();
			stmt.close();
		} catch (SQLException e){
			throw new AdicionaContatoException("Falha ao adicionar contato!");
		}
	}
	
	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM contatos");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Contato contato = new Contato();
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(cal);
				contatos.add(contato);
			}
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Contato contato) {
		String sql = "UPDATE contatos SET nome=?, email=?, enderco=?, dataNascimento=? WHERE id=?";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
