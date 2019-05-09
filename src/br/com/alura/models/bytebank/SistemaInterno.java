package br.com.alura.models.bytebank;

public class SistemaInterno {
	
	private int senha = 2222;
	
	
	public void autentica(Autenticavel fa){
		
		if(fa.autentica(this.senha)){
			
			System.out.println("Logedin");
		}
		else {
			System.out.println("Pass is incorrect");
		}
		
	}

}
