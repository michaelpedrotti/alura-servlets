package br.com.alura.models.bytebank;

public class Gerente extends Funcionario implements Autenticavel {

	private AutenticacaoUtil autenticador;
	
	public Gerente(){
		
		this.autenticador = new AutenticacaoUtil();
	}
	
	private int senha;
	
	public double getBonus(){
		
		return super.getSalario();
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