package Implementacion;
import Interfaz.GrafoI;
import java.util.*;

public class Grafo implements GrafoI {
    private Map<Nodo, List<Nodo>> adyacencias;


    // Método para obtener el grafo transpuesto
    private Grafo obtenerTranspuesto() {
        Grafo transpuesto = new Grafo();
        transpuesto.inicializarGrafo();
        for (Nodo fuente : adyacencias.keySet()) {
            //Recorro cada nodo de mi lista de adyacencias
            transpuesto.agregarNodo(fuente);
            for (Nodo destino : adyacencias.get(fuente)) {
                //Recorro todos los destinos de cada uno de los nodos y agrego el camino contrario
                transpuesto.agregarArista(destino, fuente);
            }
        }
        return transpuesto;
    }

    // Busqueda en profundidad para visitar los nodos y almacenar el orden de finalización
    private void dfs(Nodo nodo, Set<Nodo> visitados, Stack<Nodo> pila) {
        visitados.add(nodo);
        for (Nodo vecino : adyacencias.get(nodo)) {
            //Recorro todos los nodos adyacentes al nodo que me pasaron
            if (!visitados.contains(vecino)) {
                //Si no visite el nodo vecino (nodo adyacente al nodo principal)
                dfs(vecino, visitados, pila);
            }
        }
        pila.push(nodo);
    }


    @Override
    public void inicializarGrafo() {
        adyacencias = new HashMap<>();
    }

    @Override
    public void agregarNodo(Nodo nodo) {
        adyacencias.putIfAbsent(nodo, new ArrayList<>());
    }

    @Override
    public void agregarArista(Nodo nodo1, Nodo nodo2) {
        adyacencias.putIfAbsent(nodo1, new ArrayList<>());
        adyacencias.putIfAbsent(nodo2, new ArrayList<>());
        adyacencias.get(nodo1).add(nodo2);

    }

    @Override
    public List<Grafo> encontrarSubgrafo() {
        Stack<Nodo> pila = new Stack<>();
        Set<Nodo> visitados = new HashSet<>();
        List<Grafo> subgrafos = new ArrayList<>();

        // Paso 1: Llenar la pila con el orden de finalización de los nodos
        for (Nodo nodo : adyacencias.keySet()) {
            if (!visitados.contains(nodo)) {
                dfs(nodo, visitados, pila);
            }
        }

        // Paso 2: Crear el grafo transpuesto
        Grafo transpuesto = obtenerTranspuesto();

        // Paso 3: Usar la pila para hacer DFS en el grafo transpuesto
        visitados.clear();

        while (!pila.isEmpty()) {
            Nodo nodo = pila.pop();
            if (!visitados.contains(nodo)) {
                Stack<Nodo> componente = new Stack<>();
                transpuesto.dfs(nodo, visitados, componente);

                if (componente.size() > 1) {  // Solo crea subgrafos para componentes de tamaño mayor a 1
                    Grafo subgrafo = new Grafo();
                    subgrafo.inicializarGrafo();
                    for (Nodo n : componente) {
                        subgrafo.agregarNodo(n);
                        for (Nodo vecino : transpuesto.adyacencias.get(n)) {
                            if (componente.contains(vecino)) {
                                subgrafo.agregarArista(n, vecino);
                            }
                        }
                    }
                    subgrafos.add(subgrafo);
                }
            }
        }

        return subgrafos;


    }
    @Override
    public void imprimirGrafo() {
        for (Map.Entry<Nodo, List<Nodo>> entry : adyacencias.entrySet()) {
            System.out.print("Nodo " + entry.getKey().getInfo() + " -> ");
            for (Nodo nodo : entry.getValue()) {
                System.out.print(nodo.getInfo() + ", ");
            }
            System.out.println();
        }
    }
}
