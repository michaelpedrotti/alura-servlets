package br.com.alura.empresas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Database {

	private static List<Empresa> rows = new ArrayList<>();
	private static Integer autoIncrement = 1;
 
	static {
		Empresa empresa = new Empresa();
		empresa.setId(Database.autoIncrement++);
		empresa.setName("Alura");
		Database.rows.add(empresa);
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(Database.autoIncrement++);
		empresa2.setName("Caelum");
		Database.rows.add(empresa2);
	}
	
	public static Database newInstance(){
		return new Database();
	}
	
	/**
	 * Sobrecarregador para String como ID
	 */
	public static Empresa findOrNew(String id){

		return Database.findOrNew(id.isEmpty() ? 0 : Integer.parseInt(id));
	}
	
	/**
	 * Acha a empresa na lista ou retorna uma nova instância caso não ache
	 */
	public static Empresa findOrNew(Integer id){
		
		for(Empresa row : Database.rows){
			
			if(row.getId() == id){
				
				return row;
			}
		}
		
		return Empresa.newInstance();
	}

	/**
	 * Adiciona uma nova empresa na lista
	 */
	public void add(Empresa empresa) {
		
		empresa.setId(Database.autoIncrement++);
		Database.rows.add(empresa);
	}
	
	/**
	 * Salva um novo ou atualiza um novo registro na lista de empresas
	 */
	public void save(Empresa empresa){
		
		if(empresa.getId() > 0){
			
			for(Empresa row : Database.rows){
				
				if(row.getId() == empresa.getId()){
					
					row.setName(empresa.getName());
					row.setCreateAt(empresa.getCreateAt());
				}
			}
		}
		else {
			this.add(empresa);
		}
	}
	
	public boolean remove(Integer id){
		
//		for(Empresa row : Database.rows){
//			
//			if(row.getId() == id){
//				
//				Database.rows.remove(row);
//				return true;
//			}
//		}
		
		Iterator<Empresa> it = Database.rows.iterator();
		
		while(it.hasNext()){
			
			Empresa e = it.next();
			
			if(e.getId() == id) {
				it.remove();
			}
		}
		
		return false;
	}

	public List<Empresa> getAll() {
		return Database.rows;
	}
	
	public void close(){}
	
	public void open(){
		
		
	}
	
	public void beginTransation(){}
	
	public void commit(){}
	
	public void rollBack(){}
}