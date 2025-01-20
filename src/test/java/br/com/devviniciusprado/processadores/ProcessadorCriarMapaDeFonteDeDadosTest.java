package br.com.devviniciusprado.processadores;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

public class ProcessadorCriarMapaDeFonteDeDadosTest {

    @Test
    void deveRetornarMapaCorretoQuandoArquivoValido() throws IOException {
        // Simular conteúdo do arquivo
        List<String> linhasArquivo = List.of(
                "verão,manga",
                "verão,abacaxi",
                "outono,uva"
        );

        try (MockedStatic<Files> filesMock = mockStatic(Files.class)) {
            filesMock.when(() -> Files.readAllLines(Paths.get("src/main/resources/frutas_por_estacao.csv")))
                    .thenReturn(linhasArquivo);

            Map<String, Collection<String>> resultado = ProcessadorCriarMapaDeFonteDeDados.processarCriarMapa();

            assertNotNull(resultado.get("verão"), "Chave 'verão' deve existir no mapa.");
            assertEquals(2, resultado.get("verão").size());
            assertTrue(resultado.get("verão").contains("manga"));
            assertTrue(resultado.get("verão").contains("abacaxi"));

            assertNotNull(resultado.get("outono"), "Chave 'outono' deve existir no mapa.");
            assertTrue(resultado.get("outono").contains("uva"));
        }
    }

}