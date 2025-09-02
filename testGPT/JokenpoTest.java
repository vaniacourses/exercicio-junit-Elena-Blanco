package jokenpo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JokenpoTest {

    private final Jokenpo jokenpo = new Jokenpo();

    // ---- Testes de Empate ----
    @Test
    public void testEmpatePapel() {
        assertEquals(0, jokenpo.jogar(1, 1));
    }

    @Test
    public void testEmpatePedra() {
        assertEquals(0, jokenpo.jogar(2, 2));
    }

    @Test
    public void testEmpateTesoura() {
        assertEquals(0, jokenpo.jogar(3, 3));
    }

    // ---- Testes de vitória do Jogador 1 ----
    @Test
    public void testJogador1VencePapelContraPedra() {
        assertEquals(1, jokenpo.jogar(1, 2));
    }

    @Test
    public void testJogador1VencePedraContraTesoura() {
        assertEquals(1, jokenpo.jogar(2, 3));
    }

    @Test
    public void testJogador1VenceTesouraContraPapel() {
        assertEquals(1, jokenpo.jogar(3, 1));
    }

    // ---- Testes de vitória do Jogador 2 ----
    @Test
    public void testJogador2VencePapelContraPedra() {
        assertEquals(2, jokenpo.jogar(2, 1));
    }

    @Test
    public void testJogador2VencePedraContraTesoura() {
        assertEquals(2, jokenpo.jogar(3, 2));
    }

    @Test
    public void testJogador2VenceTesouraContraPapel() {
        assertEquals(2, jokenpo.jogar(1, 3));
    }

    // ---- Testes de entradas inválidas ----
    @Test
    public void testJogador1EntradaInvalida() {
        assertEquals(-1, jokenpo.jogar(0, 2));
        assertEquals(-1, jokenpo.jogar(4, 2));
    }

    @Test
    public void testJogador2EntradaInvalida() {
        assertEquals(-1, jokenpo.jogar(1, 0));
        assertEquals(-1, jokenpo.jogar(2, 5));
    }

    @Test
    public void testAmbosJogadoresEntradaInvalida() {
        assertEquals(-1, jokenpo.jogar(0, 0));
        assertEquals(-1, jokenpo.jogar(-1, 7));
    }
}
