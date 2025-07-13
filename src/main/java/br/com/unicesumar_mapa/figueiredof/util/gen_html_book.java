package br.com.unicesumar_mapa.figueiredof.util;

import br.com.unicesumar_mapa.figueiredof.model.Livro;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * Classe utilitária responsável por gerar dinamicamente o HTML da lista de livros cadastrados.
 */
public class gen_html_book {

    /**
     * Gera um bloco HTML com as informações dos livros cadastrados.
     *
     * @param request Objeto HttpServletRequest usado para obter o contexto da aplicação.
     * @param livros Lista de livros a serem exibidos.
     * @return HTML gerado com os dados de cada livro e um formulário de exclusão.
     */
    public static String generate(HttpServletRequest request, List<Livro> livros) {
        StringBuilder htmlLivros = new StringBuilder();
        htmlLivros.append("<h2>Livros cadastrados:</h2>");

        for (Livro livro : livros) {
            htmlLivros.append("<div class=\"lista\">")
                    .append("<p><strong>Título:</strong> ").append(livro.getTitulo()).append("</p>")
                    .append("<p><strong>Autor:</strong> ").append(livro.getAutor()).append("</p>")
                    .append("<p><strong>Ano:</strong> ").append(livro.getAno()).append("</p>")
                    .append("<p><strong>ISBN:</strong> ").append(livro.getIsbn()).append("</p>")
                    .append("<p><strong>ID:</strong> ").append(livro.getId()).append("</p>")

                    // Formulário de exclusão do livro
                    .append("<form method='post' action='")
                    .append(request.getContextPath())
                    .append("/livros'>")
                    .append("<input type='hidden' name='action' value='delete' />")
                    .append("<input type='hidden' name='id' value='").append(livro.getId()).append("' />")
                    .append("<button type='submit'>EXCLUIR</button>")
                    .append("</form>")

                    .append("</div><hr>");
        }

        return htmlLivros.toString();
    }
}
