package Implementaciones;

public class ProcesadorTareas {

    ImplementacionCola cola=new ImplementacionCola();
    ImplementacionPila pila=new ImplementacionPila();

    public void agregarTarea(String tarea, int prioridad){
        cola.acolar(tarea,prioridad);
    }
    public void comenzarTarea(){
        pila.apilar(cola.primero());
        cola.desacolar();
    }
    public void completarTarea(){
        pila.desapilar();
    }
    public void listarTareasEnProgreso(){
        pila.imprimirPila();
    }
    public void listarTareasPendientes(){
        cola.imprimirCola();
    }

}
