package br.com.unicesumar_mapa.figueiredof.util;

import java.util.Random;

/**
 * Classe utilitária responsável por gerar números de ISBN fictícios para fins de teste ou cadastro automático.
 */
public class gen_ISBN {

    /**
     * Gera um número de ISBN aleatório iniciando com "127" e completando com 9 dígitos aleatórios.
     *
     * @return Uma string representando o ISBN gerado.
     */
    public static String generate() {
        Random generator = new Random();
        StringBuilder ISBN = new StringBuilder("127"); // Prefixo fixo para simulação

        // Gera 9 dígitos numéricos aleatórios para completar o ISBN
        for (int i = 0; i < 9; i++) {
            ISBN.append(generator.nextInt(10)); // Adiciona dígito entre 0 e 9
        }

        return ISBN.toString();
    }
}
