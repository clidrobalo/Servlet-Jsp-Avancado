package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import Beans.UsuarioBean;
import dao.DaoUsuario;

/**
 * Servlet implementation class CarregarDadosDataTable
 */
@WebServlet("/pages-jsp/carregarDadosDataTable")
public class CarregarDadosDataTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DaoUsuario daoUsuario = new DaoUsuario();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<UsuarioBean> usuarios = daoUsuario.getUsers();
		List<String> datas = new ArrayList<>();
		
		//appends all users
		for(UsuarioBean usuario :  usuarios) {
			datas.add(
						"["+
								 "\""+ usuario.getNome() +"\"," +
								 "\""+ usuario.getCidade() +"\"," +
								 "\""+ usuario.getTelefone()  +"\""+
						"]"
					);
		}
		
		System.out.println(datas.toString());
		
		String jsonStr = "{" +
				 "\"draw\": 1," + 
				 "\"recordsTotal\":" + usuarios.size() + "," +
				 "\"recordsFiltered\":" + usuarios.size() + "," +
				 "\"data\": " +
				 datas.toString() +	"}";
		
		
		response.setStatus(200); //resposta completa - ok
		response.getWriter().write(jsonStr); //Json de resposta
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
