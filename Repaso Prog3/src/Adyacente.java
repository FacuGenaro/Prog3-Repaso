
public class Adyacente {
	private Vertice destino;
	private Integer peso;

	Adyacente(Vertice v) {
		this.destino = v;
		this.peso = 1;
	}

	Adyacente(Vertice v, int peso) {
		this.destino = v;
		this.peso = peso;
	}

	Vertice getDestino() {
		return destino;
	}

	Integer getPeso() {
		return this.peso;
	}

	void addPeso() {
		this.peso++;
	}

	void addPeso(int peso) {
		this.peso = this.peso + peso;
	}
 
	@Override
	public String toString() {
		return "destino=" + destino;
	}

	@Override
	public boolean equals(Object o) {
		return this.destino.getNombre().equals(((Adyacente) o).getDestino().getNombre());
	}
}
