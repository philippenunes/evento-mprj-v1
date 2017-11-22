package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EquipamentoDao;
import dao.EventoDao;
import negocio.Equipamento;
import negocio.Evento;

@WebServlet("/InsereEvento")
public class InsereEvento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsereEvento() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		// CRIA O OBJETO EQUIPAMENTO
		Equipamento equipamento = new Equipamento();
		equipamento.setNotebook(Integer.valueOf(request.getParameter("notebook")));
		equipamento.setImpressora(Integer.valueOf(request.getParameter("impressora")));
		EquipamentoDao.inserir(equipamento);

		// CRIA O OBJETO EVENTO
		Evento evento = new Evento();
		evento.setEquipamento(equipamento);
		evento.setSolicitante(request.getParameter("solicitante"));
		evento.setTelefone(request.getParameter("telefone"));
		evento.setNomeEvento(request.getParameter("nome"));
		evento.setDataEvento(request.getParameter("data"));
		evento.setLocalEvento(request.getParameter("local"));
		evento.setHoraInicio(request.getParameter("horaInicio"));
		evento.setHoraTermino(request.getParameter("horaTermino"));
		evento.setPresencaTecnico(request.getParameter("presencaTecnico"));
		evento.setAcessoRede(request.getParameter("acessoRede"));
		evento.setRegistro(Integer.valueOf(request.getParameter("registro")));
		evento.setObservacao(request.getParameter("observacao"));
		
		//INSERE O EVENTO NO BANCO
		if(EventoDao.inserir(evento) != false){
			request.setAttribute("objEvento", evento);
			request.getRequestDispatcher("cadastro-evento.jsp").forward(request, response);
		}else{
			request.setAttribute("objEvento", null);
			request.getRequestDispatcher("cadastro-evento.jsp").forward(request, response);
		}

	}
}
