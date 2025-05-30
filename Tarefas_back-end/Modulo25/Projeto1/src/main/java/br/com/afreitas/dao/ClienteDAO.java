package br.com.afreitas.dao;

import br.com.afreitas.dao.generics.GenericDAO;
import br.com.afreitas.domain.Cliente;

/**
 * @author arthur.freitas
 */
public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

    public ClienteDAO(){super();}

    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualizarDados(Cliente entity, Cliente entityCadastrado) {

    }
}
