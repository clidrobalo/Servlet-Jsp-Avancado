package Servlets;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class FileUpload
 */
@WebServlet("/pages-jsp/fileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	DaoUsuario daoUsuario =  new DaoUsuario();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get session user
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		UsuarioBean usuario = (UsuarioBean) session.getAttribute("usuario");
		
		String acao = request.getParameter("acao");
		System.out.println(acao);
		
		//load and send image of user
		usuario = daoUsuario.getUser(usuario.getUser());
		RequestDispatcher dispatcher = request.getRequestDispatcher("upload.jsp");
				
		if(acao.equals("getImage")) {
			if(usuario.getImagem() != null) {
				request.setAttribute("imagem", usuario.getImagem());
			}
		} else if(acao.equals("getImages")) {
			List<String> imagens = daoUsuario.getImages();
			System.out.println("-> " + imagens.get(0));
			request.setAttribute("imagens", imagens);
		}
		
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String fileUpload = request.getParameter("fileUpload"); //Imagem em base64
			System.out.println(fileUpload);
			
			//Enviar resposta ao ajax
			response.getWriter().write("Upload realizado com sucesso na Base de dados!");
			
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			UsuarioBean usuario = (UsuarioBean) session.getAttribute("usuario");
			
			//Gravar imagem na base de dados
			daoUsuario.gravarImagem(fileUpload, usuario.getId());
		} catch (Exception e) {
			//Enviar resposta ao ajax
			response.getWriter().write("Erro inesperado.");
		}
		
	}

}
