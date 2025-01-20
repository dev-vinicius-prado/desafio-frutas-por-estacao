package br.com.devviniciusprado.validadores;

import java.util.Objects;

public class ValidarEntrada {
    public static void validar(String frutas) {
        if (Objects.isNull(frutas) || frutas.trim().isEmpty()) {
            throw new IllegalArgumentException("Informe pelo menos 1 fruta!");
        }
    }
}