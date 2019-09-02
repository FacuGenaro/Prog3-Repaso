package Final2019;

import java.util.ArrayList;

public class Final2019 {

	private static final int M = 10;

	public ArrayList<ArrayList<Integer>> getCombinaciones(ArrayList<Integer> usados, ArrayList<Integer> todos) {
		ArrayList<ArrayList<Integer>> tmp = new ArrayList<>();
		if (getSuma(usados) == M) {
			tmp.add(new ArrayList<>(usados));
			return tmp;
		}
		if (getSuma(usados) < M) {
			for (Integer i : todos) {
				if (!usados.contains(i)) {
					usados.add(i);
					tmp.addAll(getCombinaciones(usados, todos));
					usados.remove(i);
				}
			}
		}
		return tmp;
	}

	public int getSuma(ArrayList<Integer> b) {
		int a = 0;
		for (Integer i : b) {
			a += i;
		}
		return a;
	}

	public static void main(String[] args) {
		ArrayList<Integer> usados = new ArrayList<>();
		ArrayList<Integer> todos = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			todos.add(i);
		}
		Final2019 a = new Final2019();
		System.out.println(a.getCombinaciones(usados, todos));

	}

}
