package br.com.afreitas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.afreitas.dao.jdbc.ConnectionFactory;
import br.com.afreitas.domain.Produto;

/**
*@author arthur.freitas 
*
*/
public class ProdutoDAO implements IProdutoDAO {

	@Override
	public Integer cadastrar(Produto produto) throws Exception{
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "INSERT INTO TB_PRODUTO (ID, CODIGO, NOME) VALUES (nextval('SQ_PRODUTO'),?,?)";
			stm = connection.prepareStatement(sql);
			stm.setString(1, produto.getCodigo());
			stm.setString(2, produto.getNome());
			return stm.executeUpdate();
		}catch(Exception e) {
			throw e;
		} finally {
			if(stm != null && !stm.isClosed() ) {
				stm.close();
			}
			if(connection != null && !connection.isClosed() ) {
				connection.close();
			}
		}
		
	}

	@Override
	public Produto consultar(String codigo) throws Exception{
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Produto produto = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM TB_PRODUTO WHERE CODIGO = ?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, codigo);
			rs = stm.executeQuery();
			if (rs.next()) {
				 produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setCodigo(rs.getString("codigo"));
				produto.setNome(rs.getString("nome"));
			}
			return produto;
		}catch(Exception e) {
			throw e;
		}finally {
			if(stm != null && !stm.isClosed() ) {
				stm.close();
			}
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
		
		
	}

	@Override
	public Integer atualizar(Produto produto) throws Exception{
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			String sql = "UPDATE TB_PRODUTO SET NOME = ?, CODIGO = ? WHERE ID = ?";
			connection = ConnectionFactory.getConnection();
			stm = connection.prepareStatement(sql);
			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getCodigo());
			stm.setLong(3, produto.getId());
			return stm.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			if (stm != null && !stm.isClosed() ) {
				stm.close();
			}
			if (connection != null && !connection.isClosed() ) {
				connection.close();
			}
		}
	}

	@Override
	public Integer excluir(Produto produtoBD) throws Exception{
		Connection connection = null;
		PreparedStatement stm = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "DELETE FROM TB_PRODUTO WHERE CODIGO = ?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, produtoBD.getCodigo());
			return stm.executeUpdate();
		}finally {
			if(stm != null && !stm.isClosed()) {
				stm.close();
			}
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
		
	}

	@Override
	public List<Produto> buscarTodos() throws Exception{
		Connection connection = null;
		PreparedStatement stm= null;
		ResultSet rs = null;
		List<Produto> list = new ArrayList<>();
		Produto produto = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM TB_PRODUTO";
			stm = connection.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				produto = new Produto();
				Long id = rs.getLong("ID");
				String nome = rs.getString("NOME");
				String cd = rs.getString("CODIGO");
				produto.setId(id);
				produto.setNome(nome);
				produto.setCodigo(cd);
				list.add(produto);
			}
		}catch(Exception e) {
			throw e;
		}finally {
			if(stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed() ) {
				connection.close();
			}
			
			
			
		}
		return list;
	}
	
}
