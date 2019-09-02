import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutacionesBT {
	ArrayList<Integer> numeros = new ArrayList<>();

	public PermutacionesBT() {
		numeros.add(1);
		numeros.add(2);
		numeros.add(3);
	}

	public List<List<Integer>> getPermutaciones() {
		List<Integer> usados = new ArrayList<>();
		List<List<Integer>> resultado = new ArrayList<List<Integer>>();
		getPermutaciones(numeros, usados, resultado);
		return resultado;
	}

	private void getPermutaciones(ArrayList<Integer> numeros, List<Integer> usados, List<List<Integer>> resultado) {
		if (usados.containsAll(numeros)) {
			resultado.add(new ArrayList<>(usados));
		}
		for (Integer i : numeros) {
			if (!usados.contains(i)) {
				usados.add(i);
				getPermutaciones(numeros, usados, resultado);
				usados.remove(i);
			}
		}
	}

	public static void main(String[] args) {
		PermutacionesBT a = new PermutacionesBT();

		System.out.println(a.getPermutaciones());

	}

}

//3 colores
// marcar visitados a medida que avanzo y cuando retrocedo lo saco de la lista de visitados
