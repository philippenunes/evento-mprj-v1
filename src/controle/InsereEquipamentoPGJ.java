package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EquipamentoPGJDao;
import negocio.EquipamentoPGJ;

public class
InsereEquipamentoPGJ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsereEquipamentoPGJ() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		EquipamentoPGJ equipamento = new EquipamentoPGJ();

		// VERIFICA O MODELO ATRAV�S DO NUMERO
		String tipo = request.getParameter("tipo");
		if (tipo.equals("1")) {
			equipamento.setTipo("Desktop");
		} else {
			if (tipo.equals("2")) {
				equipamento.setTipo("Notebook");
			} else {
				if (tipo.equals("3")) {
					equipamento.setTipo("Impressora");
				} else {
					if (tipo.equals("4")) {
						equipamento.setTipo("Monitor");
					}
				}
			}
		}

		// VERIFICA A SITUACAO ATRAV�S DO NUMERO
		String situacao = request.getParameter("situacao");
		if (situacao.equals("1")) {
			equipamento.setSituacao("Ativo");
		} else {
			equipamento.setSituacao("Inativo");
		}

		equipamento.setModelo(request.getParameter("modelo"));
		equipamento.setPn(Integer.valueOf(request.getParameter("pn")));
		equipamento.setSerial(request.getParameter("sn"));
		equipamento.setComentario(request.getParameter("comentario"));

		if (EquipamentoPGJDao.inserir(equipamento) != false) {
			request.setAttribute("objEquipamentoPGJ", equipamento);
			request.getRequestDispatcher("cadastro-equipamento.jsp").forward(request, response);
		} else {
			request.setAttribute("objEquipamentoPGJ", null);
			request.getRequestDispatcher("cadastro-equipamento.jsp").forward(request, response);
		}

	}

}
