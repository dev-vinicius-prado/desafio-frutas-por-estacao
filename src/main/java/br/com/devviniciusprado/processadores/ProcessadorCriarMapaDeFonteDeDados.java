package br.com.devviniciusprado.processadores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ProcessadorCriarMapaDeFonteDeDados {
    public static Map<String, Collection<String>> processarCriarMapa() {
        final Path path = Paths.get("src/main/resources/frutas_por_estacao.csv");
        List<String> frutasPorEstacao;
        try {
            frutasPorEstacao = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(String.format("Não foi possível abrir o arquivo %s. Tente novamente.", path.getFileName()));
        }
        Map<String, Collection<String>> mapaFrutasPorEstacao = new HashMap<String, Collection<String>>();
        frutasPorEstacao.stream()
                .map(String::toLowerCase)
                .forEach(linha -> {
                    final String[] split = linha.split(",");
                    final String estacao = split[0];
                    final String fruta = split[1];

                    mapaFrutasPorEstacao.computeIfAbsent(estacao, k -> new ArrayList<>()).add(fruta);
                });

        return mapaFrutasPorEstacao;
    }
}