package Implementaciones;

public class Nodo {
    String tarea;
    int prioridad;
    Nodo siguiente;
    Nodo anterior;
    public Nodo(String tarea, int prioridad){
        this.siguiente=null;
        this.anterior=null;
        this.prioridad=prioridad;
        this.tarea=tarea;
    }
}
