package br.com.alura.models.empresas;

import java.util.Date;

public class Empresa {

	private Integer id = 0;
	private String name;
	private Date createAt = new Date();
	
	public static Empresa newInstance(){
		return new Empresa();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateAt() {
		return this.createAt;
	}
	public void setCreateAt(Date date) {
		this.createAt = date;
	}
	
}