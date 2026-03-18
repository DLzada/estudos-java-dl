package herancaPolimorfismo.ex02;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private boolean administrador;

    public Usuario(String nome, boolean administrador, String senha, String email) {
        this.nome = nome;
        this.administrador = administrador;
        this.senha = senha;
        this.email = email;
    }

    // Methods commom
    public void realizarLogin(){
        System.out.println(nome + " logado com sucesso");
    }

    public void realizarLogoff(){
        System.out.println(nome + " saiu do sistema");
    }

    public void alterarDados(String novoNome, String novoEmail){
        this.nome = novoNome;
        this.email = novoEmail;
    }

    public void alterarSenha(String novaSenha){
        this.senha = novaSenha;
    }

    // Getters
    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public boolean isAdministrador(){
        return administrador;
    }

}
