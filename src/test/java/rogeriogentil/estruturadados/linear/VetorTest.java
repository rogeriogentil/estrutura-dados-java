package rogeriogentil.estruturadados.linear;

import org.junit.Test;

public class VetorTest {

	private Vetor vetor;
	
	@Test
	public void deveAdicionarElemento() throws Exception {
		vetor = new Vetor(5);
		
		vetor.adiciona("1");
		vetor.adiciona("2");
	}
	
	@Test(expected = Exception.class)
	public void deveLancarExcecaoAoSuperarCapacidade() throws Exception {
		vetor = new Vetor(2);
		
		vetor.adiciona("1º elemento");
		vetor.adiciona("2º elemento");

		// Tenta adicionar elemento quando capacidade do vetor foi atingida
		vetor.adiciona("3º elemento");
	}
	
	@Test
	public void deveImprimirElementos() {
		vetor = new Vetor(10);
		
		vetor.adicionaBoolean("1º elemento");
		vetor.adicionaBoolean("2º elemento");
		vetor.adicionaBoolean("3º elemento");

		System.out.println(vetor.tamanho());
		
		System.out.println(vetor);
	}
}
