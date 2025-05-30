package br.com.afreitas;

import br.com.afreitas.dao.IClienteDAO;
import br.com.afreitas.domain.Cliente;
import br.com.afreitas.exceptions.TipoChaveNaoEncontradaException;
import br.com.afreitas.services.ClienteService;
import br.com.afreitas.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import br.com.afreitas.dao.ClienteDAOMock;

/**
 * @author arthur.freitas
 */
public class ClienteServiceTest {

    private final IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDAOMock();
        clienteService = new ClienteService(dao);

    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Arthur");
        cliente.setCidade("Uberaba");
        cliente.setEnd("End");
        cliente.setEstado("MG");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
    }

    @Test
    public void  salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.salvar(cliente);
        Assert.assertTrue(retorno);
    }
    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteService.pesquisar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Arthur Araújo");
        clienteService.mudar(cliente);
        Assert.assertEquals("Arthur Araújo", cliente.getNome());
    }
}
