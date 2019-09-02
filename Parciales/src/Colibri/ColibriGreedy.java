package Colibri;

import java.util.ArrayList;

public class ColibriGreedy {
	ArrayList<Integer> flores;

	public ColibriGreedy() {
		this.flores = new ArrayList<>();
		for (int i = 0; i <= 20; i++) {
			flores.add((int) (Math.random() * 10));
		}

	}

	public ArrayList<Integer> getSolucion() {
		ArrayList<Integer> solucion = new ArrayList<>();
		ArrayList<Integer> sinUsar = new ArrayList<>(this.flores);
		while (solucion.size() < 15) {
			solucion.add(this.getMejorOpcion(sinUsar));
//			Integer a = Collections.max(sinUsar);
//			solucion.add(a);
//			sinUsar.remove(a);
		}
		return solucion;
	}

	private Integer getMejorOpcion(ArrayList<Integer> sinUsar) {
		Integer op = Integer.MIN_VALUE;
		int index = 0;
		for (int i = 0; i < sinUsar.size(); i++) {
			if (op < sinUsar.get(i)) {
				op = sinUsar.get(i);
				index = i;
			}
		}
		sinUsar.remove(index);
		return op;
	}
	
	public static void main(String[] args) {
		ColibriGreedy g = new ColibriGreedy();
		
		System.out.println(g.flores);
		System.out.println(g.getSolucion());
	}
}
