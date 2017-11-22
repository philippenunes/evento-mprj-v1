package controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EquipamentoPGJDao;
import negocio.EquipamentoPGJ;

public class AlteraEquipamentoPGJ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlteraEquipamentoPGJ() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {response.getWriter().append("Served at: ").append(request.getContextPath());
	}

		
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {doGet(request, response);
			
			EquipamentoPGJ equipamento = new EquipamentoPGJ();

			// VERIFICA O MODELO ATRAVÉS DO NUMERO
			String tipo = request.getParameter("tipo");
			if (tipo.equals("1")) {
				equipamento.setTipo("Desktop");
			} else {
				if (tipo.equals("2")) {
					equipamento.setTipo("Notebook");
				} else {
					if (tipo.equals("3")) {
						equipamento.setTipo("Impressora");
					}
				}
			}

			// VERIFICA A SITUACAO ATRAVÉS DO NÚMERO
			String situacao = request.getParameter("situacao");
			if (situacao.equals("1")) {
				equipamento.setSituacao("Ativo");
			} else {
				equipamento.setSituacao("Inativo");
			}

			equipamento.setId(Integer.valueOf(request.getParameter("id")));
			equipamento.setModelo(request.getParameter("modelo"));
			equipamento.setPn(Integer.valueOf(request.getParameter("pn")));
			equipamento.setSerial(request.getParameter("sn"));
			equipamento.setComentario(request.getParameter("comentario"));
			
			
			PrintWriter out = response.getWriter();

			if (EquipamentoPGJDao.alterar(equipamento)){
				request.setAttribute("objEquipamento", equipamento);
				request.getRequestDispatcher("lista-equipamento.jsp?parametro=0").forward(request, response);
			}else{
				out.println("Não foi possivel alterar!!!");
			}
			
	}

}
