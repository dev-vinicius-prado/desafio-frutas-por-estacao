package br.com.devviniciusprado.utils;

import java.util.Collection;
import java.util.Map;

public class FormatadorSaidaUtil {
    public static void formatar(Map<String, Collection<String>> frutasPorEstacao) {
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