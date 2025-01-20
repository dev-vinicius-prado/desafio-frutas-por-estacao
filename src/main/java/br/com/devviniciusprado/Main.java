package br.com.devviniciusprado;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static br.com.devviniciusprado.processadores.ProcessadorClassificarFrutas.classificarFrutas;
import static br.com.devviniciusprado.processadores.ProcessadorEntradaDoUsuario.processar;
import static br.com.devviniciusprado.utils.FormatadorSaidaUtil.formatar;
import static br.com.devviniciusprado.validadores.ValidarEntrada.validar;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        System.out.println("Digite a lista de frutas separadas por espaco:");

        final String frutas = scanner.nextLine();
        validar(frutas);
        List<String> listaFrutas = processar(frutas);

        Map<String, Collection<String>> frutasPorEstacao = classificarFrutas(listaFrutas);
        formatar(frutasPorEstacao);
    }
}