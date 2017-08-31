package rogeriogentil.estruturadados.linear;

import java.lang.reflect.Array;

public abstract class Estrutura<T> {

	private T[] elementos;
	private int tamanho;
	private int capacidade;
	
	@SuppressWarnings("unchecked")
	public Estrutura(int capacidade) {
		this.capacidade = capacidade;
		this.elementos = (T[]) new Object[capacidade];
		this.tamanho = 0;
	}
	
	@SuppressWarnings("unchecked")
	public Estrutura(Class<T> tipoDeClasse, int capacidade) {
		this.capacidade = capacidade;
		this.elementos = (T[]) Array.newInstance(tipoDeClasse, capacidade);
		this.tamanho = 0;
	}
	
	public T[] getElementos() {
		return this.elementos;
	}
	
	public int getCapacidade() {
		return this.capacidade;
	}

	public int getTamanho() {
		return this.tamanho;
	}
	
	void incrementaTamanho() {
		this.tamanho++;
	}
	
	void decrementaTamanho() {
		this.tamanho--;
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
	
	@SuppressWarnings("unchecked")
	protected void aumentarCapacidade() {
		if (this.tamanho == this.elementos.length) {
			this.capacidade = this.elementos.length * 2;
			T[] novosElementos = (T[]) new Object[capacidade];
			
			for (int i = 0; i < this.elementos.length; i++) {
				novosElementos[i] = this.elementos[i];
			}
		
			this.elementos = novosElementos;
		}
	}
	
	public void limpar() {
		// 1ª opção
		for (int i = getTamanho() - 1; i >=0; i--) {
			getElementos()[i] = null;
		}
		
		tamanho = 0;
		
		// 2º opção
//		this.elementos = (T[]) new Object[this.elementos.length];
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
