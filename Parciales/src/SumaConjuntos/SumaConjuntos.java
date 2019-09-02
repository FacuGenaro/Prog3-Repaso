package SumaConjuntos;

import java.util.ArrayList;

public class SumaConjuntos {

	private ArrayList<Integer> numeros = new ArrayList<>();
	private final static int M = 7;

	public SumaConjuntos() {
		numeros.add(1);
		numeros.add(2);
		numeros.add(3);
		numeros.add(4);
		numeros.add(3);
		numeros.add(4);
		numeros.add(7);

	}

	public ArrayList<ArrayList<Integer>> getConjuntos() {
		ArrayList<ArrayList<Integer>> aDevolver = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> solucion = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> usados = new ArrayList<>();
		aDevolver = (get_conjuntos(solucion, usados));
		return aDevolver;
	}

	private ArrayList<ArrayList<Integer>> get_conjuntos(ArrayList<ArrayList<Integer>> solucion,
			ArrayList<Integer> usados) {
		ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
		if (getSuma(usados) == M) {
			if (noEstaRepetido(solucion, usados)) {
				solucion.add(new ArrayList<Integer>(usados));
				tmp.add(new ArrayList<Integer>(usados));
				return tmp;
			}
		}
		if (getSuma(usados) < M) {
			for (Integer i : this.numeros) {
				if (!usados.contains(i)) {
					usados.add(i);
					tmp.addAll(get_conjuntos(solucion, usados));
					usados.remove(i);
				}
			}
		}
		return tmp;
	}

	private Boolean noEstaRepetido(ArrayList<ArrayList<Integer>> a, ArrayList<Integer> b) {
		for (ArrayList<Integer> v : a) {
			if (v.containsAll(b)) {
				return false;
			}
		}
		return true;
	}

	private int getSuma(ArrayList<Integer> a) {
		int suma = 0;
		for (Integer i : a) {
			suma += i;
		}

		return suma;
	}

	public static void main(String[] args) {
		SumaConjuntos a = new SumaConjuntos();

		System.out.println(a.getConjuntos());

	}
}
