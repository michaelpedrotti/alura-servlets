package br.com.alura.models.bytebank;

import java.io.Serializable;

/**
 * Classe base de conta do ByteBank
 * 
 * @author michael
 */
public abstract class Conta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;
    private static int total = 0;

    public Conta(int agencia, int numero){
        Conta.total++;
        //System.out.println("O total de contas é " + Conta.total);
        this.agencia = agencia;
        this.numero = numero;
        //this.saldo = 100;
        //System.out.println("Estou criando uma conta " + this.numero);
    }

    public abstract void deposita(double valor);

    public boolean saca(double valor) throws SaldoInsufienteException {
        if(this.saldo < valor) {
        	throw new SaldoInsufienteException("Saldo: " + this.saldo + ", Valor: " + valor);
        }
        
        this.saldo -= valor;
        
        return true;
    }

    public boolean transfere(double valor, Conta destino) throws SaldoInsufienteException {
    	
    	this.saca(valor);
    	destino.deposita(valor);
        
    	return true;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero){
        if(numero <= 0) {
            System.out.println("Nao pode valor menor igual a 0");
            return;
        }
        this.numero = numero;
    }

    public int getAgencia(){
        return this.agencia;
    }

    public void setAgencia(int agencia){
       if(agencia <= 0) {
           System.out.println("Nao pode valor menor igual a 0");
           return;
       }
       this.agencia = agencia;
    }

    public void setTitular(Cliente titular){
        this.titular = titular;
    }

    public Cliente getTitular(){
        return this.titular;
    }

    public static int getTotal(){
        return Conta.total;
    }
}
