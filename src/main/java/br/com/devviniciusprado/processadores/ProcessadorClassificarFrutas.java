package br.com.devviniciusprado.processadores;

import java.util.*;

import static br.com.devviniciusprado.processadores.ProcessadorCriarMapaDeFonteDeDados.processarCriarMapa;

public class ProcessadorClassificarFrutas {
    public static Map<String, Collection<String>> classificarFrutas(List<String> listaFrutas) {
        Map<String, Collection<String>> mapaFrutasPorEstacao = processarCriarMapa();
        Map<String, Collection<String>> frutasClassificadasPorEstacao = new HashMap<String, Collection<String>>();
        listaFrutas.forEach(fruta ->
                mapaFrutasPorEstacao.keySet()
                        .forEach(estacao -> {
                            if (mapaFrutasPorEstacao.get(estacao).contains(fruta)) {
                                if (frutasClassificadasPorEstacao.get(estacao) == null) {
                                    List<String> frutas = new ArrayList<String>();
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
}