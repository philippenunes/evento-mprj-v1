package testes;

import java.util.List;
import dao.EventoDao;
import negocio.Evento;

public class TestaListaEvento {

	public static void main(String[] args) {
		
		List<Evento> evento = EventoDao.obterLista(1);

	    for (Evento lista : evento) {
	        System.out.println("IdViagem: " + lista.getNomeEvento());

	    }
	}

}
