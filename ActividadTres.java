package ClaseSeis;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class ActividadTres {

    private Map<String, List<Arista>> listaAdyacencia;

    public ActividadTres() {
        this.listaAdyacencia = new HashMap<>();
    }

    // Agregar una estación (vértice)
    public void agregarEstacion(String estacion) {
        listaAdyacencia.putIfAbsent(estacion, new ArrayList<>());
    }

    // Agregar una línea eléctrica (arista ponderada)
    public void agregarConexion(String origen, String destino, int costo) {
        listaAdyacencia.get(origen).add(new Arista(origen, destino, costo));
        listaAdyacencia.get(destino).add(new Arista(destino, origen, costo)); // Grafo no dirigido
    }

    // Algoritmo de Prim para encontrar el Árbol de Recubrimiento Mínimo
    public void prim(String inicio) {
        PriorityQueue<Arista> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.costo));
        Set<String> visitados = new HashSet<>();
        List<Arista> resultado = new ArrayList<>();
        int costoTotal = 0;

        visitados.add(inicio);
        pq.addAll(listaAdyacencia.get(inicio));

        while (!pq.isEmpty() && visitados.size() < listaAdyacencia.size()) {
            Arista arista = pq.poll();

            if (!visitados.contains(arista.destino)) {
                visitados.add(arista.destino);
                resultado.add(arista);
                costoTotal += arista.costo;

                // Agregar nuevas conexiones del nodo recién visitado
                for (Arista adj : listaAdyacencia.get(arista.destino)) {
                    if (!visitados.contains(adj.destino)) {
                        pq.add(adj);
                    }
                }
            }
        }

        // Mostrar el resultado
        System.out.println("Conexiones del Árbol de Recubrimiento Mínimo:");
        for (Arista a : resultado) {
            System.out.println(a.origen + " - " + a.destino + " (Costo: " + a.costo + ")");
        }
        System.out.println("Costo total de instalación: " + costoTotal);
    }

    public static void main(String[] args) {
        ActividadTres redElectrica = new ActividadTres();

        // Agregar estaciones eléctricas (vértices)
        redElectrica.agregarEstacion("A");
        redElectrica.agregarEstacion("B");
        redElectrica.agregarEstacion("C");
        redElectrica.agregarEstacion("D");
        redElectrica.agregarEstacion("E");

        // Agregar conexiones (aristas con costos)
        redElectrica.agregarConexion("A", "B", 10);
        redElectrica.agregarConexion("A", "C", 20);
        redElectrica.agregarConexion("B", "C", 30);
        redElectrica.agregarConexion("B", "D", 5);
        redElectrica.agregarConexion("C", "D", 15);
        redElectrica.agregarConexion("C", "E", 6);
        redElectrica.agregarConexion("D", "E", 8);

        // Ejecutar el algoritmo de Prim desde la estación "A"
        redElectrica.prim("A");
    }
}

// Clase auxiliar para representar una arista ponderada
class Arista {
    String origen;
    String destino;
    int costo;

    public Arista(String origen, String destino, int costo) {
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
    }

}
