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

@WebServlet(name = "livroServlet", value = "/livros")
public class LivroServlet extends HttpServlet {

    private List<Livro> livros;

    @Override
    public void init() {
        livros = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("htmlLivros", gen_html_book.generate(request, livros));
        request.getRequestDispatcher("/view/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            String idStr = request.getParameter("id");
            if (idStr != null && !idStr.isEmpty()) {
                int id = Integer.parseInt(idStr);
                livros.removeIf(livro -> livro.getId() == id);
            }
            response.sendRedirect(request.getContextPath() + "/livros");
            return;
        }

        try {
            Livro livro = new Livro();
            livro.setTitulo(request.getParameter("titulo").toUpperCase());
            livro.setAutor(request.getParameter("autor").toUpperCase());
            livro.setAno(Integer.parseInt(request.getParameter("ano")));
            livro.setIsbn(request.getParameter("isbn"));
            livro.validar();
            livros.add(livro);
            response.sendRedirect(request.getContextPath() + "/livros");
            return;
        } catch (NumberFormatException e) {
            request.setAttribute("mensagemErro", "Ano deve ser um número.");
        } catch (LivroException e) {
            request.setAttribute("mensagemErro", e.getMessage());
        }

        request.setAttribute("htmlLivros", gen_html_book.generate(request, livros));
        request.getRequestDispatcher("/view/index.jsp").forward(request, response);
    }
}
