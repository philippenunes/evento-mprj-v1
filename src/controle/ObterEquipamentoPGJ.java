package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EquipamentoPGJDao;

public class ObterEquipamentoPGJ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ObterEquipamentoPGJ() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {response.getWriter().append("Served at: ").append(request.getContextPath());
				
			int idEquipamentoPGJ = Integer.valueOf(request.getParameter("codigo"));
			
			request.setAttribute("objEquipamentoPGJ", EquipamentoPGJDao.obterEquipamentoPorId(idEquipamentoPGJ));

			request.getRequestDispatcher("altera-equipamento.jsp").forward(request, response);
			
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
		
		
	}

}
