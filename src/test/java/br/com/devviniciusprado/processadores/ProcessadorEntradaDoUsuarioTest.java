package br.com.devviniciusprado.processadores;

import br.com.devviniciusprado.validadores.ValidarEntrada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessadorEntradaDoUsuarioTest {

    @Test
    void deveAceitarEntrada() {
        assertDoesNotThrow(() -> ValidarEntrada.validar("manga banana uva"));
    }

    @Test
    void deveLancarExcecaoQuandoEntradaVazia() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> ValidarEntrada.validar(""));
        assertEquals("Informe pelo menos 1 fruta!", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoEntradaNula() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> ValidarEntrada.validar(null));
        assertEquals("Informe pelo menos 1 fruta!", exception.getMessage());
    }
}