package rogeriogentil.estruturadados.linear;

public class Vetor<T> extends Estrutura<T> {
	
	public Vetor(Class<T> tipoDeClasse, int capacidade) {
		super(tipoDeClasse, capacidade);
	}

	public Vetor(int capacidade) {
		super(capacidade);		
	}

	public void adicionar(T elemento, int posicao) {
		if (!(posicao >= 0 && posicao < getTamanho())) {
			throw new IllegalArgumentException("Posição inválida");
		}
		
		aumentarCapacidade();
		
		for (int i = getTamanho() - 1; i >= posicao; i--) {
			getElementos()[i + 1] = getElementos()[i];
		}
		
		getElementos()[posicao] = elemento;
		incrementaTamanho();
	}
	

	public T buscar(int posicao) {
		if (!(posicao >= 0 && posicao < getTamanho())) {
			throw new IllegalArgumentException("Posição inválida");
		}
		
		return getElementos()[posicao];
	}
	
	public int buscar(T elemento) {
		for (int i = 0; i < getTamanho(); i++) {
			if (getElementos()[i].equals(elemento)) {
				return i;
			}
		}
		
		return -1;
	}

	public boolean existeElemento(T elemento) {
		for (int i = 0; i < getTamanho(); i ++) {
			if (getElementos()[i].equals(elemento)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void remover(int posicao) {
		if (!(posicao >= 0 && posicao < getTamanho())) {			
			throw new IllegalArgumentException("Posição inválida");
		}
		
		for (int i = posicao; i < getTamanho() - 1; i++) {
			getElementos()[i] = getElementos()[i + 1];			
		}
		
		decrementaTamanho();
	}
	
	public void remover(T elemento) {
		int posicao = this.buscar(elemento);
		this.remover(posicao);
	}
	
	public int obterUltimoIndice() {
		return getTamanho() - 1;
	}
	
	public int obterUltimoIndice(T elemento) {
		for (int i = getTamanho() - 1; i >= 0; i--) {
			if (getElementos()[i].equals(elemento)) {
				return i;
			}
		}
		
		return -1;
	}
}
