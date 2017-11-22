package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.Evento;

public class EventoDao {

	public static boolean inserir(Evento evento) {

		PreparedStatement ps = null;

		try {

			ps = Conexao.obterConexao().prepareStatement(
					"insert into evento (solicitante, telefone, nome, data, local, inicio, termino, presencatecnico, acessorede, registro, observacao, idequipamento_fk) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, evento.getSolicitante());
			ps.setString(2, evento.getTelefone());
			ps.setString(3, evento.getNomeEvento());
			ps.setString(4, evento.getDataEvento());
			ps.setString(5, evento.getLocalEvento());
			ps.setString(6, evento.getHoraInicio());
			ps.setString(7, evento.getHoraTermino());
			ps.setString(8, evento.getPresencaTecnico());
			ps.setString(9, evento.getAcessoRede());
			ps.setInt(10, evento.getRegistro());
			ps.setString(11, evento.getObservacao());
			ps.setInt(12, evento.getEquipamento().getId());
			ps.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static List<Evento> obterLista(int parametro) {

		// VERIFICA O TIPO DA PESQUISA
		String sql = null;
		if (parametro == 0) {
			sql = "SELECT ev.idevento, ev.solicitante, ev.telefone, ev.nome, date_format(ev.data, '%Y/%m/%d') as data, ev.local, ev.inicio, ev.termino, ev.presencatecnico, ev.acessorede, ev.registro, ev.observacao, eq.notebook, eq.impressora FROM evento ev INNER JOIN equipamento eq ON ev.idequipamento_fk = eq.idequipamento order by data";
		} else {
			if (parametro == 1) {
				sql = "SELECT ev.idevento, ev.solicitante, ev.telefone, ev.nome, date_format(ev.data, '%Y/%m/%d') as data, ev.local, ev.inicio, ev.termino, ev.presencatecnico, ev.acessorede, ev.registro, ev.observacao, eq.notebook, eq.impressora FROM evento ev INNER JOIN equipamento eq ON ev.idequipamento_fk = eq.idequipamento order by nome ASC";
			} else {
				if (parametro == 2) {
					sql = "SELECT ev.idevento, ev.solicitante, ev.telefone, ev.nome, date_format(ev.data, '%Y/%m/%d') as data, ev.local, ev.inicio, ev.termino, ev.presencatecnico, ev.acessorede, ev.registro, ev.observacao, eq.notebook, eq.impressora FROM evento ev INNER JOIN equipamento eq ON ev.idequipamento_fk = eq.idequipamento order by registro";
				}
			}
		}

		List<Evento> eventos = null;

		PreparedStatement ps = null;

		try {
			ps = Conexao.obterConexao().prepareStatement(sql);

			ResultSet rs = null;

			rs = ps.executeQuery();

			eventos = new ArrayList<Evento>();

			while (rs.next()) {
				Evento evento = new Evento(rs.getInt("idevento"), rs.getString("solicitante"), rs.getString("telefone"),
						rs.getString("nome"), rs.getString("data"), rs.getString("local"), rs.getString("inicio"),
						rs.getString("termino"), rs.getString("presencatecnico"), rs.getString("acessorede"),
						rs.getInt("registro"), rs.getString("observacao"), rs.getInt("notebook"),
						rs.getInt("impressora"));
				eventos.add(evento);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return eventos;
	}

	public static Evento obterEventoPorId(int id) {

		Evento evento = null;

		PreparedStatement ps = null;

		try {

			ps = Conexao.obterConexao().prepareStatement(
					"SELECT ev.idevento, ev.solicitante, ev.telefone, ev.nome, ev.data, ev.local, ev.inicio, ev.termino, ev.presencatecnico, ev.acessorede, ev.registro, ev.observacao, eq.notebook, eq.impressora FROM evento ev INNER JOIN equipamento eq ON ev.idequipamento_fk = eq.idequipamento AND idevento = ?");
			ps.setInt(1, id);

			ResultSet rs = null;

			rs = ps.executeQuery();

			if (rs.next()) {
				evento = new Evento(rs.getInt("idevento"), rs.getString("solicitante"), rs.getString("telefone"),
						rs.getString("nome"), rs.getString("data"), rs.getString("local"), rs.getString("inicio"),
						rs.getString("termino"), rs.getString("presencatecnico"), rs.getString("acessorede"),
						rs.getInt("registro"), rs.getString("observacao"), rs.getInt("notebook"),
						rs.getInt("impressora"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return evento;
	}

	public static boolean excluir(Evento evento) {
		PreparedStatement ps = null;

		try {
			ps = Conexao.obterConexao().prepareStatement("DELETE FROM evento WHERE idevento = ?");
			ps.setInt(1, evento.getId());

			ps.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean alterar(Evento evento) {
		PreparedStatement ps = null;

		try {
			ps = Conexao.obterConexao().prepareStatement(
					"UPDATE evento as ev INNER JOIN equipamento as eq " +
							"ON ev.idequipamento_fk = eq.idequipamento " +
							"SET ev.solicitante = ?, ev.telefone = ?, ev.nome = ?, ev.data = ?, ev.local = ?, ev.inicio = ?, ev.termino  = ?, ev.presencatecnico = ?, ev.acessorede = ?, ev.registro = ?, ev.observacao = ?, eq.notebook = ?, eq.impressora = ? WHERE idevento = ?");
			ps.setString(1, evento.getSolicitante());
			ps.setString(2, evento.getTelefone());
			ps.setString(3, evento.getNomeEvento());
			ps.setString(4, evento.getDataEvento());
			ps.setString(5, evento.getLocalEvento());
			ps.setString(6, evento.getHoraInicio());
			ps.setString(7, evento.getHoraTermino());
			ps.setString(8, evento.getPresencaTecnico());
			ps.setString(9, evento.getAcessoRede());
			ps.setInt(10, evento.getRegistro());
			ps.setString(11, evento.getObservacao());
			ps.setInt(12, evento.getEquipamento().getNotebook());
			ps.setInt(13, evento.getEquipamento().getImpressora());
			ps.setInt(14, evento.getId());

			ps.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}
}
