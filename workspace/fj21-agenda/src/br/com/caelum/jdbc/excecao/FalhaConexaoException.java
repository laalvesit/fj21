package br.com.caelum.jdbc.excecao;

public class FalhaConexaoException extends RuntimeException {
	public FalhaConexaoException(String message) {
		super(message);
	}
}
