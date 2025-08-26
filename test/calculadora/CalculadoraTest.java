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
	
	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}

	@DisplayName("Testa a subtração de dois números")
	@Test
	public void testSubtraiDoisNumeros() {
		int subtracao = calc.subtracao(10, 4);		
		Assertions.assertEquals(6, subtracao);		
	}

	@DisplayName("Testa a multiplicação de dois números")
	@Test
	public void testMultiplicaDoisNumeros() {
		int multiplica = calc.multiplicacao(6, 5);		
		Assertions.assertEquals(30, multiplica);		
	}
	
	@DisplayName("Testa a divisão de dois números")
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@DisplayName("Testa a divisão por zero")
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

	@DisplayName("Testa o somatorio")
	@Test
	public void testSomatorio() {
		int somatorio = calc.somatoria(3);		
		Assertions.assertEquals(6, somatorio);		
	}

	@DisplayName("Testa se é positivo")
	@Test
	public void testSePositivo() {
		boolean positivo = calc.ehPositivo(5);		
		Assertions.assertEquals(true, positivo);		
	}

	@DisplayName("Testa se a=b")
	@Test
	public void testSeIgual() {
		int seIgual = calc.compara(7, 7);		
		Assertions.assertEquals(0, seIgual);		
	}

	@DisplayName("Testa se a>b")
	@Test
	public void testSeMaior() {
		int seMaior = calc.compara(7, 3);		
		Assertions.assertEquals(1, seMaior);		
	}

	@DisplayName("Testa se a<b")
	@Test
	public void testSeMenor() {
		int seMenor = calc.compara(1, 3);		
		Assertions.assertEquals(-1, seMenor);		
	}

}