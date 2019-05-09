package br.com.alura.models.bytebank;

import java.io.Serializable;

public class AutenticacaoUtil implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int senha;

	public void setSenha(int senha) {
		this.senha = senha;
	}


	public boolean autentica(int senha) {
		return (this.senha == senha);	
	}

}
