package Colibri;

import java.util.ArrayList;
import java.util.Collections;

public class ColibriBacktracking {
	ArrayList<Integer> flores;
	private int mejor = Integer.MIN_VALUE;

	public ColibriBacktracking() {
		this.flores = new ArrayList<>();
		for (int i = 0; i <= 30; i++) {
			flores.add((int) (Math.random() * 10));
		}
	}

	public ArrayList<Integer> getSolucionBT() {
		ArrayList<ArrayList<Integer>> solucion = new ArrayList<>();
		ArrayList<Integer> sinUsar = new ArrayList<>(this.flores);
		ArrayList<Integer> usados = new ArrayList<>();
		ArrayList<Integer> s = new ArrayList<>();
		solucion = (backTrack(sinUsar, usados, solucion));
		s = getMayor(solucion);
		return s;
	}

	public ArrayList<Integer> getMayor(ArrayList<ArrayList<Integer>> solucion) {
		int temp = 0;
		int mejor = Integer.MIN_VALUE;
		ArrayList<Integer> aDevolver = new ArrayList<>();
		for (ArrayList<Integer> a1 : solucion) {
			temp = getSuma(a1);
			if (temp > mejor) {
				mejor = temp;
				aDevolver = a1;
			}
		}
		return aDevolver;
	}

	public ArrayList<ArrayList<Integer>> backTrack(ArrayList<Integer> sinUsar, ArrayList<Integer> usados,
			ArrayList<ArrayList<Integer>> solucion) {
		ArrayList<ArrayList<Integer>> aux = new ArrayList<ArrayList<Integer>>();
		if (poda(usados)) {
			if (usados.size() == 15) {
				aux.add(new ArrayList<Integer>(usados));
				return aux;
			}
			for (Integer i : this.flores) {
				if (!usados.contains(i)) {
					usados.add(i);
					sinUsar.remove(i);
					aux.addAll(backTrack(sinUsar, usados, solucion));
					usados.remove(i);
				}
			}
		}
		return aux;
	}

	public boolean poda(ArrayList<Integer> a) {
		if (a.size() < 15) {
			return true;
		} else if (getSuma(a) > mejor) {
			mejor = getSuma(a);
			System.out.println(mejor);
			return true;
		}
		return false;
	}

	public static int getSuma(ArrayList<Integer> a) {
		int suma = 0;
		for (Integer i : a) {
			suma += i;
		}
		return suma;
	}

	public ArrayList<Integer> getSolucionGreedy() {
		ArrayList<Integer> solucion = new ArrayList<>();
		ArrayList<Integer> sinUsar = new ArrayList<>(this.flores);
		while (solucion.size() < 15) {
			Integer a = Collections.max(sinUsar);
			solucion.add(a);
			sinUsar.remove(a);
		}
		return solucion;
	}

	public static void main(String[] args) {
		ColibriBacktracking g = new ColibriBacktracking();
		ArrayList<Integer> a = new ArrayList<>(g.getSolucionBT());
		Collections.sort(a);
		Collections.reverse(a);
		System.out.println(a);
//		System.out.println(g.getSolucionBT().contains(g.getSolucionGreedy()));
		System.out.println(g.getSolucionGreedy());
		System.out.println(getSuma(g.getSolucionGreedy()));
	}
}
