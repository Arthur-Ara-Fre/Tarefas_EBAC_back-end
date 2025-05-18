package br.com.afreitas.domain;

import java.util.Objects;
/**
*@author arthur.freitas
*/
public class Cliente {
    private  String nome;
    private Long cpf;
    private Long tel;
    private String end;
    private Integer numero;
    private String cidade;

    public Cliente(String nome,String cpf,String tel, String end, String numero, String cidade, String estado) {
        this.nome = nome;
        this.cpf = Long.valueOf(cpf.trim());

        if (tel==null || !tel.matches("^\\d+$")){
            this.tel=null;
        }
        else {
            this.tel = Long.valueOf(tel.trim());
        }

        this.end = end;

        if (numero==null || !numero.matches("^\\d+$")) {
            this.numero = null;
        }
        else  {
            this.numero = Integer.valueOf(numero.trim());
        }
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    private String estado;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public String toString() {
        return  "\nNome= " + nome +
                "\nCpf= " + cpf +
                "\nTel= " + tel+
                "\nEndereço= " + end +
                "\nNumero= " + numero +
                "\nCidade= " + cidade +
                "\nEstado= " + estado ;
    }
}