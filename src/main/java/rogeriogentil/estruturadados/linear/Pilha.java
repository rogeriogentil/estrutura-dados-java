package rogeriogentil.estruturadados.linear;

public class Pilha<T> extends Estrutura<T> {

	public Pilha(Class<T> tipoDeClasse, int capacidade) {
		super(tipoDeClasse, capacidade);
	}
	
	
	public Pilha(int capacidade) {
		super(capacidade); 
	}
}
