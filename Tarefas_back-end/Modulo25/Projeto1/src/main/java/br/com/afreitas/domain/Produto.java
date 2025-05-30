package br.com.afreitas.domain;

import br.com.afreitas.anotacao.TipoChave;

/**
 * @author arthur.freitas
 */
public class Produto implements Persistente{

    @TipoChave("getCodigo")
    private String codigo;

    private String nome;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
