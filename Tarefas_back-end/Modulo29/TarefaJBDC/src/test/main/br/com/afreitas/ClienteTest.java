/**
 *
 */
package br.com.afreitas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.afreitas.dao.ClienteDAO;
import br.com.afreitas.dao.IClienteDAO;
import br.com.afreitas.domain.Cliente;

/**
*@author arthur.freitas 
*
*/
public class ClienteTest {
		/*Cliente clienteBD = dao.consultar(cliente.getCodigo());
		assertNotNull(clienteBD);
		assertNotNull(clienteBD.getId());
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());
		
		clienteBD.setNome("Arthur Freitas");
		clienteBD.setCodigo("01");
		Integer qtdAtlz = dao.atualizar(clienteBD);
		assertNotNull(qtdAtlz);
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Pedrinho");
		cliente2.setCodigo("22");
		qtd = dao.cadastrar(cliente2);
		assertTrue(qtd == 1);
		
		List<Cliente> list = dao.buscarTodos();
		assertNotNull(list);
		assertEquals(2,list.size());
		
		
		Integer qtdDel = dao.excluir(clienteBD);
		qtdDel = dao.excluir(cliente);
		qtdDel = dao.excluir(cliente2);
		assertNotNull(qtdDel);*/
			
	@Test
	public void cadastrarTest() throws Exception {
		IClienteDAO dao = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("11");
		cliente.setNome("Joãozinho");
		Integer qtd1 = dao.cadastrar(cliente);
		
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Pedrinho");
		cliente1.setCodigo("22");
		Integer qtd2 = dao.cadastrar(cliente1);
		
		Integer qtdTotal = qtd1+qtd2;
		assertTrue(qtdTotal == 2);
		
		Integer countDel1 = dao.excluir(cliente);
		Integer countDel2 = dao.excluir(cliente1);
		Integer countDelTotal = countDel1 + countDel2;
		assertTrue(countDelTotal == 2);
		
	}
	
	@Test
	public void buscarTest() throws Exception {
		IClienteDAO dao = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("11");
		cliente.setNome("Arthur Freitas");
		Integer qtd = dao.cadastrar(cliente);
		
		assertTrue(qtd == 1);
		
		Cliente clienteBD = dao.consultar("11");
		assertNotNull(clienteBD);
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());
		
		Integer countDel = dao.excluir(clienteBD);
		assertTrue(countDel == 1);
	}
	
	@Test
	public void excluirTest()throws Exception {
		IClienteDAO dao = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("11");
		cliente.setNome("Arthur Freitas");
		Integer qtd = dao.cadastrar(cliente);
		assertTrue(qtd == 1);
		
		Cliente clienteBD = new Cliente();
		clienteBD = dao.consultar("11");
		assertNotNull(clienteBD);
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());
		
		Integer qtdDel = dao.excluir(clienteBD);
		assertTrue(qtdDel == 1);
	}
	
	@Test
	public void buscarTodosTest() throws Exception {
		IClienteDAO dao = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("11");
		cliente.setNome("Arthur Freitas");
		Integer qtd1 = dao.cadastrar(cliente);
		assertTrue(qtd1 == 1);
		
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Pedrinho");
		cliente1.setCodigo("22");
		Integer qtd2 = dao.cadastrar(cliente1);
		assertTrue(qtd2 == 1);
		
		List <Cliente> list = dao.buscarTodos();
		assertNotNull(list);
		assertEquals(2, list.size());
		
		int qtdDel = 0;
		for(Cliente cli : list) {
			dao.excluir(cli);
			qtdDel++;
		}
		assertEquals(list.size(), qtdDel);
		
		list = dao.buscarTodos();
		assertEquals(list.size(), 0);
	}
	
	@Test
	public void atualizarTest() throws Exception {
		IClienteDAO dao = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("11");
		cliente.setNome("Joãozinho");
		Integer qtd = dao.cadastrar(cliente);
		assertTrue(qtd == 1);
		
		Cliente clienteBD = dao.consultar("11");
		assertNotNull(clienteBD);
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());
		
		clienteBD.setCodigo("22");
		clienteBD.setNome("Arthur Freitas");
		Integer qtdAtlz = dao.atualizar(clienteBD);
		assertTrue(qtdAtlz == 1);
		
		Cliente clienteBD1 = dao.consultar("11");
		assertNull(clienteBD1);
		
		Cliente clienteBD2 = dao.consultar("22");
		assertNotNull(clienteBD2);
		assertEquals(clienteBD.getId(), clienteBD2.getId());
		assertEquals(clienteBD.getCodigo(), clienteBD2.getCodigo());
		assertEquals(clienteBD.getNome(), clienteBD.getNome());
		
		int qtdDel = 0;
		List<Cliente> list = dao.buscarTodos();
		for ( Cliente cli : list) {
			dao.excluir(cli);
			qtdDel++;
		}
		assertEquals(list.size(), qtdDel);
		
		list = dao.buscarTodos();
		
		assertEquals(list.size(), 0);
	}
}
