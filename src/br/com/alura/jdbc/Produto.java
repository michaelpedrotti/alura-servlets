package br.com.alura.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.HashMap;


public class Produto extends AbstractModel {
	
	private Integer id;
	private String nome;
	private String descricao;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
		
	public void save() throws SQLException{
		
		HashMap<String, String> binds = new HashMap<String, String>();
		binds.put("nome", this.nome);
		binds.put("descricao", this.descricao);
		
		// Insert
		if(this.id == null){
			this.insert("Produto", binds);
		}
		// Update
		else {
			this.update("Produto", "id", this.getId(), binds);
		}
	}
	
	public void load(Integer id) throws SQLException{
		
		ResultSet row = this.select("Produto", "id", id);
		
		if(row.next()){
			
			this.setId(row.getInt("id"));
			this.setNome(row.getString("nome"));
			this.setDescricao(row.getString("descricao"));
		}
		
		row.close();
	}
	
	public Boolean remove() throws SQLException {
		
		Integer affected = this.delete("Produto", "id", this.getId());
		this.setId(null);

		return affected > 0 ? true : false;
	}

	public static Produto newInstance(){
		return new Produto();
	}
}