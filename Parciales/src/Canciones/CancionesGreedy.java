package Canciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CancionesGreedy {
	List<Integer> canciones;

	public CancionesGreedy() {
		this.canciones = new ArrayList<>();
		for (int i = 0; i <= 90; i++) {
			canciones.add((int) (Math.random() * 10) + 1 );
		}

	}
	
	public List<Integer> getCD(){
		List<Integer> aDevolver = new ArrayList<>();
		Integer suma = 0;
		while (suma < 60) {
			Integer a = Collections.min(canciones);
			suma += a;
			canciones.remove(a);
			aDevolver.add(a);
		}
		return aDevolver;
	}
	
	public static void main(String[] args) {
		CancionesGreedy g = new CancionesGreedy();
		System.out.println(g.getCD());
	}
}
