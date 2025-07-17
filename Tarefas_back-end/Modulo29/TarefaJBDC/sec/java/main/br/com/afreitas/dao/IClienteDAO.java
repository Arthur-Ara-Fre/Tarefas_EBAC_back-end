package br.com.afreitas.dao;

import java.util.List;

import br.com.afreitas.domain.Cliente;

/**
 * @author arthur.freitas
 * 
 */
public interface IClienteDAO {
	
	public Integer cadastrar(Cliente cliente) throws Exception;

	public Cliente consultar(String codigo) throws Exception;
	
	public Integer atualizar(Cliente cliente) throws Exception; 
	
	public Integer excluir(Cliente clienteBD) throws Exception; 
		
	public List<Cliente> buscarTodos()  throws Exception;
	

}
