package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.UsuarioBean;
import dao.DaoUsuario;

/**
 * Servlet implementation class ServletAutenticacao
 */
@WebServlet("/pages-jsp/ServletAutenticacao")
public class ServletAutenticacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	DaoUsuario daoUsuario = new DaoUsuario();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String valueDeslogar = request.getParameter("deslogar");
		
		if(Boolean.parseBoolean(valueDeslogar)) {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			//Terminar sessão - remover ususario da sessão
			session.invalidate();
			
			System.out.println("Deslogado...");
			
			response.sendRedirect("../index.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loginParam = request.getParameter("login");
		String senhaParam = request.getParameter("senha");
		String urlParam = request.getParameter("urlParam");
		
		/**
		 * validar login e senha
		 */
		UsuarioBean usuario = new UsuarioBean();
		usuario.setUser(loginParam);
		usuario.setSenha(senhaParam);
		
		System.out.println("chegou ao servlet");

		if(daoUsuario.userExiste(loginParam)) {
			usuario = daoUsuario.getUser(loginParam);
			
			//Settar usuario na sessão
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			session.setAttribute("usuario", usuario);
			
			
			System.out.println("Url param: " + urlParam);	
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(urlParam);
			request.setAttribute("usuario", usuario);
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
