import java.util.ArrayList;

public class CondicionListas implements CondicionPoda {
	private int mejorSuma;

	public CondicionListas() {
		this.mejorSuma = Integer.MAX_VALUE;
	}

	private int getPesoDeLaLista(ArrayList<Vertice> a) {
		int peso = 0;
		for (int i = 0; i < a.size() - 2; i++) {
			peso += a.get(i).getPesoAdyacente(a.get(i + 1));
		}
		return peso;
	}

	public Boolean hacerPoda(ArrayList<Vertice> l1) {
		int nuevo = getPesoDeLaLista(l1);
		if (nuevo < mejorSuma) {
			mejorSuma = nuevo;
		}
		return nuevo < mejorSuma;
	}
}
