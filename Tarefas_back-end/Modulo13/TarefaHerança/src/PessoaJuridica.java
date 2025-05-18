public class PessoaJuridica extends Pessoa {
    String cnpj;
    String dataCriacao;

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }


    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Pessoa Jurídica{" +
                "cnpj='" + cnpj + '\'' +
                ", data de criação='" + dataCriacao + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
