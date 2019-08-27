package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Beans.Usuario;

//Interceptar todas as requisições
//@WebFilter(urlPatterns = {"/*"}) 

//Interceptar todas as requisições para paginas na pasta "pages-jsp"
@WebFilter(urlPatterns = {"/pages-jsp/*"}) 
public class FilterAutenticacao implements Filter{
	
	/**
	 * Executa alguma coisa quando a aplicacao for iniciado
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	/**
	 * Entercepta todas as nossas requisições
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		String receiveUrl = req.getServletPath();
		//receiveUrl = "/" + receiveUrl.split("/")[2];
		System.out.println(receiveUrl);
		
		
		//Verificar se usuario não esta logado e se o evento não veio da pagina de autenticação
		if(usuario == null && !receiveUrl.equals("/pages-jsp/ServletAutenticacao")) {
			request.setAttribute("urlParam", receiveUrl);
			RequestDispatcher dispacher = request.getRequestDispatcher("/autenticar.jsp");
			dispacher.forward(request, response);
			return;
		}
		
		System.out.println("Passou pelo filtro com sucesso.");
			request.setAttribute("urlParam", request.getParameter("urlParam"));
			chain.doFilter(request, response);
	}
	
	/**
	 * Quando alguma coisa quando a aplicacao for derubada
	 */
	@Override
	public void destroy() {

	}

}
