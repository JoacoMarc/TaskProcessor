package Implementaciones;

import Interfaces.InterfazCola;

public class ImplementacionCola implements InterfazCola {
    Nodo primero;
    Nodo ultimo;
    public ImplementacionCola(){
        primero=null;
        ultimo=null;
    }


    @Override
    public void acolar(String tarea, int prioridad) {
       Nodo nuevo=new Nodo(tarea, prioridad);
       if (primero==null){
           primero=ultimo=nuevo;
       }else if(primero.prioridad<prioridad){
           nuevo.siguiente=primero;
           primero.anterior=nuevo;
           primero=nuevo;
       }
       else{
           Nodo actual=primero;
           while(actual.siguiente!=null && actual.siguiente.prioridad>=prioridad){
               actual=actual.siguiente;
           }
           nuevo.siguiente=actual.siguiente;
           if(actual.siguiente!=null){
               actual.siguiente.anterior=nuevo;
           }else{
               ultimo=nuevo;
           }
           actual.siguiente=nuevo;
           nuevo.anterior=actual;
       }

    }

    @Override
    public void desacolar() {
        if(!estaVacia()){
            primero=primero.siguiente;
            if(primero.siguiente!=null){
                primero.anterior=null;
            }
            else{
                ultimo=null;
            }
        }
    }

    @Override
    public boolean estaVacia() {
        return primero==null;
    }

    @Override
    public String primero() {
        if(!estaVacia()){
            return primero.tarea;
        }
        return "Cola vacia";
    }

    public void imprimirCola(){
        Nodo acutal=primero;
        while(acutal!=null){
            System.out.println(acutal.tarea);
            acutal=acutal.siguiente;
        }
    }
}
