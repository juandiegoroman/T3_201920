	package model.data_structures;

import com.sun.org.apache.regexp.internal.recompile;

import java.util.Objects;

	public class ListaEncadenada<E> implements IListaEncadenada<E>, IListaIterable<E> {
	
		private Nodo<E> primero;
	
		private Nodo<E> ultimo;
	
		private int tamano;
	
		public ListaEncadenada() {
			tamano = 0;
		}

	public E primero() {
		return primero.valor();
	}

	public E ultimo() {
		return ultimo.valor();
	}

	@Override
		public void insertarPrimero(E valor) {
			if (estaVacia()) {
				primero = new Nodo(valor, null);
				ultimo = primero;
			}
	
			else {
				Nodo<E> f = primero;
				primero = new Nodo<>(valor, f);
			}
	
			tamano++;
		}
	
		@Override
		public void insertarFinal(E valor) {
			if (estaVacia()) {
				ultimo = new Nodo(valor, null);
				primero = ultimo;
			} else {
	
				Nodo<E> temp = ultimo;
	
				ultimo = new Nodo(valor, null);

				temp.insertar(ultimo);
			}
	
			tamano++;
		}
	
		@Override
		public E buscar(int indice) throws RuntimeException {
	
			int cont = 0;
	
			if (indice >= tamano)
				throw new RuntimeException("Desborde: " + indice);
	
			Nodo<E> actual = primero;
	
			while (cont < indice) {
				actual = actual.siguiente();
				cont++;
			}
	
			return actual.valor();
	
		}
	
		@Override
		public E eliminar(int indice) throws RuntimeException{
	
			if(indice >= tamano) throw new RuntimeException("Desborde: " + indice);
	
			Nodo<E> anterior = null;
			Nodo<E> aEliminar = null;
			
			if(indice == 0) {				
				aEliminar = primero;
				primero = primero.siguiente();
		
			}
	
			else {
	
				int cont = 0;
	
				anterior = primero;
	
				while(cont < indice - 1) {
					anterior = anterior.siguiente();
					cont++;
				}
	
				aEliminar = anterior.siguiente();
	
				anterior.insertar(aEliminar.siguiente());	
	
			}
			
			tamano--;
			
			return aEliminar.valor();
	
		}

		public ListaEncadenada clonar(Object[] arr){

			ListaEncadenada nueva = new ListaEncadenada();

			for (int i = 0; i < arr.length ; i++) {

				nueva.insertarFinal(arr[i]);

			}
			return nueva;
		}


	@Override
	public int tamano() {
		return tamano;
	}
	
	@Override
	public boolean estaVacia() {
		return primero == null;
	}
	
	private class ListaIterador implements IListaIterador<E> {
	
		private Nodo<E> actual;
	
		ListaIterador() {
			actual = null;
		}
	
		@Override
		public E siguiente() {
	
			if (actual == null) {
				actual = primero;
			}
	
			else {
	
				if(actual.haySiguiente()) actual = actual.siguiente();
	
			}
	
			return (actual != null) ? actual.valor() : null;
		}
	
		public boolean haySiguiente() {
	
			if(primero == null) return false;
			
			return (actual == null) ? true : actual.haySiguiente();
		}
	
	}
	
	public IListaIterador<E> iterador() {
		return new ListaIterador();
	}
	
	}
