package br.com.alura.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Date {

	/**
	 * Converte do padrão brasileiro para o americano
	 */
	public static java.util.Date encode(String str){
		
		java.util.Date date = new java.util.Date();
		
		try {
			
			if(!str.isEmpty()){
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				return sdf.parse(str);
			}
		}
		catch (ParseException e) {
			// Falhou o parse
		}
		
		return date;
	}

	/**
	 * Converte do padrão americano para o brasileiro
	 * 
	 * @todo Implementar, future me :)
	 */
	public static java.util.Date decode(){
		
		return new java.util.Date();
	}
}
