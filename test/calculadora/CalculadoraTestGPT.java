import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private Calculadora calc;

    @BeforeEach
    void setUp() {
        // Roda antes de cada método de teste
        calc = new Calculadora();
    }

    @Test
    @DisplayName("Testa a soma de dois números positivos")
    void testSomaPositivos() {
        assertEquals(5, calc.soma(2, 3), "A soma de 2 e 3 deve ser 5");
    }

    @Test
    @DisplayName("Testa a soma com número negativo")
    void testSomaComNegativo() {
        assertEquals(1, calc.soma(5, -4), "A soma de 5 e -4 deve ser 1");
    }

    @Test
    @DisplayName("Testa a soma com zero")
    void testSomaComZero() {
        assertEquals(7, calc.soma(7, 0), "A soma de 7 e 0 deve ser 7");
    }

    @Test
    @DisplayName("Testa a subtração de dois números")
    void testSubtracao() {
        assertEquals(5, calc.subtracao(10, 5), "A subtração de 10 por 5 deve ser 5");
    }
    
    @Test
    @DisplayName("Testa a subtração resultando em negativo")
    void testSubtracaoResultadoNegativo() {
        assertEquals(-2, calc.subtracao(3, 5), "A subtração de 3 por 5 deve ser -2");
    }

    @Test
    @DisplayName("Testa a multiplicação de dois números")
    void testMultiplicacao() {
        assertEquals(20, calc.multiplicacao(4, 5), "A multiplicação de 4 por 5 deve ser 20");
    }

    @Test
    @DisplayName("Testa a multiplicação por zero")
    void testMultiplicacaoPorZero() {
        assertEquals(0, calc.multiplicacao(10, 0), "Qualquer número multiplicado por zero deve ser 0");
    }

    @Test
    @DisplayName("Testa a divisão de dois números inteiros")
    void testDivisao() {
        assertEquals(4, calc.divisao(20, 5), "A divisão de 20 por 5 deve ser 4");
    }

    @Test
    @DisplayName("Testa a divisão por zero e espera uma exceção")
    void testDivisaoPorZero() {
        // JUnit espera que uma ArithmeticException seja lançada ao dividir por zero
        assertThrows(ArithmeticException.class, () -> {
            calc.divisao(10, 0);
        }, "A divisão por zero deve lançar ArithmeticException");
    }

    @Test
    @DisplayName("Testa a somatória de um número")
    void testSomatoria() {
        // 5 + 4 + 3 + 2 + 1 + 0 = 15
        assertEquals(15, calc.somatoria(5), "A somatória de 5 deve ser 15");
    }

    @Test
    @DisplayName("Testa a somatória de zero")
    void testSomatoriaDeZero() {
        assertEquals(0, calc.somatoria(0), "A somatória de 0 deve ser 0");
    }

    @Test
    @DisplayName("Verifica se um número é positivo")
    void testEhPositivo() {
        assertTrue(calc.ehPositivo(10), "O número 10 deve ser considerado positivo");
    }
    
    @Test
    @DisplayName("Verifica se zero é considerado positivo")
    void testZeroEhPositivo() {
        assertTrue(calc.ehPositivo(0), "O número 0 deve ser considerado positivo");
    }

    @Test
    @DisplayName("Verifica se um número não é positivo")
    void testNaoEhPositivo() {
        assertFalse(calc.ehPositivo(-5), "O número -5 não deve ser considerado positivo");
    }

    @Test
    @DisplayName("Compara dois números iguais")
    void testComparaIguais() {
        assertEquals(0, calc.compara(5, 5), "A comparação de 5 e 5 deve retornar 0");
    }

    @Test
    @DisplayName("Compara quando o primeiro número é maior")
    void testComparaMaior() {
        assertEquals(1, calc.compara(10, 2), "A comparação de 10 e 2 deve retornar 1");
    }

    @Test
    @DisplayName("Compara quando o primeiro número é menor")
    void testComparaMenor() {
        assertEquals(-1, calc.compara(3, 8), "A comparação de 3 e 8 deve retornar -1");
    }
}