package Facturas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FacturasGreedy {
	private final static int N=3;
	private List<Integer> facturas = new ArrayList<>();
	
	public FacturasGreedy() {
		int i = 0;
		while (i < N) {
			facturas.add((int)(Math.random() * 10) + 1 );
			i++;
		}
	}
	
	public Integer getKilometros(){
		int km = 0;
		int kmTotal = 0;
		int i= 0;
		while (i<N) {
			Integer a = Collections.max(facturas);
			facturas.remove(a);
			km = (a * (int)Math.pow(2, i));
			kmTotal += km;
			i++;
		}
		return kmTotal;
	}
	
	public static void main(String[] args) {
		FacturasGreedy gor2 = new FacturasGreedy();
		System.out.println(gor2.facturas);
		System.out.println(gor2.getKilometros());

	}

}
