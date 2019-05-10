package br.com.alura.servlets.json;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.alura.models.empresas.Database;

@WebServlet("/json/empresa")
public class EmpresaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Database db = new Database();
		String content = "";
		
		try {
			content = Gson.class.newInstance().toJson(db.getAll());
		} 
		catch (InstantiationException | IllegalAccessException e) {
			
			e.printStackTrace();
		}
		
		response.setContentType("application/json");
		response.getWriter().print(content);
	}
}