package com.crudjsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crudjsp.bean.Usuario;
import com.crudjsp.exception.DbException;
import com.crudjsp.factory.ConnectionFactory;
import com.mysql.jdbc.PreparedStatement;

public class UsuarioDAO {

	public static List<Usuario> listarUsuarios() throws Exception {
		List<Usuario> lista = new ArrayList<Usuario>();
		String sql = "SELECT * FROM usuario";

		Connection conx = null;
		PreparedStatement ps = null;
		ResultSet rset = null;

		try {
			conx = ConnectionFactory.criandoConexaoBanco();
			ps = (PreparedStatement) conx.prepareStatement(sql);
			rset = ps.executeQuery();

			while (rset.next()) {
				Usuario usuario = new Usuario();

				usuario.setId(rset.getInt("id"));
				usuario.setNome(rset.getString("nome"));
				usuario.setEmail(rset.getString("email"));
				usuario.setIdade(rset.getInt("idade"));
				usuario.setEstado(rset.getString("estado"));

				lista.add(usuario);
			}
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		} // try-catch
		finally {
			ConnectionFactory.fecharConexao(conx);
			ConnectionFactory.fecharStatement(ps);
			ConnectionFactory.fecherResultSet(rset);
		} // fially
		return lista;

	}

	public static Usuario obterRegistroId(int id) {
		Usuario usuario = null;

		Connection conx = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM usuario WHERE id=?";

		try {
			conx = ConnectionFactory.criandoConexaoBanco();
			ps = (PreparedStatement) conx.prepareStatement(sql);

			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				usuario = new Usuario();

				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setIdade(rs.getInt("idade"));
				usuario.setEstado(rs.getString("estado"));
			}
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		} finally {
			ConnectionFactory.fecharConexao(conx);
			ConnectionFactory.fecharStatement(ps);
			ConnectionFactory.fecherResultSet(rs);
		} // fially

		return usuario;
	}

	public static int editarUsuario(Usuario u) {

		int status = 0;
		Connection conx = null;
		PreparedStatement ps = null;
		String sql = "UPDATE usuario" + " SET nome=?," + " email=?," + " idade=?," + " estado=?" + " WHERE id=?";

		try {
			conx = ConnectionFactory.criandoConexaoBanco();
			ps = (PreparedStatement) conx.prepareStatement(sql);

			ps.setString(1, u.getNome());
			ps.setString(2, u.getEmail());
			ps.setInt(3, u.getIdade());
			ps.setString(4, u.getEstado());
			ps.setInt(5, u.getId());

			status = ps.executeUpdate();

		} catch (Exception e) {
			throw new DbException(e.getMessage());
		} // try-catch
		finally {
			ConnectionFactory.fecharConexao(conx);
			ConnectionFactory.fecharStatement(ps);
		} // finally-try-catch
		return status;

	}

	public static int cadastrarUsuario(Usuario usuario) {

		int status = 0;
		Connection conx = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO usuario" + "(nome," + " email," + " idade," + " estado)" + " VALUES(?, ?, ?, ?)";

		try {
			conx = ConnectionFactory.criandoConexaoBanco();
			ps = (PreparedStatement) conx.prepareStatement(sql);

			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			ps.setInt(3, usuario.getIdade());
			ps.setString(4, usuario.getEstado());

			status = ps.executeUpdate();

		} catch (Exception e) {
			throw new DbException(e.getMessage());
		} // try-catch

		finally {
			ConnectionFactory.fecharConexao(conx);
			ConnectionFactory.fecharStatement(ps);
		} // finnaly-try-catch
		return status;
	}

	public static int deletarUsuario(Usuario usuario) {

		int status = 0;
		Connection conx = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM usuario WHERE id=?";

		try {

			conx = ConnectionFactory.criandoConexaoBanco();
			ps = (PreparedStatement) conx.prepareStatement(sql);

			ps.setInt(1, usuario.getId());

			status = ps.executeUpdate();

		} catch (Exception e) {
			throw new DbException(e.getMessage());
		} // try-catch
		finally {
			ConnectionFactory.fecharConexao(conx);
			ConnectionFactory.fecharStatement(ps);
		} // finnaly

		return status;
	}
}
