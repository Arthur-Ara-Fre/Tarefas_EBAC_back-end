public class PessoaFisica extends Pessoa {
    String cpf;
    String dataNascimento;

    public String getDataNascimento() {

        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {

        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {

        return cpf;
    }

    public void setCpf(String cpf) {

        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "\nPessoa física{" +
                "cpf='" + cpf + '\'' +
                ", data de nascimento='" + dataNascimento + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
