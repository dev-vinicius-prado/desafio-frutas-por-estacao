package br.com.devviniciusprado.utils;

import java.text.Normalizer;

import static java.text.Normalizer.Form.NFD;

public class NormalizadorEntrada {
    public static String normalizar(String entrada) {
        String entradaNormalizada = Normalizer.normalize(entrada, NFD);
        return entradaNormalizada.replaceAll("\\p{M}", "");
    }
}