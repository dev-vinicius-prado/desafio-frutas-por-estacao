package br.com.devviniciusprado;

import br.com.devviniciusprado.processadores.ProcessadorCriarMapaDeFonteDeDados;
import br.com.devviniciusprado.processadores.ProcessadorEntradaDoUsuario;
import br.com.devviniciusprado.utils.NormalizadorEntrada;
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
        List<String> resultado = ProcessadorEntradaDoUsuario.processar(entrada);
        assertEquals(esperado, resultado, "A entrada do usuário não foi processada corretamente.");
    }

    @Test
    void normalizarEntrada() {
        String entrada = "maça";
        String esperada = "maca";
        String resultado = NormalizadorEntrada.normalizar(entrada);
        assertEquals(esperada, resultado, "A normalização da entrada falhou.");
    }



}