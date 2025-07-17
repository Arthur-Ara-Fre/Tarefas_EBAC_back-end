package br.com.afreitas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.afreitas.dao.IProdutoDAO;
import br.com.afreitas.dao.ProdutoDAO;
import br.com.afreitas.domain.Produto;

/**
*@author arthur.freitas 
*
*/
public class ProdutoTest {
	
	@Test
	public void CadastrarTest() throws Exception {
		IProdutoDAO dao = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setCodigo("11");
		produto.setNome("Cadeira");
		Integer qtd = dao.cadastrar(produto);
		assertTrue(qtd == 1);
		
		Produto produto1 = new Produto();
		produto1.setCodigo("22");
		produto1.setNome("Mesa");
		Integer qtd1 = dao.cadastrar(produto1);
		assertTrue(qtd1 == 1);
		
		Integer qtdTotal = qtd+qtd1;
		assertTrue(qtdTotal == 2);
		
		Integer qtdDel = dao.excluir(produto);
		Integer qtdDel1 = dao.excluir(produto1);
		Integer qtdDelTotal = qtdDel+qtdDel1;
		assertTrue(qtdDelTotal == 2);
		
	}
	@Test
	public void buscarTeste() throws Exception {
		IProdutoDAO dao = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setCodigo("11");
		produto.setNome("Cadeira");
		Integer qtd = dao.cadastrar(produto);
		assertTrue(qtd == 1);
		
		Produto produtoBD = new Produto();
		produtoBD = dao.consultar("11");
		assertNotNull(produtoBD);
		assertEquals(produtoBD.getCodigo(), produto.getCodigo());
		assertEquals(produtoBD.getNome(), produto.getNome());
		
		Integer qtdDel = dao.excluir(produto);
		assertTrue(qtdDel == 1);
		
	}
	
	@Test
	public void atualizarTest() throws Exception {
		IProdutoDAO dao = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setCodigo("11");
		produto.setNome("Cadeira");
		Integer qtd = dao.cadastrar(produto);
		assertTrue(qtd == 1);
		
		Produto produtoBD = new Produto();
		produtoBD = dao.consultar("11");
		assertNotNull(produtoBD);
		assertEquals(produtoBD.getCodigo(), produto.getCodigo());
		assertEquals(produtoBD.getNome(), produto.getNome());
		
		produtoBD.setCodigo("22");
		produtoBD.setNome("Mesa");
		Integer qtd1 = dao.atualizar(produtoBD);
		assertTrue(qtd1 == 1);
		
		Integer qtdDel = dao.excluir(produtoBD);
		assertTrue(qtdDel == 1);
	}
	
	@Test
	public void excluirTest()  throws Exception{
		IProdutoDAO dao = new ProdutoDAO();
		
		Produto produto =new Produto();
		produto.setCodigo("11");
		produto.setNome("mesa");
		Integer qtd = dao.cadastrar(produto);
		assertTrue(qtd == 1);
		
		Produto produtoBD = dao.consultar("11");
		assertNotNull(produtoBD);
		assertEquals(produto.getCodigo(), produtoBD.getCodigo());
		assertEquals(produto.getNome(), produtoBD.getNome());
		
		Integer qtdDel = dao.excluir(produtoBD);
		assertTrue(qtdDel == 1);
		
	}
	
	@Test
	public void buscarTodos() throws Exception {
		IProdutoDAO dao = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setCodigo("11");
		produto.setNome("Mesa");
		Integer qtd1 = dao.cadastrar(produto);
		assertTrue(qtd1 == 1);
		
		Produto produto1 = new Produto();
		produto1.setNome("Cadeira");
		produto1.setCodigo("22");
		Integer qtd2 = dao.cadastrar(produto1);
		assertTrue(qtd2 == 1);
		
		List <Produto> list = dao.buscarTodos();
		assertNotNull(list);
		assertEquals(2, list.size());
		
		int qtdDel = 0;
		for(Produto pro : list) {
			dao.excluir(pro);
			qtdDel++;
		}
		assertEquals(list.size(), qtdDel);
		
		list = dao.buscarTodos();
		assertEquals(list.size(), 0);
	}
}
