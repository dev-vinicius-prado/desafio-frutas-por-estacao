package br.com.devviniciusprado.processadores;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static br.com.devviniciusprado.processadores.ProcessadorClassificarFrutas.classificarFrutas;
import static org.junit.jupiter.api.Assertions.*;

class ProcessadorClassificarFrutasTest {

    @Test
    void classificarFrutasPorEstacao() {
        List<String> frutas = List.of("banana", "laranja", "melancia");
        final int quantidadeEstacoesEsperadas = 3; //Verão,Melancia; Inverno,Laranja; Outono,Banana
        Map<String, Collection<String>> resultado = classificarFrutas(frutas);

        assertNotNull(resultado, "O mapa classificado não deve ser nulo.");
        assertTrue(resultado.containsKey("verão"), "O mapa deve contar o estação 'Verão'.");
        assertEquals(quantidadeEstacoesEsperadas, resultado.size());
        assertTrue(resultado.get("verão").contains("melancia"), "A estação 'Verão' deve a fruta 'Melancia'.");
    }
}