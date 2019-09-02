package Monedas;

import java.util.ArrayList;
import java.util.List;

public class Monedas {
	private final static int total = 289;
	private int totaltmp = total;
	private List<Integer> monedas = new ArrayList<>();

	public Monedas() {
		monedas.add(100);
		monedas.add(25);
		monedas.add(10);
		monedas.add(5);
		monedas.add(1);
	}

	public List<Integer> greedy() {
		int totalTemp = total;
		List<Integer> aDevolver = new ArrayList<>();

		while (totalTemp > 0) {
			while (totalTemp >= 100) {
				Integer a = monedas.get(0);
				aDevolver.add(a);
				totalTemp -= a;
			}
			while (totalTemp >= 25) {
				Integer a = monedas.get(1);
				aDevolver.add(a);
				totalTemp -= a;
			}
			while (totalTemp >= 10) {
				Integer a = monedas.get(2);
				aDevolver.add(a);
				totalTemp -= a;
			}
			while (totalTemp >= 5) {
				Integer a = monedas.get(3);
				aDevolver.add(a);
				totalTemp -= a;
			}
			while (totalTemp >= 1) {
				Integer a = monedas.get(4);
				aDevolver.add(a);
				totalTemp -= a;
			}
		}

		return aDevolver;
	}

	public List<List<Integer>> bt() {
		int index = 0;
		List<List<Integer>> aDevolver = new ArrayList<>();
		List<Integer> usados = new ArrayList<>();
		aDevolver.addAll(backtracking(usados, index));
		return aDevolver;
	}

	public List<List<Integer>> backtracking(List<Integer> usados, int index) {
		List<List<Integer>> tmp = new ArrayList<>();
		System.out.println(index);
		if (getSuma(usados) == total) {
			tmp.add(new ArrayList<Integer>(usados));
			return tmp;
		}
		if (getSuma(usados) < total) {
			if (totaltmp >= this.monedas.get(index)) {
				usados.add(monedas.get(index));
				totaltmp -= monedas.get(index);
				tmp.addAll(backtracking(usados, index));
			} else if ((getSuma(usados) + monedas.get(index + 1)) < total) {
				index++;
				usados.add(monedas.get(index));
				totaltmp -= monedas.get(index);
				tmp.addAll(backtracking(usados, index));
			} else {
				index = index + 2;
				usados.add(monedas.get(index));
				totaltmp -= monedas.get(index);
				tmp.addAll(backtracking(usados, index));
			}
		}
		return tmp;
	}



	public int getSuma(List<Integer> a) {
		int suma = 0;
		for (Integer i : a) {
			suma += i;
		}
		System.out.println(suma);
		return suma;
	}

	public static void main(String[] args) {
		Monedas x = new Monedas();
		System.out.println(x.greedy());
		System.out.println(x.bt());

	}

}
