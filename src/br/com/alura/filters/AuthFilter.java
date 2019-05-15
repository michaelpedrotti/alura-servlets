package br.com.alura.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Filtro para EmpresaServlet. O Filter é uma especie de middleware e pode empilhar um ou mais 
 * antes data execução do servlet. Pode ordenar a pilha somente através do web.xml e não através
 * de annotation.
 * 
 * Os demais frameworks utilizam o termo i	@Override
	public void init(FilterConfig filterConfig) throws ServletException { }
	
	@Override
	public void destroy() { }nterceptador.
 * 
 * @see br.com.alura.servlets.EmpresaServlet
 */
@WebFilter({ "/empresa/*" })
public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException { }
	
	@Override
	public void destroy() { }
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		String route = httpRequest.getRequestURI()
			.substring(httpRequest.getContextPath().length())// retira somente /empresa em diante
			.replaceFirst("/", "");// remove a barra inicial
		
		String action;
		
		// Sem sesão somente pode acessar a action login ( GET e POST )
		if(httpRequest.getSession().getAttribute("user") == null){
			action = "login";
		}
		// Possui sessão
		else {
			
			// controler/action/id
			String[] arr = route.split("/");
			// primeira posição é a controller /empresa
			action = (arr.length >= 2) ? arr[1] : "index";// possui a segunda posição
			//Integer id = (arr.length == 3) ? Integer.valueOf(arr[2]) : 0; // Posui a terceira posição
		}
		
		httpRequest.setAttribute("action", action);
				
		chain.doFilter(request, response);
	}
}