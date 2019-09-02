import java.util.ArrayList;
import java.util.List;

public class Vertice {

	private String nombre;
	private List<Adyacente> listAdyacencias;

	public Vertice(String nombre) {
		this.nombre = nombre;
		this.listAdyacencias = new ArrayList<Adyacente>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public List<Vertice> getAdyacentes() {
		List<Vertice> aDevolver = new ArrayList<Vertice>();
		for (Adyacente a : listAdyacencias) {
			aDevolver.add(a.getDestino());
		}
		return aDevolver;
	}

	public ArrayList<Adyacente> getListAdyacentes() {
		return new ArrayList<Adyacente>(this.listAdyacencias);
	}

	public void addAdyacente(Adyacente a) {
		this.listAdyacencias.add(a);
	}

	public void addAdyacente(Vertice v) {
		Adyacente a = new Adyacente(v);
		int i = this.listAdyacencias.indexOf(a);
		if (i == -1) {
			this.listAdyacencias.add(a);
		} else {
			this.listAdyacencias.get(i).addPeso();
		}
	}

	public int getPesoAdyacente(Vertice v) {
		int i = 0;
		while (i < this.listAdyacencias.size() && !this.listAdyacencias.get(i).getDestino().equals(v)) {
			i++;
		}
		if (i < this.listAdyacencias.size()) {
			return this.listAdyacencias.get(i).getPeso();
		} else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object o) {
		return this.nombre.equals(((Vertice) o).getNombre());
	}

	@Override
	public String toString() {
		return this.nombre;
	}
}
