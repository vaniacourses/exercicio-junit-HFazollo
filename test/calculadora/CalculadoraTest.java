package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}

		@Test
    public void testSomaPositivoComNegativo() {
        int soma = calc.soma(10, -5);
        assertEquals(5, soma);
    }

	@Test
    public void testSomaDoisNumerosNegativos() {
        int soma = calc.soma(-10, -5);
        assertEquals(-15, soma);
    }

	@Test
    public void testSubtracaoDoisNumeros() {
        int subtracao = calc.subtracao(10, 3);
        assertEquals(7, subtracao);
    }

    @Test
    public void testSubtracaoNegativoDePositivo() {
        int subtracao = calc.subtracao(5, -2);
        assertEquals(7, subtracao);
    }

    @Test
    public void testSubtracaoMenorDeMaior() {
        int subtracao = calc.subtracao(5, 10);
        assertEquals(-5, subtracao);
    }
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

	@Test
    public void testMultiplicacaoDoisNumeros() {
        int multiplicacao = calc.multiplicacao(5, 4);
        assertEquals(20, multiplicacao);
    }

    @Test
    public void testMultiplicacaoPorZero() {
        int multiplicacao = calc.multiplicacao(10, 0);
        assertEquals(0, multiplicacao);
    }

    @Test
    public void testMultiplicacaoPorNegativo() {
        int multiplicacao = calc.multiplicacao(5, -2);
        assertEquals(-10, multiplicacao);
    }

	@Test
    public void testSomatoriaPositivo() {
        int somatoria = calc.somatoria(4);
        assertEquals(10, somatoria);
    }

    @Test
    public void testSomatoriaNegativo() {
        int somatoria = calc.somatoria(-5);
        assertEquals(0, somatoria);
    }

	@Test
    public void testEhPositivoComNumeroPositivo() {
        assertTrue(calc.ehPositivo(10));
    }

    @Test
    public void testEhPositivoComNumeroZero() {
        assertTrue(calc.ehPositivo(0));
    }

	@Test
    public void testComparaNumerosIguais() {
        assertEquals(0, calc.compara(5, 5));
    }

    @Test
    public void testComparaPrimeiroMaior() {
        assertEquals(1, calc.compara(10, 5));
    }

}
