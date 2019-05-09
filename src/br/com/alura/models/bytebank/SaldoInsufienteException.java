package br.com.alura.models.bytebank;


public class SaldoInsufienteException extends java.lang.Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SaldoInsufienteException(String msg){
		super(msg);
	}
}
