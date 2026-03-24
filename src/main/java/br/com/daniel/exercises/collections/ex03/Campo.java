package collections.ex03;

public class Campo {
    private String nome;
    private String valor;
    private String tipo;

    public Campo(String nome, String valor, String tipo) {
        this.nome = nome;
        this.valor = valor;
        this.tipo = tipo.toLowerCase();
    }

    public String getNome() { return nome; }
    public String getValor() { return valor; }
    public String getTipo() { return tipo; }
}
