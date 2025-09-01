package jokenpo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste do jokenpo")
public class JokenpoTest {
	// 1 Papel
    // 2 Pedra
    // 3 Tesoura
    // 0 se houve empate, 1 se jogador 1 venceu, 2 se jogador 2 venceu e -1 se opção é inválida

	private Jokenpo jokenpo;

    @BeforeEach
	public void inicializa() {
		jokenpo = new Jokenpo();
	}

    public void empatePedra() {
        int result = jokenpo.jogar(2, 2);
        Assertions.assertEquals(0, result);
    }

    public void empatePapel() {
        int result = jokenpo.jogar(1, 1);
        Assertions.assertEquals(0, result);
    }

    public void empateTesoura() {
        int result = jokenpo.jogar(3, 3);
        Assertions.assertEquals(0, result);
    }

    public void testJogador1VenceComPedra() {
		int result = jokenpo.jogar(2, 3);
		Assertions.assertEquals(1, result);		
	}

    public void testJogador2VenceComPedra() {
        int result = jokenpo.jogar(3, 2);
        Assertions.assertEquals(2, result);		
	}

    public void testJogador1VenceComPapel() {
		int result = jokenpo.jogar(1, 2);
		Assertions.assertEquals(1, result);		
	}

    public void testJogador2VenceComPapel() {
        int result = jokenpo.jogar(2, 1);
        Assertions.assertEquals(2, result);		
	}

    public void testJogador1VenceComTesoura() {
		int result = jokenpo.jogar(3, 1);
		Assertions.assertEquals(1, result);		
	}

    public void testJogador2VenceComTesoura() {
        int result = jokenpo.jogar(1, 3);
        Assertions.assertEquals(2, result);		
	}

    public void jogador1EscolhaInvalida() {
        int result = jokenpo.jogar(5, 1);
        Assertions.assertEquals(-1, result);
    }

    public void jogador2EscolhaInvalida() {
        int result = jokenpo.jogar(1, 7);
        Assertions.assertEquals(-1, result);
    }
}