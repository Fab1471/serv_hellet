package br.com.unicesumar_mapa.figueiredof.exception;

/**
 * Classe de exceção personalizada para erros relacionados à validação de livros.
 * É utilizada para lançar mensagens específicas quando dados inválidos são inseridos.
 */
public class LivroException extends Exception {

    /**
     * Construtor que recebe a mensagem de erro a ser exibida.
     * @param msg Mensagem descritiva da exceção.
     */
    public LivroException(String msg) {
        super(msg);
    }
}
