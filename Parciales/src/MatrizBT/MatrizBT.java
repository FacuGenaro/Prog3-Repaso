package MatrizBT;

import java.util.ArrayList;
import java.util.List;

public class MatrizBT {
	private List<Integer> numeros = new ArrayList<>();
	private List<Integer> a = new ArrayList<>();
	private int[][] matriz = new int[4][5];

	public MatrizBT() {

	}
	
	public void cargarMatriz() {
		matriz[0][0] = 25;
		matriz[1][0] = 13;
		matriz[1][1] = 12;
		matriz[2][0] = 8;
		matriz[2][1] = 5;
		matriz[2][2] = 7;
		matriz[3][0] = 6;
		matriz[3][1] = 2;
		matriz[3][2] = 3;
		matriz[3][3] = 4;
	}

	public void print() {
		for (int x = 0; x < matriz.length; x++) {
			System.out.print("|");
			for (int y = 0; y < matriz[x].length; y++) {
				System.out.print(matriz[x][y]);
				if (y != matriz[x].length - 1)
					System.out.print("\t");
			}
			System.out.println("|");
		}
	}

	public static void main(String[] args) {
		MatrizBT b = new MatrizBT();
		b.cargarMatriz();
		b.print();
	}

}
