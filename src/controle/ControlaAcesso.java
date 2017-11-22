package controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import negocio.Usuario;

@WebServlet("/ControlaAcesso")
public class ControlaAcesso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControlaAcesso() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {doGet(request, response);
			
			Usuario usuario = null;
			
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			
			usuario = UsuarioDao.obterUsuario(login, senha);
			
			PrintWriter out = response.getWriter();
			
			if (usuario != null){
				request.setAttribute("objUsuario", usuario);
				request.getRequestDispatcher("cadastro-evento.html").forward(request, response);
			}else{
				out.print("  Usuário inexistente!");
			}
	}
}
