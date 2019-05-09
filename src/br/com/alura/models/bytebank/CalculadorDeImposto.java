package br.com.alura.models.bytebank;

public class CalculadorDeImposto {

	private double total;
	
	public void registra(Tributavel t){
		
		this.total += t.getValorImposto();
		
	}
	
	public double total(){
		
		return this.total;
	}
}
