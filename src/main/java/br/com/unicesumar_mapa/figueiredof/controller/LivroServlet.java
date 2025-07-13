package br.com.unicesumar_mapa.figueiredof.controller;

import br.com.unicesumar_mapa.figueiredof.model.Livro;
import br.com.unicesumar_mapa.figueiredof.util.gen_html_book;
import br.com.unicesumar_mapa.figueiredof.exception.LivroException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet responsável por gerenciar as requisições relacionadas ao cadastro, listagem e exclusão de livros.
 */
@WebServlet(name = "livroServlet", value = "/livros")
public class LivroServlet extends HttpServlet {

    private List<Livro> livros;

    /**
     * Inicializa a lista de livros ao iniciar o servlet.
     */
    @Override
    public void init() {
        livros = new ArrayList<>();
    }

    /**
     * Trata requisições GET. Responsável por exibir a lista atual de livros.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Gera o HTML com os livros cadastrados
        request.setAttribute("htmlLivros", gen_html_book.generate(request, livros));
        // Encaminha para a página principal
        request.getRequestDispatcher("/view/index.jsp").forward(request, response);
    }

    /**
     * Trata requisições POST. Responsável pelo cadastro e exclusão de livros.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        // Lógica para exclusão de livro pelo ID
        if ("delete".equals(action)) {
            String idStr = request.getParameter("id");
            if (idStr != null && !idStr.isEmpty()) {
                int id = Integer.parseInt(idStr);
                livros.removeIf(livro -> livro.getId() == id);
            }
            // Redireciona após exclusão
            response.sendRedirect(request.getContextPath() + "/livros");
            return;
        }

        // Lógica para cadastro de livro
        try {
            Livro livro = new Livro();
            livro.setTitulo(request.getParameter("titulo").toUpperCase());
            livro.setAutor(request.getParameter("autor").toUpperCase());
            livro.setAno(Integer.parseInt(request.getParameter("ano")));
            livro.setIsbn(request.getParameter("isbn"));
            livro.validar(); // Valida os dados do livro
            livros.add(livro);
            // Redireciona após cadastro bem-sucedido
            response.sendRedirect(request.getContextPath() + "/livros");
            return;

        } catch (NumberFormatException e) {
            // Tratamento para ano não numérico
            request.setAttribute("mensagemErro", "Ano deve ser um número.");
        } catch (LivroException e) {
            // Tratamento de erros personalizados (ex: ISBN inválido)
            request.setAttribute("mensagemErro", e.getMessage());
        }

        // Reapresenta a página com os erros e a lista de livros
        request.setAttribute("htmlLivros", gen_html_book.generate(request, livros));
        request.getRequestDispatcher("/view/index.jsp").forward(request, response);
    }
}
