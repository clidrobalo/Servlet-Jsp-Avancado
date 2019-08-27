package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Usuario;

/**
 * Servlet implementation class ServletAutenticacao
 */
@WebServlet("/pages-jsp/ServletAutenticacao")
public class ServletAutenticacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loginParam = request.getParameter("login");
		String senhaParam = request.getParameter("senha");
		String urlParam = request.getParameter("urlParam");
		
		/**
		 * validar login e senha
		 */
		String login = "Clid Robalo";
		String senha = "1234";
		
		System.out.println("chegou");
		
		Usuario usuario = new Usuario();
		usuario.setLogin(loginParam);
		usuario.setSenha(senhaParam);
		
		if(loginParam.equals(login) && senhaParam.equals(senha)) {
			
			//Settar usuario na sessão
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			session.setAttribute("usuario", usuario);
			
			
			System.out.println("Url param: " + urlParam);	
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(urlParam);
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("urlParam", urlParam);
			request.setAttribute("usuario", usuario);
			request.setAttribute("cridenciasInvalidos", true);
			RequestDispatcher dispatcher = request.getRequestDispatcher("../autenticar.jsp");
			dispatcher.forward(request, response);
		}
	}

}
