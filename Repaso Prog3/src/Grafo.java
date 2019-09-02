import java.util.ArrayList;
import java.util.List;

public abstract class Grafo {
	protected List<Vertice> listVertices;
	protected int cantV, cantA;

	protected Grafo() {
		listVertices = new ArrayList<Vertice>();
		this.cantA = 0;
	}

	public void addVertice(Vertice v) {
		if (!this.listVertices.contains(v))
			this.listVertices.add(v);
	}

	public int getCantV() {
		return listVertices.size();
	}

	public int getCantA() {
		return cantA;
	}

	public List<Vertice> getVertices() {
		return new ArrayList<Vertice>(listVertices);
	}

	public ArrayList<Vertice> DFS_CaminoMasLargo(Vertice origen, Vertice destino, Vertice z) {
		ArrayList<Vertice> aDevolver = new ArrayList<>();
		ArrayList<Vertice> visitados = new ArrayList<>();

		for (Vertice v : this.listVertices) {
			if (v.equals(origen)) {
				aDevolver.addAll(DFS_CaminoMasLargo(destino, v, visitados, z));
			}
		}
		return aDevolver;
	}

	private ArrayList<Vertice> DFS_CaminoMasLargo(Vertice destino, Vertice v, ArrayList<Vertice> visitados, Vertice z) {
		ArrayList<ArrayList<Vertice>> temp = new ArrayList<ArrayList<Vertice>>();
		visitados.add(v);
		if (destino.equals(v)) {
			return new ArrayList<Vertice>(visitados);
		}
		for (Vertice ve : v.getAdyacentes()) {
			if (!visitados.contains(ve) && ve != z) {
				temp.add(DFS_CaminoMasLargo(destino, ve, visitados, z));
				visitados.remove(ve);
			}
		}
		ArrayList<Vertice> caminoMasLargo = getCaminoMasLargo(temp);
		return caminoMasLargo;
	}

	private ArrayList<Vertice> getCaminoMasLargo(ArrayList<ArrayList<Vertice>> lista) {
		ArrayList<Vertice> aDevolver = new ArrayList<>();
		int mejorPeso = Integer.MIN_VALUE;
		for (List<Vertice> l : lista) {
			int peso = 0;
			for (int i = 0; i < l.size() - 2; i++) {
				peso += l.get(i).getPesoAdyacente(l.get(i + 1));
			}
			if (peso > mejorPeso) {
				mejorPeso = peso;
				aDevolver.clear();
				aDevolver.addAll(l);
			}
		}
		return aDevolver;
	}

	// Camino mas corto DFS
	public ArrayList<Vertice> BFS_CaminoMasCorto(Vertice origen, Vertice destino, Vertice z) {
		ArrayList<Vertice> aDevolver = new ArrayList<>();
		ArrayList<Vertice> queue = new ArrayList<>();

		queue.add(origen);

		while (!queue.isEmpty()) {
			Vertice u = queue.get(0);
			queue.remove(u);
			aDevolver.add(u);
//			if (aDevolver.contains(destino)) {
//				return aDevolver;
//			}
			for (Vertice v : u.getAdyacentes()) {
				if (!queue.contains(v) && !aDevolver.contains(v)) {
					queue.add(v);
				}
			}
		}

		return aDevolver;
	}


	// Cantidad de nodos de un ciclo
	public int cantNodosCiclo() {
		List<Vertice> queue = new ArrayList<>(this.listVertices);
		List<Vertice> visitados = new ArrayList<>();
		List<List<Vertice>> nodosDelCiclo = new ArrayList<>();
		Vertice v = listVertices.get(0);
		nodosDelCiclo.addAll(detectarCicloNodos(v, visitados, queue, false));
		System.out.println(nodosDelCiclo);
		return nodosDelCiclo.size();
	}

	public List<List<Vertice>> detectarCicloNodos(Vertice v, List<Vertice> visitados, List<Vertice> queue,
			boolean enCiclo) {
		List<List<Vertice>> nodos = new ArrayList<>();
		visitados.add(v);
		for (Vertice ve : v.getAdyacentes()) {
			if (queue.contains(ve)) {
				if (!visitados.contains(ve)) {
					nodos.addAll(detectarCicloNodos(ve, visitados, queue, enCiclo));
				} else if (!enCiclo) {
					nodos.addAll(detectarCicloNodos(ve, new ArrayList<>(), queue, true));
				} else {
					nodos.add(new ArrayList<>(visitados));
				}
			}
		}
		queue.remove(v);
		return nodos;
	}

	// Recorrido DFS

	public ArrayList<Vertice> recorridoDFS() {
		ArrayList<Vertice> visitados = new ArrayList<>();
		ArrayList<Vertice> aDevolver = new ArrayList<>();
		ArrayList<Vertice> caminoActual = new ArrayList<>();
		for (Vertice v : this.listVertices) {
			if (!visitados.contains(v)) {
				aDevolver.add(v);
				aDevolver.addAll(recorrido_DFS(v, visitados, caminoActual));
			}
		}
		return aDevolver;
	}

	private ArrayList<Vertice> recorrido_DFS(Vertice v, ArrayList<Vertice> visitados, ArrayList<Vertice> caminoActual) {
		ArrayList<Vertice> tmp = new ArrayList<>();
		visitados.add(v);
		for (Vertice ve : v.getAdyacentes()) {
			if (!visitados.contains(ve)) {
				caminoActual.add(ve);
				tmp.addAll(recorrido_DFS(ve, visitados, caminoActual));
				if (!tmp.isEmpty()) {
					return tmp;
				}
			}
		}
		return caminoActual;
	}

	public ArrayList<Vertice> BFS(Vertice origen, Vertice destino) {
		ArrayList<Vertice> queue = new ArrayList<>();
		ArrayList<Vertice> aDevolver = new ArrayList<>();

		queue.add(origen);

		while (!queue.isEmpty()) {
			Vertice u = queue.get(0);
//			queue.remove(u);
			aDevolver.add(u);

			if (aDevolver.contains(destino)) {
				return aDevolver;
			}

			for (Vertice ve : u.getAdyacentes()) {
				if (!aDevolver.contains(ve) && !queue.contains(ve)) {
					queue.add(ve);
				}
			}
			queue.remove(u);
		}

		return aDevolver;
	}

//	public boolean tieneCiclo() {
//		List<Vertice> visitados = new ArrayList<>();
//		Boolean a = false;
//		Vertice v = listVertices.get(0);
//		return encontrarCiclo(v, visitados);
//	}
//
//	private boolean encontrarCiclo(Vertice v, List<Vertice> visitados) {
//		Boolean tmp = null;
//		visitados.add(v);
//		for (Vertice ve : v.getAdyacentes()) {
//			if (visitados.contains(ve)) {
//				return true;
//			} else {
//				tmp = encontrarCiclo(ve, visitados);
//				visitados.remove(ve);
//				if (tmp != null) {
//					return tmp;
//				}
//			}
//		}
//		return false;
//	}

	public ArrayList<ArrayList<Vertice>> DFSRepaso(Vertice a, Vertice b, Vertice c) {
		ArrayList<ArrayList<Vertice>> tmp = new ArrayList<>();
		ArrayList<Vertice> visitados = new ArrayList<Vertice>();
		tmp.addAll(DFS(a, b, c, visitados));
		return tmp;
	}

	public ArrayList<ArrayList<Vertice>> DFS(Vertice a, Vertice b, Vertice c, ArrayList<Vertice> visitados) {
		ArrayList<ArrayList<Vertice>> tmp = new ArrayList<>();
		visitados.add(a);
		if (visitados.contains(b) && !visitados.isEmpty()) {
			ArrayList<ArrayList<Vertice>> n = new ArrayList<>();
			n.add(new ArrayList<>(visitados));
			return n;
		}

		for (Vertice v : a.getAdyacentes()) {
			if (!visitados.contains(v) && (v != c)) {
				tmp.addAll(DFS(v, b, c, visitados));
				visitados.remove(v);
			}
		}

		return tmp;
	}

	public ArrayList<Vertice> BFS_Again() {
		ArrayList<Vertice> queue = new ArrayList<>();
		ArrayList<Vertice> aDevolver = new ArrayList<>();

		queue.add(this.listVertices.get(0));

		while (!queue.isEmpty()) {
			Vertice u = queue.get(0);
			aDevolver.add(u);
			for (Vertice v : u.getAdyacentes()) {
				if (!queue.contains(v) && !aDevolver.contains(v)) {
					queue.add(v);
				}
			}
			queue.remove(u);
		}

		return aDevolver;
	}

	// Determinar si un grafo contiene un nodo que tiene K ciclos

	public Boolean cumple(int k) {
		ArrayList<Vertice> visitados = new ArrayList<>();
		ArrayList<ArrayList<Vertice>> ciclos = new ArrayList<>();
		ArrayList<Vertice> queue = new ArrayList<>(this.listVertices);
		ciclos.addAll(buscaCiclos(queue.get(0), visitados, false, queue));
		System.out.println(ciclos);
		return contieneElCiclo(ciclos, k);
	}

	public ArrayList<ArrayList<Vertice>> buscaCiclos(Vertice u, ArrayList<Vertice> visitados, boolean enCiclo, ArrayList<Vertice> queue) {
		ArrayList<ArrayList<Vertice>> nodos = new ArrayList<>();

		visitados.add(u);

		for (Vertice v : u.getAdyacentes()) {
			if (queue.contains(v)) {
				if (!visitados.contains(v)) {
					nodos.addAll(buscaCiclos(v, visitados, enCiclo, queue));
				}else if (!enCiclo) {
					nodos.addAll(buscaCiclos(v, new ArrayList<>(), true, queue));
				}else {
					nodos.add(new ArrayList<>(visitados));
				}
			}
		}
		queue.remove(u);
		return nodos;

	}
	
	public boolean contieneElCiclo(ArrayList<ArrayList<Vertice>> a, int k) {
		for (ArrayList<Vertice> v : a) {
			if (v.size() == k) {
				System.out.println(v);
				return true;
			}
		}
		return false;
	}
	
	public boolean existeCiclo(Vertice origen, ArrayList<Vertice> usados) {
		usados.add(origen);
		for (Vertice v : origen.getAdyacentes()) {
			if (!usados.contains(v)) {
				return existeCiclo(v,usados);
			}else {
				return true;
			}
		}
		return false;
	}
	
	//encontrar un camino desde A hasta B que sea de mayor longitud que C
	
	public ArrayList<Vertice> dfs_final (Vertice origen, Vertice destino, Integer c){
		ArrayList<Vertice> visitados = new ArrayList<>();
		ArrayList<Vertice> aDevolver = new ArrayList<>();
		ArrayList<ArrayList<Vertice>> tmp = new ArrayList<>();
		tmp.addAll(dfs_final(visitados,origen,destino));
		System.out.println(tmp);
		return null;
	}
	
	private ArrayList<ArrayList<Vertice>> dfs_final (ArrayList<Vertice> visitados, Vertice origen, Vertice destino){
		ArrayList<ArrayList<Vertice>> tmp = new ArrayList<>();
		if (visitados.contains(destino)) {
			tmp.add((new ArrayList<Vertice>(visitados)));
			return tmp;
		}
		for (Vertice v : origen.getAdyacentes()) {
			if (!visitados.contains(v)) {
				visitados.add(v);
				tmp.addAll(dfs_final(visitados, v, destino));
				visitados.remove(v);
			}
		}
		return tmp;
	}

	public abstract boolean existeArista(Vertice v1, Vertice v2);

	public abstract int getPesoArista(Vertice v1, Vertice v2);

	public abstract void addArista(Vertice v1, Vertice v2);

	public abstract List<Vertice> getAdyacentes(Vertice v);

}
