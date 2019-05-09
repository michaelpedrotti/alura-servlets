package br.com.alura.models.bytebank;

public abstract class Funcionario {

	private String nome;
	private String cpf;
	private double salario;
	
	
	public Funcionario(){
		
		
		
	}
	
	// Método sem corpo ( não implementado )
	public abstract double getBonus();
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
