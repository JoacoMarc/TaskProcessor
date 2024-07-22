package Interfaz;
import Implementacion.Grafo;
import Implementacion.Nodo;

import java.util.List;
import java.util.Set;
import java.util.Stack;

public interface GrafoI {

    public void inicializarGrafo();

    public void agregarNodo(Nodo nodo);

    public void agregarArista(Nodo nodo1, Nodo nodo2);

    public List<Grafo> encontrarSubgrafo();

    public void imprimirGrafo();
}
