package MergeSort;

import java.util.ArrayList;

public class MergeSort {
	private int[] numeros = new int[9];
	private int[] aux = new int[9];
	int cont = 1;

	public MergeSort() {
		numeros[0] = 6;
		numeros[1] = 5;
		numeros[2] = 3;
		numeros[3] = 1;
		numeros[4] = 8;
		numeros[5] = 7;
		numeros[6] = 2;
		numeros[7] = 4;
		numeros[8] = 10;
	}
	
	void print(){
		ArrayList<Integer> a = new ArrayList<>();
		for (int i= 0 ; i<9 ; i++) {
			a.add(numeros[i]);
		}
		System.out.println(a);
	}

	public void mergeSort(int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			//Ordena parte izquierda
			mergeSort(low, middle);
			System.out.println("------izquierda------");
			print();
			//Ordena parte derecha
			mergeSort(middle + 1, high);
			System.out.println("------derecha------");
			print();
			//combinar ambas mitades ordenadas
			merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high) {
		System.out.println("entra a merge Low: " + low + " mid: " + middle + " high: " + high );
		cont++;
		for (int i = low; i <= high; i++) {
			aux[i] = numeros[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;

		while (i <= middle && j <= high) {
			if (aux[i] <= aux[j]) {
				numeros[k] = aux[i];
				i++;
			} else {
				numeros[k] = aux[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			numeros[k] = aux[i];
			k++;
			i++;
		}
		while (j <= high) {
			numeros[k] = aux[j];
			k++;
			j++;
		}

	}
	
	public static void main(String[] args) {
		MergeSort a = new MergeSort();

//		a.print();
		a.mergeSort(0, 8);
		System.out.println("----");
//		a.print();


	}
}
