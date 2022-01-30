package com.br.projeto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletProjetoFinal
 */
@WebServlet("/ServletProjetoFinal")
public class ServletProjetoFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProjetoFinal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcao = request.getParameter("opcao");
		String id = request.getParameter("id");
		Container c = new Container();
		
		if(id != null){
			if(opcao.equals("0")) {
				//id = ;
				c.removerUsuario(Integer.parseInt(id));
			} else if (opcao.equals("1")) {
				User user = c.buscarUsuario(Integer.parseInt(id));
				request.setAttribute("nome", user.getNome());
				request.setAttribute("email", user.getEmail());
				request.setAttribute("nome", user.getPais());
				
				request.getRequestDispatcher("/adicionar.jsp").forward(request, response);
			}
		}
		request.setAttribute("usuario", c.buscarUsuario());
		request.getRequestDispatcher("/").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Container c = new Container();
		
		if(request.getParameter("nome") != null && request.getParameter("email") != null && request.getParameter("pais") != null){
			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String pais = request.getParameter("pais");
			
			if(id != null && !id.isEmpty()) {
				c.alterarUsuario(Integer.parseInt(id), nome, email, pais);
			} else {
				User user = new User(nome, email, pais);
				c.adicionarUsuario(user);
			}
			
			request.setAttribute("usuario", c.buscarUsuario());
		}
		request.getRequestDispatcher("/").forward(request, response);
	}

}
