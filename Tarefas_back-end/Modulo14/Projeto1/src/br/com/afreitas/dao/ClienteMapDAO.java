package br.com.afreitas.dao;

import br.com.afreitas.domain.Cliente;
import java.util.*;

/**
 *@author arthur.freitas
 */
public class ClienteMapDAO implements IClienteDAO{

    private Map<Long,Cliente> map;

    public ClienteMapDAO(){
        this.map = new HashMap<>();
    }

    @Override
    public boolean cadastrar(Cliente cliente) {
        if (this.map.containsKey(cliente.getCpf())){
            return false;
        }
        this.map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public boolean excluir(Long cpf) {
        Cliente clienteCadastrado = this.map.get(cpf);
        if (clienteCadastrado != null){
            this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
            return true;
        }
        return false;
    }

    @Override
    public void alterar(Cliente cliente) {

        Cliente clientecadastrado = this.map.get(cliente.getCpf());
        if(clientecadastrado != null) {
            if( cliente.getNome()!= null) {clientecadastrado.setNome(cliente.getNome());}
            if( cliente.getTel()!= null){clientecadastrado.setTel(cliente.getTel());}
            if( cliente.getNumero()!= null) {clientecadastrado.setNumero(cliente.getNumero());}
            if( cliente.getEnd()!= null) {clientecadastrado.setEnd(cliente.getEnd());}
            if( cliente.getCidade()!= null) {clientecadastrado.setCidade(cliente.getCidade());}
            if( cliente.getEstado()!= null) {clientecadastrado.setEstado(cliente.getEstado());}
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }
}