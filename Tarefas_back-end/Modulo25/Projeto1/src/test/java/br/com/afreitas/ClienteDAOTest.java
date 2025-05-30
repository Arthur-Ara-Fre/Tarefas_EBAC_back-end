package br.com.afreitas;

import br.com.afreitas.dao.ClienteDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.afreitas.dao.IClienteDAO;
import br.com.afreitas.domain.Cliente;
import br.com.afreitas.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author arthur.freitas
 */
public class ClienteDAOTest {


        private final IClienteDAO clienteDAO;

        private Cliente cliente;

        public ClienteDAOTest() {
            clienteDAO = new ClienteDAO();
        }

        @Before
        public void init() throws TipoChaveNaoEncontradaException {
            cliente = new Cliente();
            cliente.setCpf(12312312312L);
            cliente.setNome("Arthur");
            cliente.setCidade("Uberaba");
            cliente.setEnd("End");
            cliente.setEstado("MG");
            cliente.setNumero(10);
            cliente.setTel(1199999999L);
            clienteDAO.cadastrar(cliente);
        }

        @Test
        public void pesquisarCliente() {
            Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());
            Assert.assertNotNull(clienteConsultado);
        }

        @Test
        public void  salvarCliente() throws TipoChaveNaoEncontradaException {
            cliente.setCpf(454545454545L);
            Boolean retorno = clienteDAO.cadastrar(cliente);
            Assert.assertTrue(retorno);
         }

        @Test
        public void excluirCliente() {
            clienteDAO.excluir(cliente.getCpf());
        }

        @Test
        public void alterarCliente() throws TipoChaveNaoEncontradaException {
            cliente.setNome("Arthur Araújo");
            clienteDAO.alterar(cliente);
            Assert.assertEquals("Arthur Araújo", cliente.getNome());
        }

    }

