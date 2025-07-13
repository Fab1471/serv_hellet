package br.com.unicesumar_mapa.figueiredof.model;

import br.com.unicesumar_mapa.figueiredof.exception.LivroException;

/**
 * Classe que representa um Livro no sistema da biblioteca.
 * Contém os dados principais e um método de validação de entrada.
 */
public class Livro {

    // Contador estático para gerar IDs únicos para os livros
    private static int contador = 1;

    // Atributos de instância
    private int id;
    private String titulo;
    private String autor;
    private int ano;
    private String isbn;

    /**
     * Construtor padrão. Gera automaticamente um ID único.
     */
    public Livro() {
        this.id = contador++;
    }

    /**
     * Construtor com todos os atributos definidos.
     * @param titulo Título do livro
     * @param autor Autor do livro
     * @param ano Ano de publicação
     * @param isbn Código ISBN
     */
    public Livro(String titulo, String autor, int ano, String isbn) {
        this.id = contador++;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.isbn = isbn;
    }

    // Métodos getters e setters

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Método que valida os dados do livro antes de adicioná-lo à lista.
     * Lança exceções personalizadas em caso de erro.
     * @throws LivroException caso algum campo esteja inválido
     */
    public void validar() throws LivroException {
        if (titulo == null || titulo.trim().isEmpty()) {
            contador--; // Corrige o ID se a entrada for inválida
            throw new LivroException("O título é obrigatório.");
        }
        if (autor == null || autor.trim().isEmpty()) {
            contador--;
            throw new LivroException("O autor é obrigatório.");
        }
        if (isbn == null || isbn.trim().length() < 10) {
            contador--;
            throw new LivroException("ISBN inválido.");
        }
        if (ano < 1000 || ano > 2025) {
            contador--;
            throw new LivroException("Ano inválido.");
        }
    }
}
