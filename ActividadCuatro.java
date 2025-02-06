package ClaseSeis;

import java.util.*;

class ActividadCuatro {
    private Map<String, List<Arista>> listaAdyacencia;

    public ActividadCuatro() {
        this.listaAdyacencia = new HashMap<>();
    }

    // Agregar un centro de distribución (vértice)
    public void agregarCentro(String centro) {
        listaAdyacencia.putIfAbsent(centro, new ArrayList<>());
    }

    // Agregar una carretera (arista ponderada con tiempo en minutos)
    public void agregarRuta(String origen, String destino, int tiempo) {
        if (!listaAdyacencia.containsKey(origen) || !listaAdyacencia.containsKey(destino)) {
            System.out.println("Uno o ambos centros no existen.");
            return;
        }
        listaAdyacencia.get(origen).add(new Arista(destino, tiempo));
        listaAdyacencia.get(destino).add(new Arista(origen, tiempo)); // Grafo no dirigido
    }

    // Algoritmo de Dijkstra para encontrar la ruta más corta
    public void dijkstra(String inicio) {
        if (!listaAdyacencia.containsKey(inicio)) {
            System.out.println("El centro de inicio no existe.");
            return;
        }

        Map<String, Integer> distancia = new HashMap<>();
        PriorityQueue<Arista> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.tiempo));

        // Inicializar todas las distancias como infinito
        for (String ciudad : listaAdyacencia.keySet()) {
            distancia.put(ciudad, Integer.MAX_VALUE);
        }

        // Distancia al inicio es 0
        distancia.put(inicio, 0);
        pq.add(new Arista(inicio, 0));

        while (!pq.isEmpty()) {
            Arista actual = pq.poll();
            String ciudad = actual.destino;

            if (actual.tiempo > distancia.get(ciudad)) {
                continue; // Ignorar rutas que no sean óptimas
            }

            // Revisar los vecinos
            for (Arista vecino : listaAdyacencia.get(ciudad)) {
                int nuevaDistancia = distancia.get(ciudad) + vecino.tiempo;

                if (nuevaDistancia < distancia.get(vecino.destino)) {
                    distancia.put(vecino.destino, nuevaDistancia);
                    pq.add(new Arista(vecino.destino, nuevaDistancia));
                }
            }
        }

        // Mostrar los resultados
        System.out.println("\nTiempo mínimo desde " + inicio + " a cada centro:");
        for (Map.Entry<String, Integer> entry : distancia.entrySet()) {
            System.out.println("Centro: " + entry.getKey() + " - Tiempo: " + entry.getValue() + " minutos");
        }
    }

    public static void main(String[] args) {
        ActividadCuatro logistica = new ActividadCuatro();

        // Agregar centros de distribución (vértices)
        logistica.agregarCentro("A");
        logistica.agregarCentro("B");
        logistica.agregarCentro("C");
        logistica.agregarCentro("D");
        logistica.agregarCentro("E");

        // Agregar rutas (aristas con tiempos)
        logistica.agregarRuta("A", "B", 10);
        logistica.agregarRuta("A", "C", 15);
        logistica.agregarRuta("B", "D", 12);
        logistica.agregarRuta("B", "C", 5);
        logistica.agregarRuta("C", "E", 10);
        logistica.agregarRuta("D", "E", 2);

        // Ejecutar el algoritmo de Dijkstra desde el centro principal "A"
        logistica.dijkstra("A");
    }
}

// Clase auxiliar para representar una arista ponderada (ruta con tiempo de viaje)
class Arista {
    String destino;
    int tiempo;

    public Arista(String destino, int tiempo) {
        this.destino = destino;
        this.tiempo = tiempo;
    }
}