package br.com.afreitas.dao;

import br.com.afreitas.domain.Cliente;
import java.util.Collection;

/**
 * @author arthur.freitas
 */
public interface IClienteDAO {

    boolean cadastrar(Cliente cliente);

    boolean excluir(Long cpf);

    void alterar(Cliente cliente);

    Cliente consultar(Long cpf);

    Collection<Cliente> buscarTodos();
}
