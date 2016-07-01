package rogeriogentil.estruturadados.linear;

public class Vetor {
	
	private String[] elementos;
	private int tamanho;

	public Vetor(int capacidade) {
		this.elementos = new String[capacidade];
		this.tamanho = 0;
	}
	
	public int tamanho() {
		return this.tamanho;
	}
	
	public void adicionar(String elemento) throws Exception {
		/* Algoritmo pouco eficiente */
//		for (int i = 0; i < this.elementos.length; i++) {
//			if (this.elementos[i] == null) {
//				this.elementos[i] = elemento;
//				break;
//			}
//		}
		
		if (tamanho < elementos.length) { 
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
		} else {
			throw new Exception("Vetor já chegou na sua capacidade máxima.");
		}
	}
	
	public boolean adicionarBoolean(String elemento) {
		if (tamanho < elementos.length) {
			elementos[tamanho] = elemento;
			tamanho++;
			return true;
		}
		
		return false;
	}
	
	public void adicionar(String elemento, int posicao) {
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição inválida");
		}
		
		for (int i = this.tamanho - 1; i >= posicao; i--) {
			this.elementos[i + 1] = this.elementos[i];
		}
		
		this.elementos[posicao] = elemento;
		this.tamanho++;
	}
	
	public String buscar(int posicao) {
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição inválida");
		}
		
		return this.elementos[posicao];
	}

	public boolean existeElemento(String elemento) {
		for (int i = 0; i < this.tamanho; i ++) {
			if (this.elementos[i].equals(elemento)) {
				return true;
			}
		}
		
		return false;
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
