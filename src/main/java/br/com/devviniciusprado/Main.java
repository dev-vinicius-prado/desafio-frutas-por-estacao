package br.com.devviniciusprado;

import java.util.*;

import static java.util.Objects.isNull;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Digite a lista de frutas separadas por espaco:");

        final String frutas = scanner.nextLine();
        if (isNull(frutas) || frutas.trim().isEmpty()) {
            throw new IllegalArgumentException("Informe pelo menos 1 fruta");
        }

        List<String> listaFrutas = processarEntradaDoUsuario(frutas);

        Map<String, Collection<String>> frutasPorEstacao = new ClassificadorFrutasPorEstacao().classificar(listaFrutas);
        System.out.println("::Frutas por estação::");
        System.out.println(frutasPorEstacao);
    }

    private static List<String> processarEntradaDoUsuario(String frutas) {
        String[] arrayFrutas = frutas.replaceAll(",", " ").split(" ");
        return Arrays.stream(arrayFrutas)
                .map(String::trim)
                .toList();
    }
}