package controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EquipamentoPGJDao;


public class ExcluiEquipamentoPGJ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExcluiEquipamentoPGJ() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		int idEquipamento = Integer.valueOf(request.getParameter("id"));

		PrintWriter out = response.getWriter();

		if (EquipamentoPGJDao.excluir(EquipamentoPGJDao.obterEquipamentoPorId(idEquipamento)) == false) {
			out.println("Não foi possivel excluir!");
		} else {
			request.setAttribute("objEvento", "Registro apagado com sucesso!");

			request.getRequestDispatcher("lista-equipamento.jsp?parametro=0").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
