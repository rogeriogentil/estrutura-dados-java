package rogeriogentil.estruturadados.linear;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;

public class VetorTest {

	private Vetor vetor;
	
	@Before
	public void antesDeCadaTeste() throws Exception {
		vetor = new Vetor(3);
		
		vetor.adicionar("1º elemento");
		vetor.adicionar("2º elemento");
		vetor.adicionar("3º elemento");
	}
	
	@Test
	public void deveAdicionarElemento() throws Exception {
		vetor = new Vetor(5);
		
		vetor.adicionar("1");
		vetor.adicionar("2");
	}
	
	@Ignore // Adicionado depois de adicionar o método Vetor#aumentarCapacidade() 
	@Test(expected = Exception.class)
	public void deveLancarExcecaoAoSuperarCapacidade() throws Exception {
		vetor = new Vetor(2);
		
		vetor.adicionar("1º elemento");
		vetor.adicionar("2º elemento");

		// Tenta adicionar elemento quando capacidade do vetor foi atingida
		vetor.adicionar("3º elemento");
	}
	
	@Test
	public void deveImprimirElementos() {
		System.out.println(vetor.tamanho());
		
		System.out.println(vetor);
	}
	
	@Test
	public void deveBuscarUmElemento() {
		try {
			Object s = vetor.buscar(0);
			
			assertEquals("1º elemento", s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExcecaoAoTentarAcessarPosicaoNegativa() {
		vetor.buscar(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExcecaoAoTentarAcessarPosicaoAcimaDaCapacidade() {
		vetor.buscar(10000);
	}
	
	@Test
	public void deveIndicarQueExisteElemento() {
		boolean existeElemento = vetor.existeElemento("2º elemento");
		assertTrue(existeElemento);
	}
	
	@Test
	public void deveIndicarQueNaoExisteElemento() {
		boolean existeElemento = vetor.existeElemento("blablabla");
		assertFalse(existeElemento);
	}
	
	@Test
	public void deveAdicionarUmElementoEmUmaPosicao() {
		int posicao = 0;
		Vetor vetor = new Vetor(10);
		
		vetor.adicionarBoolean("B");
		vetor.adicionarBoolean("C");
		vetor.adicionarBoolean("D");
		vetor.adicionarBoolean("E");
		vetor.adicionarBoolean("F");
		
		vetor.adicionar("A", posicao);		
		
		assertEquals("A", vetor.buscar(posicao));
		assertEquals("[A, B, C, D, E, F]", vetor.toString());
	}
	
	@Test
	public void deveAdicionarUmElementoAumentandoSuaCapacidade() throws Exception {
		int capacidade = 5;
		Vetor vetor = new Vetor(capacidade);
		
		vetor.adicionar("A");
		vetor.adicionar("B");
		vetor.adicionar("C");
		vetor.adicionar("D");
		vetor.adicionar("E");
		
		vetor.adicionar("F");
		
		assertEquals(capacidade * 2, vetor.getCapacidade());
	}
	
	@Test
	public void deveRemoverUmElementoDeUmaPosicao() throws Exception {
		int posicao = 1;
		Vetor vetor = new Vetor(10);
		
		vetor.adicionar("A");
		vetor.adicionar("G");
		vetor.adicionar("B");
		vetor.adicionar("C");
		vetor.adicionar("D");
		vetor.adicionar("E");
		
		vetor.remover(posicao);
		
		assertEquals("B", vetor.buscar(posicao));
		assertEquals("[A, B, C, D, E]", vetor.toString());
	}
	
	@Test
	public void deveRemoverUltimoElemento() throws Exception { // deve remover sem lançar exceção
		int posicao = 4;
		Vetor vetor = new Vetor(5);
		
		vetor.adicionar("A");
		vetor.adicionar("B");
		vetor.adicionar("C");
		vetor.adicionar("D");
		vetor.adicionar("E");
		
		vetor.remover(posicao);
		
		assertEquals("[A, B, C, D]", vetor.toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExcecaoAoTentarRemoverElementoSuperiorAoTamanho() throws Exception {
		int posicao = 5;
		Vetor vetor = new Vetor(5);
		
		vetor.adicionar("A");
		vetor.adicionar("B");
		vetor.adicionar("C");
		vetor.adicionar("D");
		vetor.adicionar("E");
		
		vetor.remover(posicao);
	}
	
	@Test
	public void deveRemoverUmElemento() throws Exception {
		Vetor vetor = new Vetor(5);
		
		vetor.adicionar("A");
		vetor.adicionar("B");
		vetor.adicionar("C");
		vetor.adicionar("D");
		vetor.adicionar("E");
		
		vetor.remover("C");
		
		assertEquals("[A, B, D, E]", vetor.toString());
		assertEquals(4, vetor.tamanho());
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExcecaoAoTentarRemoverElementoInexistente() throws Exception {
		Vetor vetor = new Vetor(5);
		
		vetor.adicionar("A");
		vetor.adicionar("B");
		vetor.adicionar("C");
		vetor.adicionar("D");
		vetor.adicionar("E");
		
		vetor.remover("Z");
	}
}
