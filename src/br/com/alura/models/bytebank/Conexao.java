package br.com.alura.models.bytebank;

public class Conexao implements AutoCloseable {

    public Conexao() {
        System.out.println("Abrindo conexao");
        //throw new IllegalArgumentException();
        //throw new IllegalStateException("Doh");
    }

    public void leDados() {
        System.out.println("Recebendo dados");
            throw new IllegalStateException("Doh");
    }

	@Override
	public void close() throws Exception {
		System.out.println("Fechando conexao");
		
	}
}