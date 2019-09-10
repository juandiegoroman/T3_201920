package model.data_structures;

public class Nodo<E> {

    private E valor;

    private Nodo<E> siguiente;

    Nodo(E elemento, Nodo<E> siguiente) {
        this.valor = elemento;
        this.siguiente = siguiente;
    }


    public Nodo<E> siguiente() {
        return siguiente;
    }

    public E valor() {
        return valor;
    }

    public void insertar(Nodo<E> nodo){
        siguiente = nodo;
    }

    public boolean haySiguiente(){

        return siguiente != null;
    }







}
