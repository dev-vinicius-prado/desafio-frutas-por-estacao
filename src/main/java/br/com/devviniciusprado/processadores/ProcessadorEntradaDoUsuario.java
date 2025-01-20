package br.com.devviniciusprado.processadores;

import br.com.devviniciusprado.utils.NormalizadorEntrada;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ProcessadorEntradaDoUsuario {
    public static List<String> processar(String frutas) {
        final String[] arrayFrutas = frutas.replaceAll(",", " ").split(" ");
        return Arrays.stream(arrayFrutas)
                .filter(Objects::nonNull)
                .map(String::trim)
                .map(String::toLowerCase)
                .map(s -> NormalizadorEntrada.normalizar(s))
                .toList();
    }

}