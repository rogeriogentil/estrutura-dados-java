package rogeriogentil.estruturadados.linear;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

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
			String s = vetor.buscar(0);
			
			assertEquals("1º elemento", s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExcecaoAoTentarAcessarPosicaoNegativa() {
		String s = vetor.buscar(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExcecaoAoTentarAcessarPosicaoAcimaDaCapacidade() {
		String s = vetor.buscar(10000);
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
}
