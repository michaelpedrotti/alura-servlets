package br.com.alura.servlets.xml;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;

import br.com.alura.models.empresas.Database;
import br.com.alura.models.empresas.Empresa;

@WebServlet("/xml/empresa")
public class EmpresaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Database db = new Database();
		String content = "";
		
		try {
			
			XStream stream = XStream.class.newInstance();
			stream.alias("empresa", Empresa.class);
			content = stream.toXML(db.getAll());
		}
		catch (InstantiationException | IllegalAccessException e) {
			
			e.printStackTrace();
		}

		response.setContentType("application/xml");
		response.getWriter().print(content);
	}
}