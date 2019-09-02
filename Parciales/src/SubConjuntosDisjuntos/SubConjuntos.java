package SubConjuntosDisjuntos;

import java.util.ArrayList;
import java.util.Collections;

public class SubConjuntos {
	private final static int total = 10;
	private ArrayList<Integer> numeros = new ArrayList<Integer>();

	public SubConjuntos() {
		numeros.add(4);
		numeros.add(1);
		numeros.add(2);
		numeros.add(6);
		numeros.add(3);
		numeros.add(5);
		numeros.add(9);
	}

	public ArrayList<ArrayList<Integer>> backtrack() {
		ArrayList<ArrayList<Integer>> aDevolver = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> usados = new ArrayList<Integer>();
		ArrayList<Integer> queue = new ArrayList<Integer>(numeros);
		aDevolver.addAll(getResultado(this.numeros.get(0), this.numeros, usados, queue));
		return aDevolver;
	}

	private ArrayList<ArrayList<Integer>> getResultado(Integer v, ArrayList<Integer> numeros, ArrayList<Integer> usados,
			ArrayList<Integer> queue) {
		ArrayList<ArrayList<Integer>> tmp = new ArrayList<>();

		if (getSuma(usados) == total) {
			tmp.add(new ArrayList<>(usados));
			return tmp;
		}
		if (getSuma(usados) < total) {
			for (Integer i : numeros) {
				if (!usados.contains(i) && esMayor(usados, i) && queue.contains(i)) {
					usados.add(i);
					tmp.addAll(getResultado(i, numeros, usados, queue));
					usados.remove(i);
				}
			}
		}
		return tmp;
	}
	
	public boolean esMayor(ArrayList<Integer> usados, Integer i) {
		if (usados.isEmpty()) {
			return true;
		} else {
			return (usados.get(usados.size() - 1) > i);
		}
	}

	public int getSuma(ArrayList<Integer> a) {
		int suma = 0;
		for (Integer i : a) {
			suma += i;
		}
		return suma;
	}

	public static void main(String[] args) {
		SubConjuntos a = new SubConjuntos();

		System.out.println(a.backtrack());

	}
}
