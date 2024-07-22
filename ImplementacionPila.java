package Implementaciones;

import Interfaces.InterfazPila;

public class ImplementacionPila implements InterfazPila {
    NodoPila primero;
    public ImplementacionPila(){
        primero=null;
    }

    @Override
    public void apilar(String tarea) {
        NodoPila nuevo=new NodoPila();
        nuevo.tarea=tarea;
        nuevo.siguiente=primero;
        primero=nuevo;

    }

    @Override
    public void desapilar() {
        if(!estaVacia()) {
            primero = primero.siguiente;
        }

    }

    @Override
    public String tope() {
        if (!estaVacia()) {
            return primero.tarea;
        }
        return "Pila vacia";
    }

    @Override
    public boolean estaVacia() {
        return primero==null;
    }

    public void imprimirPila(){
        NodoPila actual=primero;
        while(actual!=null){
            System.out.println(actual.tarea);
            actual=actual.siguiente;
        }

    }
}
