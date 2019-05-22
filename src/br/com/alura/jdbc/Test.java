package br.com.alura.jdbc;

import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws SQLException  {

		
		Produto p = new Produto();
		p.load(24);
		p.remove();
		System.out.println(p.getDescricao());
		
//		
//		p.setNome("Monitor LG 24p");
//		p.setDescricao("Monitor LG 24 polegadas");
//		p.save();
		
//		p.remove();
		
//		p.setNome("EEE");
//		p.setDescricao("DDD");
//		p.save();
//		
//		
//		p.setDescricao("ttt");
//		p.save();
//		
//		p.remove();
//		
//		System.out.println(p.getId());
		
		p.getConnection().close();
		
		
//		Database db = Database.newInstance();	

		
		//db.exec("insert into Produto (nome, descricao) values ('Notebook', 'Notebook i5')");
		
//		ResultSet result = db.query("SELECT * FROM Produto");
//		
//		while(result.next()){
//			
//			System.out.println(result.getInt("id"));
//			System.out.println(result.getString("Nome"));
//		}
//		
//		result.close();
//		
//		db.close();
	}
}
