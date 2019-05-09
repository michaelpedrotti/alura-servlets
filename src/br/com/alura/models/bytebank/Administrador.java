package br.com.alura.models.bytebank;

public class Administrador extends Funcionario implements Autenticavel {
	
	
	private AutenticacaoUtil autenticador;
	
	public Administrador() {
		
		this.autenticador = new AutenticacaoUtil();
	}
	
	@Override
	public double getBonus() {
		// TODO Auto-generated method stub
		return 50;
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
