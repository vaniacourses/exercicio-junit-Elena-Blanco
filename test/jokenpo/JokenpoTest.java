package jokenpo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JokenpoTest {

    private Jokenpo jokenpo;

    @BeforeEach
    public void inicializa() {
        jokenpo = new Jokenpo();
    }

    @DisplayName("Testa empate quando ambos jogam Papel")
    @Test
    public void testEmpatePapel() {
        int resultado = jokenpo.jogar(1, 1);
        Assertions.assertEquals(0, resultado);
    }

    @DisplayName("Testa Jogador 1 vencendo (Papel e Pedra)")
    @Test
    public void testJogador1VencePapelContraPedra() {
        int resultado = jokenpo.jogar(1, 2);
        Assertions.assertEquals(1, resultado);
    }

    @DisplayName("Testa Jogador 2 vencendo (Papel e Tesoura)")
    @Test
    public void testJogador2VenceTesouraContraPapel() {
        int resultado = jokenpo.jogar(1, 3);
        Assertions.assertEquals(2, resultado);
    }

    @DisplayName("Testa quando jogador 1 joga opção inválida")
    @Test
    public void testJogador1Invalido() {
        int resultado = jokenpo.jogar(0, 2);
        Assertions.assertEquals(-1, resultado);
    }

}
