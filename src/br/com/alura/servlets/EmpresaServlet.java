package br.com.alura.servlets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.models.empresas.Database;
import br.com.alura.models.empresas.Empresa;
import br.com.alura.models.empresas.User;		

/**
 * Servlet implementation class Empresa
 */
@WebServlet({ "/empresa", "/empresa/form", "/empresa/remove", "/empresa/login", "/empresa/logout" })
public class EmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 3L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// /alura/empresa/form
		request.setAttribute("url", request.getRequestURI());

		// /alura
		//System.out.println(request.getContextPath());
		
		String action = (String)request.getAttribute("action");
		
		System.out.println("servlet action " + action);

		if(action.isEmpty()){
			throw new ServletException("Action not found at servelet /empresa");
		}
		
		
		try {
			this.getClass()
				.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class)
					.invoke(this, request, response);
		} 
		catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		//request.getSession().removeAttribute("user");
		request.getSession().invalidate();// destroy a sessão
		
		response.sendRedirect(request.getContextPath() + "/empresa/login");
	}

	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getMethod().equals("POST")){
			
			String username = request.getParameter("user");
			String password = request.getParameter("pass");
			
			User user = Database.newInstance().login(username, password);
			
			if(user == null){
				request.setAttribute("message", "Usuário ou senha inválidos");
			}		
			else {	
				
				request.getSession().setAttribute("user", user);
				response.sendRedirect(request.getContextPath() + "/empresa");
				return;
			}
		}
		
		request.getRequestDispatcher("/empresa/login.jsp").forward(request, response);
	}	
	
	/**
	 * 
	 * crud: create, read, update
	 */
	protected void form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Empresa empresa;
		
		// Se possui id por GET é um READ ou por POST é um UPDATE
		if(request.getParameterMap().containsKey("id")){
			
			empresa = Database.findOrNew((String)request.getParameter("id"));
		}
		// Senão possui id por GET é um NEW ou por POST é um CREATE
		else {
			
			empresa = Empresa.newInstance();
		}
		
		// create, update
		if(request.getMethod().equals("POST")){
			
			// Popula os dados na model
			empresa.setName(request.getParameter("name"));		
			empresa.setCreateAt(br.com.alura.utils.Date.encode(request.getParameter("createAt")));
			
			// Abre a transação
			Database db = new Database();
			db.beginTransation();
			
			try {
				
				db.save(empresa);
				db.commit();
				
				//request.setAttribute("message", String.format("Empresa %s salva com sucesso", request.getParameter("name")));
				// todo: mudar para sessão, quando for ensinada :(
				
				response.sendRedirect("/alura/empresa");
				return;// interrope o método para não gererar erro com o forward
			} 
			catch(Exception e) {

				db.rollBack();
				request.setAttribute("message", e.getMessage());
				request.setAttribute("empresa", empresa);
			}
		}
		// GET - new, read
		else {
			
			request.setAttribute("empresa", empresa);
		}

		request.getRequestDispatcher("/empresa/form.jsp").forward(request, response);
	}
	
	/**
	 * 
	 * crud: remove
	 */
	protected void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
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
	 * 
	 * crud: read
	 */
	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Database db = new Database();

		request.setAttribute("rows", db.getAll());
		
		request.getRequestDispatcher("/empresa/list.jsp").forward(request, response);
	}
}
