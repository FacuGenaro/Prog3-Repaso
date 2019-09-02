import java.util.ArrayList;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Vertice v1 = new Vertice("v1");
		Vertice v2 = new Vertice("v2");
		Vertice v3 = new Vertice("v3");
		Vertice v4 = new Vertice("v4");
		Vertice v5 = new Vertice("v5");
		Vertice v6 = new Vertice("v6");
		Vertice v7 = new Vertice("v7");

		// Grafo dirigido recuperatorio 2017
//		Adyacente a1 = new Adyacente(v4, 0);
//		// 4
//		Adyacente a2 = new Adyacente(v3, 0);
//		// 3
//		Adyacente a3 = new Adyacente(v6, 0);
//		Adyacente a4 = new Adyacente(v2, 0);
//		// 6
//		Adyacente a5 = new Adyacente(v5, 0);
//		// 5
//		Adyacente a6 = new Adyacente(v4, 0);
//		//
//		Adyacente a7 = new Adyacente(v7, 0);
//
//		v1.addAdyacente(a1);
//		v4.addAdyacente(a2);
//		v3.addAdyacente(a3);
//		v3.addAdyacente(a4);
//		v6.addAdyacente(a5);
//		v5.addAdyacente(a6);
//		v2.addAdyacente(a7);
//
//		GrafoNoDirigido gnd = new GrafoNoDirigido();
//
//		gnd.addVertice(v1);
//		gnd.addVertice(v2);
//		gnd.addVertice(v3);
//		gnd.addVertice(v4);
//		gnd.addVertice(v5);
//		gnd.addVertice(v6);
//		gnd.addVertice(v7);

		// Grafo no dirigido parcial 2018

//		Adyacente a1 = new Adyacente(v2, 7);
//		Adyacente a2 = new Adyacente(v3, 3);
//		//2
//		Adyacente a3 = new Adyacente(v4, 6);
//		Adyacente a4 = new Adyacente(v3, 1);
//		Adyacente a5 = new Adyacente(v1, 7);
//		//3
//		Adyacente a6 = new Adyacente(v1, 3);
//		Adyacente a7 = new Adyacente(v2, 1);
//		Adyacente a8 = new Adyacente(v4, 3);
//		Adyacente a9 = new Adyacente(v5, 8);
//		//4
//		Adyacente a10 = new Adyacente(v2, 6);
//		Adyacente a11 = new Adyacente(v3, 3);
//		Adyacente a12 = new Adyacente(v5, 2);
//		Adyacente a13 = new Adyacente(v6, 2);
//		//5
//		Adyacente a14 = new Adyacente(v3, 8);
//		Adyacente a15 = new Adyacente(v4, 2);
//		Adyacente a16 = new Adyacente(v6, 8);
//		//6
//		Adyacente a17 = new Adyacente(v4, 2);
//		Adyacente a18 = new Adyacente(v5, 8);
//		
//		v1.addAdyacente(a1);
//		v1.addAdyacente(a2);
//	
//		v2.addAdyacente(a3);
//		v2.addAdyacente(a4);
//		v2.addAdyacente(a5);
//		
//		v3.addAdyacente(a6);
//		v3.addAdyacente(a7);
//		v3.addAdyacente(a8);
//		v3.addAdyacente(a9);
//		
//		v4.addAdyacente(a10);
//		v4.addAdyacente(a11);
//		v4.addAdyacente(a12);
//		v4.addAdyacente(a13);
//		
//		v5.addAdyacente(a14);
//		v5.addAdyacente(a15);
//		v5.addAdyacente(a16);
//		
//		v6.addAdyacente(a17);
//		v6.addAdyacente(a18);
//		
//		GrafoNoDirigido gnd = new GrafoNoDirigido();
//
//		gnd.addVertice(v1);
//		gnd.addVertice(v2);
//		gnd.addVertice(v3);
//		gnd.addVertice(v4);
//		gnd.addVertice(v5);
//		gnd.addVertice(v6);

//		Grafo dirigido parcial 2018

		// 1
		Adyacente a12 = new Adyacente(v2, 7);
		Adyacente a13 = new Adyacente(v3, 3);
		// 2
		Adyacente a24 = new Adyacente(v4, 6);
		Adyacente a23 = new Adyacente(v3, 1);
		// 3
		Adyacente a35 = new Adyacente(v5, 8);
		// 4
		Adyacente a46 = new Adyacente(v6, 2);
		Adyacente a43 = new Adyacente(v3, 3);
		// 5
		Adyacente a54 = new Adyacente(v4, 2);
		Adyacente a56 = new Adyacente(v6, 8);

		v1.addAdyacente(a12);
		v1.addAdyacente(a13);

		v2.addAdyacente(a23);
		v2.addAdyacente(a24);

		v3.addAdyacente(a35);

		v4.addAdyacente(a43);
		v4.addAdyacente(a46);

		v5.addAdyacente(a54);
		v5.addAdyacente(a56);


		GrafoNoDirigido gnd = new GrafoNoDirigido();
//
		gnd.addVertice(v1);
		gnd.addVertice(v2);
		gnd.addVertice(v3);
		gnd.addVertice(v4);
		gnd.addVertice(v5);
		gnd.addVertice(v6);

//		System.out.println(gnd.dijkstra(v1,v4,v2));
//		System.out.println(gnd.cantNodosCiclo());
//		System.out.println("----------");
//		System.out.println(gnd.recorridoDFS());
//		System.out.println(gnd.BFS(v1, v6));
//		System.out.println(gnd.recorridoDFS());
//		System.out.println(gnd.DFS_CaminoMasLargo(v1, v6, v7));
//		System.out.println(gnd.BFS_CaminoMasCorto(v1, v6, v3));
//		System.out.println(gnd.BFS(v1, v6));
//		System.out.println(gnd.recorrer(v1));
//		System.out.println(gnd.tieneCiclo());
//		System.out.println(gnd.DFS_Recuperatorio(v1, v6, new ArrayList<Vertice>()));
//		System.out.println(gnd.DFSRepaso(v1,v6,v2));
//		System.out.println(gnd.BFS_Again());
//		System.out.println(gnd.cumple(4));
//		System.out.println(gnd.existeCiclo(v2, new ArrayList<Vertice>()));
		System.out.println(gnd.dfs_final(v1, v3, 4));

	}

}
