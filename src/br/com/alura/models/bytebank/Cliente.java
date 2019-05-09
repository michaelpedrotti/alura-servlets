package br.com.alura.models.bytebank;

import java.io.Serializable;

/**
 * Classe de um cliente do Bytebank
 * 
 * @author michael
 * @version 0.1
 */
public class Cliente  implements Autenticavel, Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nome;
	private String cpf;
	private String profissao;
	private AutenticacaoUtil autenticador;

	public Cliente(){
		
		this.autenticador = new AutenticacaoUtil();
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getProfissao() {
		return profissao;
	}
	
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	@Override
	public void setSenha(int senha) {
		this.autenticador.setSenha(senha);
	}

	@Override
	public boolean autentica(int senha) {
		return this.autenticador.autentica(senha);
	}
}
