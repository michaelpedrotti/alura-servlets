package br.com.alura.models.bytebank;

public class ContaPoupanca extends Conta {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ContaPoupanca(int agencia, int numero) {
		super(agencia, numero);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void deposita(double valor) {
		super.saldo += valor;
		
	}
    
}
