package br.com.devviniciusprado;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void processarEntradaDoUsuario() {
        String entrada = "Maçã Banana laranja";
        List<String> esperado = List.of("maca", "banana", "laranja");
        List<String> resultado = Main.processarEntradaDoUsuario(entrada);
        assertEquals(esperado, resultado, "A entrada do usuário não foi processada corretamente.");
    }

    @Test
    void normalizarEntrada() {
        String entrada = "maça";
        String esperada = "maca";
        String resultado = Main.normalizarEntrada(entrada);
        assertEquals(esperada, resultado, "A normalização da entrada falhou.");
    }

    @Test
    void criarMapaFrutasPorEstacao() {
        Map<String, Collection<String>> resultado = Main.criarMapaFrutasPorEstacao();
        assertNotNull(resultado, "O mapa não deve ser nulo.");
        assertFalse(resultado.isEmpty(), "O mapa não deve ser vazio.");
        assertTrue(resultado.containsKey("verão"), "O mapa deve conter a estação 'Verão'.");
        assertTrue(resultado.get("verão").contains("abacaxi"), "A estação 'Verão' deve a fruta 'Abacaxi'.");
    }

    @Test
    void classificarFrutasPorEstacao() {
        List<String> frutas = List.of("banana", "laranja", "melancia");
        final int quantidadeEstacoesEsperadas = 3; //Verão,Melancia; Inverno,Laranja; Outono,Banana
        Map<String, Collection<String>> resultado = Main.classificarFrutas(frutas);

        assertNotNull(resultado, "O mapa classificado não deve ser nulo.");
        assertTrue(resultado.containsKey("verão"), "O mapa deve contar o estação 'Verão'.");
        assertEquals(quantidadeEstacoesEsperadas, resultado.size());
        assertTrue(resultado.get("verão").contains("melancia"), "A estação 'Verão' deve a fruta 'Melancia'.");
    }
}