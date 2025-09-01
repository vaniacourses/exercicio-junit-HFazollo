import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private Jokenpo jokenpo;

    @BeforeEach
    void setUp() {
        jokenpo = new Main();
    }

    @Nested
    @DisplayName("Testes de Empate")
    class Empates {
        @Test
        @DisplayName("Papel vs Papel deve empatar")
        void testEmpatePapel() {
            assertEquals(0, jokenpo.jogar(1, 1), "1 vs 1 deveria ser empate (0)");
        }

        @Test
        @DisplayName("Pedra vs Pedra deve empatar")
        void testEmpatePedra() {
            assertEquals(0, jokenpo.jogar(2, 2), "2 vs 2 deveria ser empate (0)");
        }

        @Test
        @DisplayName("Tesoura vs Tesoura deve empatar")
        void testEmpateTesoura() {
            assertEquals(0, jokenpo.jogar(3, 3), "3 vs 3 deveria ser empate (0)");
        }
    }

    @Nested
    @DisplayName("Testes de Vitória do Jogador 1")
    class VitoriasJogador1 {
        @Test
        @DisplayName("Papel (1) ganha de Pedra (2)")
        void testPapelGanhaDePedra() {
            assertEquals(1, jokenpo.jogar(1, 2), "Jogador 1 (Papel) deveria vencer (1)");
        }

        @Test
        @DisplayName("Pedra (2) ganha de Tesoura (3)")
        void testPedraGanhaDeTesoura() {
            assertEquals(1, jokenpo.jogar(2, 3), "Jogador 1 (Pedra) deveria vencer (1)");
        }

        @Test
        @DisplayName("Tesoura (3) ganha de Papel (1)")
        void testTesouraGanhaDePapel() {
            assertEquals(1, jokenpo.jogar(3, 1), "Jogador 1 (Tesoura) deveria vencer (1)");
        }
    }

    @Nested
    @DisplayName("Testes de Vitória do Jogador 2")
    class VitoriasJogador2 {
        @Test
        @DisplayName("Pedra (2) perde para Papel (1)")
        void testPedraPerdeParaPapel() {
            assertEquals(2, jokenpo.jogar(2, 1), "Jogador 2 (Papel) deveria vencer (2)");
        }

        @Test
        @DisplayName("Tesoura (3) perde para Pedra (2)")
        void testTesouraPerdeParaPedra() {
            assertEquals(2, jokenpo.jogar(3, 2), "Jogador 2 (Pedra) deveria vencer (2)");
        }

        @Test
        @DisplayName("Papel (1) perde para Tesoura (3)")
        void testPapelPerdeParaTesoura() {
            assertEquals(2, jokenpo.jogar(1, 3), "Jogador 2 (Tesoura) deveria vencer (2)");
        }
    }
    
    @Nested
    @DisplayName("Testes de Entradas Inválidas")
    class EntradasInvalidas {
        @Test
        @DisplayName("Deve retornar -1 se jogador1 for inválido (zero)")
        void testJogador1InvalidoZero() {
            assertEquals(-1, jokenpo.jogar(0, 2), "Jogada inválida deveria retornar -1");
        }
        
        @Test
        @DisplayName("Deve retornar -1 se jogador2 for inválido (maior que 3)")
        void testJogador2InvalidoMaiorQue3() {
            assertEquals(-1, jokenpo.jogar(1, 4), "Jogada inválida deveria retornar -1");
        }

        @Test
        @DisplayName("Deve retornar -1 se jogador1 for inválido (negativo)")
        void testJogador1InvalidoNegativo() {
            assertEquals(-1, jokenpo.jogar(-1, 3), "Jogada inválida deveria retornar -1");
        }
        
        @Test
        @DisplayName("Deve retornar -1 se ambos os jogadores forem inválidos")
        void testAmbosJogadoresInvalidos() {
            assertEquals(-1, jokenpo.jogar(5, -2), "Jogada inválida deveria retornar -1");
        }
    }
}