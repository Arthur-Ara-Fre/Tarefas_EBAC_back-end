package br.com.afreitas;

import br.com.afreitas.exceptions.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.afreitas.dao.IProdutoDAO;
import br.com.afreitas.dao.ProdutoDAO;
import br.com.afreitas.domain.Produto;

/**
 * @author arthur.freitas
 */
public class ProdutoDAOTest{
    private final IProdutoDAO produtoDAO;

    private Produto produto;

    public ProdutoDAOTest() {
        produtoDAO = new ProdutoDAO();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        produto = new Produto();
        produto.setNome("Carro");
        produto.setCodigo("98798798798");
        produtoDAO.cadastrar(produto);
    }

    @Test
    public  void salvarProduto() throws TipoChaveNaoEncontradaException {
        produto.setCodigo("AAA");
        Boolean retorno = produtoDAO.cadastrar(produto);
        Assert.assertTrue(retorno);
    }

    @Test
    public  void buscarProduto() throws TipoChaveNaoEncontradaException {
        Produto produto1 = this.produtoDAO.consultar(produto.getCodigo());
        Assert.assertNotNull(produto1);
    }

    @Test
    public void excluirCliente() {
        produtoDAO.excluir(produto.getCodigo());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        produto.setNome("Copo");
        produtoDAO.alterar(produto);
        Assert.assertEquals("Copo", produto.getNome());
    }
}
