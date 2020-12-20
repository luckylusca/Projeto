package dados;

public class Pessoa {
    private String nome;
    private String cpf;
    private String telefone;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
	
    public Pessoa(String nome, String cpf, String telefone) {
        this.nome = nome;
	this.cpf = cpf;
        this.telefone = telefone;
    }
    
    /*public Pessoa(String nome, String cpf) {
        this.nome = nome;
	this.cpf = cpf;
    }
*/
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
