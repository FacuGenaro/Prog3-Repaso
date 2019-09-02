//import java.awt.List;
//import java.util.ArrayList;
//
//public class test {
//	public algo dijkstra (Vertice origen) {
//		List solucion
//		for (Vertice v : grafo) {
//			v.setPadre = null;
//			v.setDistancia = inf;
//		}
//		origen.setDistancia = 0;
//		
//		while (!solucion.contains(grafo)) {
//			Vertice u = getMejorOpcion(grafo, solucion);
//			solucion.add(u);
//			for (Vertice v : u.getAdyacentes()) {
//				if (u.getDistancia + distancia(u,v) < v.getDistancia) {
//					v.setDistancia = distancia(u,v);
//					v.setPadre = u;
//				}
//			}
//		}
//		
//		return padres;
//		
//	}
//
//	public ArrayList<Vertice> dfs (Vertice origen, List visitados, List actual){
//		List tmp;
//		visitados.add(origen);
//		for (Vertice v : origen.getAdyacentes()) {
//			if (!visitados.contains(v)) {
//				actual.add(v);
//				tmp.addAll(dfs (v,visitados,actual));
//				if (!tmp.isEmpty()) {
//					return tmp;
//				}
//			}
//		}
//		return actual;
//	}
//
//	public ArrayList<Vertice> bfs (origen){
//		List queue;
//		List solucion;
//		queue.add(origen);
//		
//		while (!queue.isEmpty) {
//			Vertice u = queue.get(0);
//			solucion.add(u);
//			for (Vertice v : u.getAdyacentes()) {
//				if (!queue.contains(v) && !solucion.contains(v)) {
//					queue.add(v);
//				}
//			}
//			queue.remove(v);
//		}
//		return solucion;
//	}
//
//	public ArrayList<ArrayList<Vertice>> detectarCiclos (Vertice v, visitados, queue, enCiclo){
//		List nodos;
//		visitados.add(v);
//		for (Vertice ve : v.getListAdyacentes()) {
//			if (queue.contains(ve)) {
//				if (!visitados.contains(ve)) {
//					nodos.addAll(detectarCiclos (ve,visitados,queue,enCiclo));
//				} else if (!enCiclo) {
//					nodos.addAll(detectarCiclos (ve, new ArrayList<>, queue, true));
//				} else {
//					nodos.add(new ArrayList<visitados>);
//				}
//			}
//		}
//		queue.remove(v);
//		return nodos;
//	}
//}
