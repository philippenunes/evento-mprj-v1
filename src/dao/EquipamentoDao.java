package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import conexao.Conexao;
import negocio.Equipamento;

public class EquipamentoDao {

	public static boolean inserir(Equipamento equipamento) {

		PreparedStatement ps = null;

		try {

			ps = Conexao.obterConexao().prepareStatement("insert into equipamento (notebook, impressora) values (?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, equipamento.getNotebook());
			ps.setInt(2, equipamento.getImpressora());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int idGerado = rs.getInt(1);
			equipamento.setId(idGerado);

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
