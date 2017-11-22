package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.EquipamentoPGJ;

public class EquipamentoPGJDao {

	public static boolean inserir(EquipamentoPGJ equipamento) {

		PreparedStatement ps = null;

		try {

			ps = Conexao.obterConexao().prepareStatement(
					"insert into equipamentopgj (tipo, modelo, situacao, pn, sn, comentario) values (?, ?, ?, ?, ?, ?)");
			ps.setString(1, equipamento.getTipo());
			ps.setString(2, equipamento.getModelo());
			ps.setString(3, equipamento.getSituacao());
			ps.setInt(4, equipamento.getPn());
			ps.setString(5, equipamento.getSerial());
			ps.setString(6, equipamento.getComentario());
			ps.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static List<EquipamentoPGJ> obterLista(int parametro) {

		String sql = null;

		List<EquipamentoPGJ> equipamentos = null;

		PreparedStatement ps = null;

		if (parametro == 0) {
			sql = "SELECT * FROM equipamentopgj order by tipo";
		} else {
			if (parametro == 1)
				sql = "SELECT * FROM equipamentopgj order by modelo";

		}

		try {

			ps = Conexao.obterConexao().prepareStatement(sql);

			ResultSet rs = null;

			rs = ps.executeQuery();

			equipamentos = new ArrayList<EquipamentoPGJ>();

			while (rs.next()) {
				EquipamentoPGJ equipamento = new EquipamentoPGJ(rs.getInt("id"), rs.getString("tipo"),
						rs.getString("modelo"), rs.getString("situacao"), rs.getInt("pn"), rs.getString("sn"),
						rs.getString("comentario"));
				equipamentos.add(equipamento);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return equipamentos;
	}

	public static EquipamentoPGJ obterEquipamentoPorId(int id) {

		EquipamentoPGJ equipamento = null;

		PreparedStatement ps = null;

		try {

			ps = Conexao.obterConexao().prepareStatement("SELECT * FROM equipamentopgj WHERE id = ?");
			ps.setInt(1, id);

			ResultSet rs = null;

			rs = ps.executeQuery();

			if (rs.next()) {
				equipamento = new EquipamentoPGJ(rs.getInt("id"), rs.getString("tipo"), rs.getString("modelo"),
						rs.getString("situacao"), rs.getInt("pn"), rs.getString("sn"), rs.getString("comentario"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return equipamento;
	}

	public static boolean excluir(EquipamentoPGJ equipamento) {
		PreparedStatement ps = null;

		try {
			ps = Conexao.obterConexao().prepareStatement("DELETE FROM equipamentopgj WHERE id = ?");
			ps.setInt(1, equipamento.getId());

			ps.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean alterar(EquipamentoPGJ equipamento) {
		PreparedStatement ps = null;

		try {
			ps = Conexao.obterConexao().prepareStatement("UPDATE equipamentopgj "
					+ "SET tipo = ?, modelo = ?, situacao = ?, pn = ?, sn = ?, comentario = ?" + "WHERE id = ?");
			ps.setString(1, equipamento.getTipo());
			ps.setString(2, equipamento.getModelo());
			ps.setString(3, equipamento.getSituacao());
			ps.setInt(4, equipamento.getPn());
			ps.setString(5, equipamento.getSerial());
			ps.setString(6, equipamento.getComentario());
			ps.setInt(7, equipamento.getId());

			ps.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

}
