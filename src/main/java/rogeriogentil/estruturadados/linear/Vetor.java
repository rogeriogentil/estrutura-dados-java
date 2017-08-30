package rogeriogentil.estruturadados.linear;

import java.lang.reflect.Array;

public class Vetor<T> {
	
	private T[] elementos;
	private int tamanho;
	private int capacidade;

	@SuppressWarnings("unchecked")
	public Vetor(int capacidade) {
		this.capacidade = capacidade;
		this.elementos = (T[]) new Object[capacidade];
		this.tamanho = 0;
	}
	
	@SuppressWarnings("unchecked")
	public Vetor(Class<T> tipoDeClasse, int capacidade) {
		this.capacidade = capacidade;
		this.elementos = (T[]) Array.newInstance(tipoDeClasse, capacidade);
		this.tamanho = 0;
	}
		
	public int getCapacidade() {
		return this.capacidade;
	}

	public int tamanho() {
		return this.tamanho;
	}
	
	public void adicionar(T elemento) throws Exception {
		/* Algoritmo pouco eficiente */
//		for (int i = 0; i < this.elementos.length; i++) {
//			if (this.elementos[i] == null) {
//				this.elementos[i] = elemento;
//				break;
//			}
//		}
		aumentarCapacidade();
		
		if (tamanho < elementos.length) { 
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
		} else {
			throw new Exception("Vetor já chegou na sua capacidade máxima.");
		}
	}
	
	public boolean adicionarBoolean(T elemento) {
		aumentarCapacidade();
		
		if (tamanho < elementos.length) {
			elementos[tamanho] = elemento;
			tamanho++;
			return true;
		}
		
		return false;
	}
	
	public void adicionar(T elemento, int posicao) {
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição inválida");
		}
		
		aumentarCapacidade();
		
		for (int i = this.tamanho - 1; i >= posicao; i--) {
			this.elementos[i + 1] = this.elementos[i];
		}
		
		this.elementos[posicao] = elemento;
		this.tamanho++;
	}
	
	@SuppressWarnings("unchecked")
	private void aumentarCapacidade() {
		if (this.tamanho == this.elementos.length) {
			this.capacidade = this.elementos.length * 2;
			T[] novosElementos = (T[]) new Object[capacidade];
			
			for (int i = 0; i < this.elementos.length; i++) {
				novosElementos[i] = this.elementos[i];
			}
		
			this.elementos = novosElementos;
		}
	}
	
	public T buscar(int posicao) {
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição inválida");
		}
		
		return this.elementos[posicao];
	}
	
	public int buscar(T elemento) {
		for (int i = 0; i < this.tamanho; i++) {
			if (this.elementos[i].equals(elemento)) {
				return i;
			}
		}
		
		return -1;
	}

	public boolean existeElemento(T elemento) {
		for (int i = 0; i < this.tamanho; i ++) {
			if (this.elementos[i].equals(elemento)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void remover(int posicao) {
		if (!(posicao >= 0 && posicao < tamanho)) {			
			throw new IllegalArgumentException("Posição inválida");
		}
		
		for (int i = posicao; i < this.tamanho - 1; i++) {
			this.elementos[i] = this.elementos[i + 1];			
		}
		
		this.tamanho--;
	}
	
	public void remover(T elemento) {
		int posicao = this.buscar(elemento);
		this.remover(posicao);
	}
	
	public int obterUltimoIndice() {
		return tamanho - 1;
	}
	
	@Override
	public String toString() {
		// Método padrão
//		String s = "[";
//		
//		for (int i = 0; i < tamanho - 1; i++) {
//			s += this.elementos[i];
//			s += ", ";
//		}
//		
//		if (this.tamanho > 0) {
//			s += this.elementos[tamanho - 1];
//		}
//		
//		s += "]";
//		
//		return s;
		
		// Método em Java
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		for (int i = 0; i < tamanho - 1; i++) {
			sb.append(this.elementos[i]);
			sb.append(", ");
		}
		
		if (this.tamanho > 0) {
			sb.append(this.elementos[tamanho - 1]);
		}
		
		sb.append("]");
		
		return sb.toString();
	}
}
