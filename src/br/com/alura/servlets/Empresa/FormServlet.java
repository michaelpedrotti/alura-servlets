package br.com.alura.servlets.Empresa;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.empresas.Database;
import br.com.alura.empresas.Empresa;

/**
 * Esse servlet executa o create, read e update do CRUD
 */
@WebServlet("/empresa/form")
public class FormServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Esse servlet executa o create, read e update do CRUD
	 */
	private Date parseDate(HttpServletRequest request){
		
		Date date = new Date();
		
		try {
			
			if(!request.getParameter("createAt").isEmpty()){
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				return sdf.parse(request.getParameter("createAt"));
			}
		}
		catch (ParseException e) {
			// Falhou o parse
		}
		
		return date;
	}
	
	/**
	 * Exibe o formulário de cadastro/edição, se possuir atributo id 
	 * é uma edição, senão é um cadastro
	 * CRUD: read
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameterMap().containsKey("id")){
		
			request.setAttribute("empresa", Database.findOrNew(request.getParameter("id")));	
		}
		else {
			
			request.setAttribute("empresa", Empresa.newInstance());
		}
		
		request.getRequestDispatcher("/empresa/form.jsp").forward(request, response);
	}

	/**
	 * Persiste o dado do formulário para cadastro/edição
	 * CRUD: create, update
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Empresa empresa;
		
		if(request.getParameterMap().containsKey("id") && !request.getParameter("id").isEmpty()){
			
			empresa = Database.findOrNew((String)request.getParameter("id"));
		}
		else {
			
			empresa = Empresa.newInstance();
		}
		
		empresa.setName(request.getParameter("name"));		
		empresa.setCreateAt(this.parseDate(request));
		
		Database db = new Database();
		db.beginTransation();
		
		try {
			
			db.save(empresa);
			db.commit();
			
			request.setAttribute("message", String.format("Empresa %s salva com sucesso", request.getParameter("name")));
			
			// Fica com o historico do último post, a cada F5 re-executa o post e
			// gera um novo registro, então precisamos forçar um 301, 302
			//request.getRequestDispatcher("/empresa").forward(request, response);
			response.sendRedirect("/alura/empresa");
		} 
		catch(Exception e) {
			db.rollBack();
			request.setAttribute("message", e.getMessage());
			// Volta par ao formulário com a mensagem de erro.
			this.doGet(request, response);
		}
	}
}