package Servlets;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CapturarExecao
 */
@WebServlet("/capturarExcecao")
public class CapturarExcecao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			int valor = Integer.parseInt(request.getParameter("valorExcecaoParam"));
			
			response.setStatus(200); //Sucesso
			response.getWriter().write("Processado com sucesso.");
		} catch (Exception e) {
			response.setStatus(500); //Erro iterno do servidor
			response.getWriter().write("Valor informado nao eh um numero.");
		}
	}

}
