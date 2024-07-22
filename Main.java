import Implementacion.Nodo;
import Implementacion.Grafo;

import javax.xml.transform.Source;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Nodo n1 = new Nodo("n1");
        Nodo n2 = new Nodo("n2");
        Nodo n3 = new Nodo("n3");
        Nodo n4 = new Nodo("n4");
        Nodo n5 = new Nodo("n5");
        Nodo n6 = new Nodo("n6");

        Grafo g1 = new Grafo();
        g1.inicializarGrafo();

        //g1.imprimirGrafo();

        g1.agregarArista(n1, n2);
        g1.agregarArista(n1, n3);
        g1.agregarArista(n3, n1);
        g1.agregarArista(n2, n4);
        g1.agregarArista(n2, n5);
        g1.agregarArista(n2, n6);
        g1.agregarArista(n4, n2);


        g1.imprimirGrafo();


        List<Grafo> subgrafos = g1.encontrarSubgrafo();

        System.out.println("Cantidad de subgrafos: " + subgrafos.size());
        int i = 1;
        for (Grafo subgrafo : subgrafos) {
            System.out.println("Subgrafo: " + i);
            subgrafo.imprimirGrafo();
            i++;
        }

    }
}