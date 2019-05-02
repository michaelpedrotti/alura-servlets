package br.com.alura.servlets.Empresa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.empresas.Database;

@WebServlet("/empresa")
public class ListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Remove uma empresa através de um paramêtro id
	 * CRUD: remove
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!request.getParameterMap().containsKey("id")){			
			throw new ServletException("Nenhuma id foi especificada");
		}

		Integer id = Integer.valueOf(request.getParameter("id"));
		
		try {
			
			Database.newInstance().remove(id);
			request.setAttribute("message", String.format("Empresa %s foi removida com sucesso", id));
		}
		catch(Exception e) {
			request.setAttribute("message", "Falhou");
		}
		
		response.sendRedirect("/alura/empresa");
	}
	
	/**
	 * Lista as empresas
	 * CRUD: read
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Database db = new Database();

		request.setAttribute("rows", db.getAll());
		
		request.getRequestDispatcher("/empresa/list.jsp").forward(request, response);
		
	}
}
