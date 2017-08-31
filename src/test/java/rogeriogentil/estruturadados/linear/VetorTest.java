package rogeriogentil.estruturadados.linear;

import org.junit.Test;

import rogeriogentil.estruturadados.modelo.Contato;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Ignore;

public class VetorTest {

	private Vetor<Object> vetor;
	
	@Test
	public void deveAdicionarElemento() throws Exception {
		vetor = new Vetor<Object>(5);
		
		vetor.adicionar("1");
		vetor.adicionar("2");
	}
	
	@Ignore // Adicionado depois de adicionar o método Vetor#aumentarCapacidade() 
	@Test(expected = Exception.class)
	public void deveLancarExcecaoAoSuperarCapacidade() throws Exception {
		vetor = new Vetor<Object>(2);
		
		vetor.adicionar("1º elemento");
		vetor.adicionar("2º elemento");

		// Tenta adicionar elemento quando capacidade do vetor foi atingida
		vetor.adicionar("3º elemento");
	}
	
	@Test
	public void deveImprimirElementos() {
		vetor = new Vetor<Object>(5);
		
		vetor.adicionarBoolean("A");
		vetor.adicionarBoolean("B");
		vetor.adicionarBoolean("C");
		
		System.out.println(vetor.getTamanho());
		
		System.out.println(vetor);
	}
	
	@Test
	public void deveBuscarUmElemento() {
		vetor = new Vetor<Object>(10);
		
		vetor.adicionarBoolean("1º elemento");
		vetor.adicionarBoolean("2º elemento");
		
		try {
			Object s = vetor.buscar(0);
			
			assertEquals("1º elemento", s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExcecaoAoTentarAcessarPosicaoNegativa() {
		vetor = new Vetor<Object>(1);
		vetor.buscar(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExcecaoAoTentarAcessarPosicaoAcimaDaCapacidade() {
		vetor = new Vetor<Object>(100);
		vetor.buscar(10000);
	}
	
	@Test
	public void deveIndicarQueExisteElemento() {
		vetor = new Vetor<Object>(10);
		
		vetor.adicionarBoolean("1º elemento");
		vetor.adicionarBoolean("2º elemento");
		
		boolean existeElemento = vetor.existeElemento("2º elemento");
		assertTrue(existeElemento);
	}
	
	@Test
	public void deveIndicarQueNaoExisteElemento() {
		vetor = new Vetor<Object>(10);
		
		vetor.adicionarBoolean("A");
		vetor.adicionarBoolean("B");
		vetor.adicionarBoolean("C");
		
		boolean existeElemento = vetor.existeElemento("blablabla");
		assertFalse(existeElemento);
	}
	
	@Test
	public void deveAdicionarUmElementoEmUmaPosicao() {
		int posicao = 0;
		vetor = new Vetor<Object>(10);
		
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
		vetor = new Vetor<Object>(capacidade);
		
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
		vetor = new Vetor<Object>(10);
		
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
		vetor = new Vetor<Object>(5);
		
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
		vetor = new Vetor<Object>(5);
		
		vetor.adicionar("A");
		vetor.adicionar("B");
		vetor.adicionar("C");
		vetor.adicionar("D");
		vetor.adicionar("E");
		
		vetor.remover(posicao);
	}
	
	@Test
	public void deveRemoverUmElemento() throws Exception {
		vetor = new Vetor<Object>(5);
		
		vetor.adicionar("A");
		vetor.adicionar("B");
		vetor.adicionar("C");
		vetor.adicionar("D");
		vetor.adicionar("E");
		
		vetor.remover("C");
		
		assertEquals("[A, B, D, E]", vetor.toString());
		assertEquals(4, vetor.getTamanho());
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExcecaoAoTentarRemoverElementoInexistente() throws Exception {
		vetor = new Vetor<Object>(5);
		
		vetor.adicionar("A");
		vetor.adicionar("B");
		vetor.adicionar("C");
		vetor.adicionar("D");
		vetor.adicionar("E");
		
		vetor.remover("Z");
	}
	
	@Test
	public void deveCriarUmVetorDeUmTipoGenerico() throws Exception {
		Vetor<Contato> vetor = new Vetor<Contato>(3);
		
		Contato contato1 = new Contato("Fulano", "3371-7178", "fulano@gmail.com");
		Contato contato2 = new Contato("Ciclano", "3372-5713", "ciclano@yahoo.com.br");
		Contato contato3 = new Contato("Beltrano", "3371-1156", "beltrano@outlook.com");
		
		vetor.adicionar(contato1);
		vetor.adicionar(contato2);
		vetor.adicionar(contato3);
	}
	
	@Test
	public void deveObterUltimoIndice() throws Exception {
		vetor = new Vetor<Object>(5);
		
		vetor.adicionar("A");
		vetor.adicionar("B");
		vetor.adicionar("C");

		int ultimoIndice = vetor.obterUltimoIndice();
		
		assertThat(ultimoIndice, is(equalTo(2)));
	}
	
	@Test
	public void deveObterUltimoIndiceDeUmElemento() throws Exception {
		vetor = new Vetor<Object>(5);
		
		vetor.adicionar("A");
		vetor.adicionar("B");
		vetor.adicionar("A");
		vetor.adicionar("A");
		vetor.adicionar("B");		

		int ultimoIndice = vetor.obterUltimoIndice("A");
		
		assertThat(ultimoIndice, is(equalTo(3)));
	}
	
	public void deveLimparUmVetor() throws Exception {
		vetor = new Vetor<Object>(5);
		
		vetor.adicionar("A");
		vetor.adicionar("B");
		vetor.adicionar("C");
		vetor.adicionar("D");
		
		vetor.limpar();
		
		assertThat(vetor.getTamanho(), is(equalTo(0)));
	}
}
