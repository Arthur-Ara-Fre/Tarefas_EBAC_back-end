/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaproject1.dao;

import javaproject1.domain.Cliente;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author arthur.freitas
 */
public class ClienteMapDAO implements IClienteDAO {
    
    private Map <Long, Cliente> map;
    
    public ClienteMapDAO() {
        map = new TreeMap<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
    if (map.containsKey(cliente.getCpf())) {
        return false;
    }
    
    map.put(cliente.getCpf(), cliente);
    return true;
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteCadastrado = map.get(cpf);
        map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteCadastrado = map.get(cliente.getCpf());
        clienteCadastrado.setNome(cliente.getNome());
        clienteCadastrado.setTel(cliente.getTel());
        clienteCadastrado.setNumero(cliente.getNumero());
        clienteCadastrado.setEnd(cliente.getEnd());
        clienteCadastrado.setCidade(cliente.getCidade());
        clienteCadastrado.setEstado(cliente.getEstado());
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }
    
}
