package br.com.alura.models.bytebank;

public class ContaCorrente extends Conta implements Tributavel {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContaCorrente(int agencia, int numero) {
    	super(agencia, numero);
    }
    
    @Override
    public boolean saca(double valor) throws SaldoInsufienteException {
    	// TODO Auto-generated method stub
    	
    	valor += 0.2;
    	
    	return super.saca(valor);
    }

	@Override
	public void deposita(double valor) {
		super.saldo += valor;
		
	}

	@Override
	public double getValorImposto() {
		return super.saldo * 0.01;
	}  
	
	@Override
	public String toString() {

		return super.toString() + " Done";
	}
	
	
}