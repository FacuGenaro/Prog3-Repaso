package ArbolBinario;

import java.util.ArrayList;
import java.util.List;

public class Arbol {
	private Arbol izq;
	private Arbol der;
	private Integer valor;

	public Arbol(Integer v) {
		this.valor = v;
		this.izq = null;
		this.der = null;
	}

	public Arbol copiarArbol() {
		Arbol aDevolver = new Arbol(this.valor);
		if (this.izq != null) {
//			this.izq.copiarArbol();
			aDevolver.insertar(izq.valor);
		}
		if (this.der != null) {
//			this.der.copiarArbol();
			aDevolver.insertar(der.valor);
		}
		return aDevolver;
	}

	public int getSumaHojas() {
		int suma = 0;
		if (this.izq != null) {
			suma += this.izq.getSumaHojas();
		}
		if (this.der != null) {
			suma += this.der.getSumaHojas();
		}
		if (this.izq == null && this.der == null) {
			return this.valor;
		}
		return suma;
	}

	public int getCantidadHijos() {
		int nodos = 0;
		if (this.izq != null) {
			nodos++;
			nodos += this.izq.getCantidadHijos();
		}
		if (this.der != null) {
			nodos++;
			nodos += this.der.getCantidadHijos();
		}

		return nodos;
	}

	public void insertar(Integer v) { // Complejidad O(log n)
		if (izq == null && v < this.valor) {
			this.izq = new Arbol(v);
		} else if (der == null && v > this.valor) {
			this.der = new Arbol(v);
		} else if (izq != null && v < this.valor) {
			izq.insertar(v);
		} else {
			der.insertar(v);
		}
	}

	public Integer getRaiz() {
		return this.valor;
	}

	public void printInOrder() {
		if (this.izq != null) {
			this.izq.printInOrder();
		}
		System.out.println(this.valor);
		if (this.der != null) {
			this.der.printInOrder();
		}
	}

	public void printPreOrder() {
		System.out.println(this.valor);
		if (this.izq != null) {
			this.izq.printPreOrder();
		}
		if (this.der != null) {
			this.der.printPreOrder();
		}
	}

	public void printPostOrder() {
		if (this.izq != null) {
			this.izq.printPostOrder();
		}
		if (this.der != null) {
			this.der.printPostOrder();
		}
		System.out.println(this.valor);
	}

	public boolean hasElem(Integer v) { // Complejidad O(Log n)
		if (this.valor.equals(v)) {
			return true;
		} else {
			if (v < this.valor) {
				if (izq != null) {
					return izq.hasElem(v);
				}
			} else {
				if (der != null) {
					return der.hasElem(v);
				}
			}
		}
		return false;
	}

	public List<Integer> getFrontera() {
		ArrayList<Integer> aDevolver = new ArrayList<>();
		this.getFrontera(aDevolver);
		return aDevolver;

	}

	private void getFrontera(List<Integer> aDevolver) {
		if (this.izq != null) {
			this.izq.getFrontera(aDevolver);
		}
		if (this.der != null) {
			this.der.getFrontera(aDevolver);
		}
		if (this.izq == null && this.der == null) {
			aDevolver.add(this.valor);
		}
	}

	// Delete

	private void eliminarHoja(Integer v, Arbol padre) {
		if (padre.izq.valor.equals(v)) {
			padre.izq = null;
		} else {
			padre.der = null;
		}
	}

	private void eliminarConUnHijo(Integer v, Arbol padre) {
		if (padre.izq.valor.equals(v)) {
			padre.izq = padre.izq.izq;
		} else {
			padre.der = padre.der.der;
		}
	}

	private void eliminarConDosHijos() {
		Arbol NMI = this.der.getNMI();
		this.valor = NMI.valor;
	}

	private Arbol getNMI() {
		if (this.izq != null) {
			return this.izq.getNMI();
		}
		return this;
	}

	public void delete(Integer v, Arbol padre) {
		if (this.hasElem(v)) {
			if (this.valor.equals(v)) {
				if (this.izq == null && this.der == null) {
					this.eliminarHoja(v, padre);
				} else if (this.izq != null && this.der == null) {
					this.eliminarConUnHijo(v, padre);
				} else if (this.izq == null && this.der != null) {
					this.eliminarConUnHijo(v, padre);
				} else if (this.izq != null && this.der != null) {
					this.eliminarConDosHijos();
					v = this.valor;
					this.der.delete(v, this);
				}
			} else if (this.valor < v) {
				this.der.delete(v, this);
			} else {
				this.izq.delete(v, this);
			}
		}
	}

	public String toString() {
		return this.valor.toString();
	}

	public static void main(String[] args) {
		Arbol a1 = new Arbol(30);

		a1.insertar(20);
		a1.insertar(40);
		a1.insertar(35);
		a1.insertar(24);
		a1.insertar(18);
		a1.insertar(7);
		a1.insertar(42);

// 			DIBUJITO DE MI ARBOL		
//					30
//			20				40
//		18		24		35		42
//	7	
//		
//		System.out.println("El arbol es:");
//		
//		a1.print();
//		

//		
//		System.out.println("La frontera es:");
//		
		a1.printInOrder();
		System.out.println("--------------");
		a1.printPostOrder();
		System.out.println("--------------");
		a1.printPreOrder();
//		Arbol aDevolver = new Arbol(a1.getCantidadHijos());
		System.out.println("--------------");
//		
//		System.out.println("--------------");
//		
//		System.out.println("Delete 30");
//		
//		a1.delete(30,a1);
//		a1.print();
//		
//		System.out.println("--------------");
//		
//		System.out.println("Despues de eliminar la Raiz, esta es la nueva " + a1.getRaiz());

	}
}
