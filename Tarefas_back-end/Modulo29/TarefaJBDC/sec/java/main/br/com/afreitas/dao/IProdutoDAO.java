package br.com.afreitas.dao;

import java.util.List;

import br.com.afreitas.domain.Produto;

/**
*@author arthur.freitas 
*
*/
public interface IProdutoDAO {
	public Integer cadastrar(Produto produto) throws Exception;
	
	public Produto consultar(String codigo) throws Exception;
	
	public Integer atualizar(Produto produto) throws Exception;
	
	public Integer excluir(Produto produtoBD) throws Exception;
	
	public List<Produto> buscarTodos() throws Exception;
}
