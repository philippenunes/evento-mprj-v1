package testes;

import dao.EventoDao;
import negocio.Evento;

public class TestaObterEvento {

	public static void main(String[] args) {
		
		Evento evento = new Evento();
		evento = EventoDao.obterEventoPorId(22);
		
		System.out.println(evento.getEquipamento().getNotebook());

	}

}
