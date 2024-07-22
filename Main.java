import Implementaciones.ProcesadorTareas;
public class Main {
    public static void main(String[] args) {
        ProcesadorTareas ProcesadorTareas=new ProcesadorTareas();
        ProcesadorTareas.agregarTarea("hola",1);
        ProcesadorTareas.agregarTarea("chau",3);
        ProcesadorTareas.agregarTarea("arbol",9);
        ProcesadorTareas.agregarTarea("casa",5);
        ProcesadorTareas.comenzarTarea();
        ProcesadorTareas.comenzarTarea();
        ProcesadorTareas.comenzarTarea();

        ProcesadorTareas.completarTarea();
        ProcesadorTareas.listarTareasEnProgreso();
        System.out.println(" ");
        ProcesadorTareas.listarTareasPendientes();


    }
}