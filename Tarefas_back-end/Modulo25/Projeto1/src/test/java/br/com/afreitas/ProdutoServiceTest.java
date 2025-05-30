package br.com.afreitas;

import br.com.afreitas.dao.IProdutoDAO;
import br.com.afreitas.dao.ProdutoDAOMock;
import br.com.afreitas.domain.Produto;
import br.com.afreitas.exceptions.TipoChaveNaoEncontradaException;
import br.com.afreitas.services.IProdutoService;
import br.com.afreitas.services.ProdutoService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author arthur.freitas
 */
public class ProdutoServiceTest {

    private final IProdutoService produtoService;

    private Produto produto;

    public ProdutoServiceTest() {
        IProdutoDAO dao = new ProdutoDAOMock();
        produtoService = new ProdutoService(dao);
    }

    @Before
    public void init() {
        produto = new Produto();
        produto.setNome("Carro");
        produto.setCodigo("98798798798");

    }

    @Test
    public  void salvarProduto() throws TipoChaveNaoEncontradaException {
        Boolean retorno = produtoService.salvar(produto);
        Assert.assertTrue(retorno);
    }

    @Test
    public  void buscarProduto() throws TipoChaveNaoEncontradaException {
        Produto produto1 = this.produtoService.pesquisar(produto.getCodigo());
        Assert.assertNotNull(produto1);
    }

    @Test
    public void excluirCliente() {
        produtoService.excluir(produto.getCodigo());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        produto.setNome("Canoa");
        produtoService.mudar(produto);
        Assert.assertEquals("Canoa", produto.getNome());
    }
}
