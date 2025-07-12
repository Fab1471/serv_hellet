package br.com.unicesumar_mapa.figueiredof.util;

import java.util.Random;

public class gen_ISBN {
    public static String generate() {
        Random generator = new Random();
        StringBuilder ISBN = new StringBuilder("127");

        for (int i = 0; i < 9; i++) {
            ISBN.append(generator.nextInt(10));
        }
        return ISBN.toString();
    }
}
