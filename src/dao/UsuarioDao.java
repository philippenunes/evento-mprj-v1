package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;
import negocio.Usuario;

public class UsuarioDao {

	public static Usuario obterUsuario(String login, String senha) {

		Usuario usuario = null;

		PreparedStatement ps = null;

		try {
			ps = Conexao.obterConexao().prepareStatement("select * from usuario where login = ? and senha = ?");
			ps.setString(1, login);
			ps.setString(2, senha);

			ResultSet rs = null;

			rs = ps.executeQuery();

			while (rs.next()) {
				usuario = new Usuario(rs.getInt("idusuario"), rs.getString("login"), rs.getString("senha"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}

}
