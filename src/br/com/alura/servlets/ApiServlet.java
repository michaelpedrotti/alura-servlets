package br.com.alura.servlets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.servlets.xml.EmpresaServlet;

@WebServlet("/api/empresa")
public class ApiServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = "";
		
		// Verifica o final do mime-type: application/xml
		if(request.getHeader("accept").endsWith("xml")){
			uri = "/xml/empresa";
		}
		else {
			uri = "/json/empresa";
		}
		
		
		this.getServletContext()
			.getRequestDispatcher(uri)
				.forward(request, response);
	}
}
