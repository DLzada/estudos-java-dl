package collections.ex06;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {

    /*
    Catálogo de Livros
        Crie uma classe chamada "CatalogoLivros" que possui uma lista de objetos do tipo "Livro" como atributo. Cada livro possui atributos como título, autor e ano de publicação. Implemente os seguintes métodos:

        adicionarLivro(String titulo, String autor, int anoPublicacao): Adiciona um livro ao catálogo.
        pesquisarPorAutor(String autor): Pesquisa livros por autor e retorna uma lista com os livros encontrados.
        pesquisarPorIntervaloAnos(int anoInicial, int anoFinal): Pesquisa livros publicados em um determinado intervalo de anos e retorna uma lista com os livros encontrados.
        pesquisarPorTitulo(String titulo): Pesquisa livros por título e retorna o primeiro livro encontrado.
    */


    private List<Livro> livroList;

    public CatalogoLivros() {
        this.livroList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao){
        livroList.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor){
        List<Livro> livrosPorAutor = new ArrayList<>();
        if(!livroList.isEmpty()){
            for (Livro l : livroList){
                if(l.getAutor().equalsIgnoreCase(autor)){
                    livrosPorAutor.add(l);
                }
            }
        }

        return livrosPorAutor;
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal){
        List<Livro> livrosPorIntervaloDeAno = new ArrayList<>();
        if(!livroList.isEmpty()){
            for (Livro l : livroList){
                if(l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal){
                    livrosPorIntervaloDeAno.add(l);
                }
            }
        }
        return livrosPorIntervaloDeAno;
    }

    public Livro pesquisarPorTitulo(String titulo){
        Livro livroPorTitulo = null;
        if(!livroList.isEmpty()){
            for (Livro l : livroList){
                if(l.getTitulo().equalsIgnoreCase(titulo)){
                    livroPorTitulo = l;
                    break;
                }
            }
        }
        return livroPorTitulo;
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();

        catalogoLivros.adicionarLivro("Livro 1", "Fulano", 2000);
        catalogoLivros.adicionarLivro("Livro 2", "Fulano", 2010);
        catalogoLivros.adicionarLivro("Livro 3", "Beltrano", 2020);

        System.out.println("Procurando por autor... " + catalogoLivros.pesquisarPorAutor("fulano"));
    }
}
