package controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EquipamentoDao;
import dao.EventoDao;
import negocio.Equipamento;
import negocio.Evento;

public class AlteraEvento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlteraEvento() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {doGet(request, response);
			
			//INSERE EQUIPAMENTO
			Equipamento equipamento = new Equipamento();
			equipamento.setNotebook(Integer.valueOf(request.getParameter("notebook")));
			equipamento.setImpressora(Integer.valueOf(request.getParameter("impressora")));
			EquipamentoDao.inserir(equipamento);
			
			//INSERE EVENTO
			Evento evento = new Evento();
			evento.setEquipamento(equipamento);
			evento.setId(Integer.valueOf(request.getParameter("idevento")));
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
					
			
			PrintWriter out = response.getWriter();

			if (EventoDao.alterar(evento)){
				request.setAttribute("objEvento", evento);
				request.getRequestDispatcher("lista-evento.jsp?parametro=0").forward(request, response);
			}else{
				out.println("Não foi possivel alterar!");
			}

		}

			
	}


