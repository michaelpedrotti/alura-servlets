package br.com.alura.models.bytebank;

public class ControleBonus {

	
	private double soma;
	
	
//	public void registra(Gerente g) {
//		
//		this.soma = this.soma + g.getBonus();
//	}
	
	public void registra(Funcionario f) {
		
		this.soma = this.soma + f.getBonus();
	}
	
//	public void registra(EditorVideo ev) {
//		
//		this.soma = this.soma + ev.getBonus();
//	}
	
	public double getSoma(){
		
		return this.soma;
	}
	
}
