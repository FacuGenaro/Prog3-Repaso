import java.util.ArrayList;
import java.util.List;

public class GrafoNoDirigido extends Grafo {
	public GrafoNoDirigido() {
		super();
	}

	public boolean existeArista(Vertice v1, Vertice v2) {
		int i = this.listVertices.indexOf(v1);
		return this.listVertices.get(i).getAdyacentes().contains(v2);
	}

	public int getPesoArista(Vertice v1, Vertice v2) {
		int i = this.listVertices.indexOf(v1);
		return this.listVertices.get(i).getPesoAdyacente(v2);
	}

	public void addArista(Vertice v1, Vertice v2) {
		int i = this.listVertices.indexOf(v1);
		this.cantA++;
		this.listVertices.get(i).addAdyacente(v2);
	}

	public List<Vertice> getAdyacentes(Vertice v) {
		int i = this.listVertices.indexOf(v);
		return new ArrayList<Vertice>(this.listVertices.get(i).getAdyacentes());
	}
}
