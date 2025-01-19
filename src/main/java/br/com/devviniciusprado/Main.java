package br.com.devviniciusprado;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.*;

import static java.text.Normalizer.Form.NFD;
import static java.util.Objects.isNull;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        System.out.println("Digite a lista de frutas separadas por espaco:");

        final String frutas = scanner.nextLine();
        validarEntrada(frutas);
        List<String> listaFrutas = processarEntradaDoUsuario(frutas);

        Map<String, Collection<String>> frutasPorEstacao = classificarFrutas(listaFrutas);
        formatarSaida(frutasPorEstacao);
    }

    protected static void validarEntrada(String frutas) {
        if (isNull(frutas) || frutas.trim().isEmpty()) {
            throw new IllegalArgumentException("Informe pelo menos 1 fruta!");
        }
    }

    protected static List<String> processarEntradaDoUsuario(String frutas) {
        final String[] arrayFrutas = frutas.replaceAll(",", " ").split(" ");
        return Arrays.stream(arrayFrutas)
                .filter(Objects::nonNull)
                .map(String::trim)
                .map(String::toLowerCase)
                .map(Main::normalizarEntrada)
                .toList();
    }

    protected static String normalizarEntrada(String entrada) {
        String entradaNormalizada = Normalizer.normalize(entrada, NFD);
        return entradaNormalizada.replaceAll("\\p{M}", "");
    }

    protected static Map<String, Collection<String>> classificarFrutas(List<String> listaFrutas) {
        Map<String, Collection<String>> mapaFrutasPorEstacao = criarMapaFrutasPorEstacao();
        Map<String, Collection<String>> frutasClassificadasPorEstacao = new HashMap<>();
        listaFrutas.forEach(fruta ->
                mapaFrutasPorEstacao.keySet()
                        .forEach(estacao -> {
                            if (mapaFrutasPorEstacao.get(estacao).contains(fruta)) {
                                if (frutasClassificadasPorEstacao.get(estacao) == null) {
                                    List<String> frutas = new ArrayList<>();
                                    frutas.add(fruta);
                                    frutasClassificadasPorEstacao.put(estacao, frutas);
                                } else {
                                    Collection<String> frutas = frutasClassificadasPorEstacao.get(estacao);
                                    frutas.add(fruta);
                                    frutasClassificadasPorEstacao.put(estacao, frutas);
                                }
                            }
                        })
        );
        return frutasClassificadasPorEstacao;
    }

    protected static Map<String, Collection<String>> criarMapaFrutasPorEstacao() {
        final Path path = Paths.get("src/main/resources/frutas_por_estacao.csv");
        List<String> frutasPorEstacao;
        try {
            frutasPorEstacao = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(String.format("Não foi possível abrir o arquivo %s. Tente novamente.", path.getFileName()));
        }
        Map<String, Collection<String>> mapaFrutasPorEstacao = new HashMap<>();
        frutasPorEstacao.stream()
                .map(String::toLowerCase)
                .forEach(linha -> {
                    final String[] split = linha.split(",");
                    final String estacao = split[0];
                    final String fruta = split[1];

                    if (mapaFrutasPorEstacao.get(estacao) == null) {
                        List<String> frutas = new ArrayList<>();
                        frutas.add(fruta);
                        mapaFrutasPorEstacao.put(estacao, frutas);
                    } else {
                        Collection<String> frutas = mapaFrutasPorEstacao.get(estacao);
                        frutas.add(fruta);
                        mapaFrutasPorEstacao.put(estacao, frutas);
                    }
                });

        return mapaFrutasPorEstacao;
    }

    private static void formatarSaida(Map<String, Collection<String>> frutasPorEstacao) {
        System.out.println("::Frutas por estação::");
        System.out.println("{ ");
        frutasPorEstacao.keySet()
                .forEach(estacao -> {
                            System.out.print(estacao + " = ");
                            System.out.println(frutasPorEstacao.get(estacao));
                        }
                );
        System.out.print("} ");
    }
}