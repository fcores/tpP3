package ClaseDoce;

import java.util.*;

class Almacen {
    int id;
    String nombre;

    public Almacen(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

class Grafo {
    private Map<Integer, Almacen> almacenes;
    private Map<Integer, List<Integer>> adyacencia;

    public Grafo() {
        almacenes = new HashMap<>();
        adyacencia = new HashMap<>();
    }

    public void agregarAlmacen(int id, String nombre) {
        almacenes.put(id, new Almacen(id, nombre));
        adyacencia.put(id, new ArrayList<>());
    }

    public void conectarAlmacenes(int id1, int id2) {
        if (almacenes.containsKey(id1) && almacenes.containsKey(id2)) {
            adyacencia.get(id1).add(id2);
            adyacencia.get(id2).add(id1); // Grafo no dirigido
        }
    }

    public void dfs(int inicio) {
        Set<Integer> visitados = new HashSet<>();
        List<String> recorrido = new ArrayList<>();
        dfsRecursivo(inicio, visitados, recorrido);
        System.out.println("Recorrido DFS: " + recorrido);
    }

    private void dfsRecursivo(int nodo, Set<Integer> visitados, List<String> recorrido) {
        visitados.add(nodo);
        recorrido.add(almacenes.get(nodo).nombre);

        for (int vecino : adyacencia.get(nodo)) {
            if (!visitados.contains(vecino)) {
                dfsRecursivo(vecino, visitados, recorrido);
            }
        }
    }

    public void bfs(int inicio) {
        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> cola = new LinkedList<>();
        List<String> recorrido = new ArrayList<>();

        cola.add(inicio);
        visitados.add(inicio);

        while (!cola.isEmpty()) {
            int nodo = cola.poll();
            recorrido.add(almacenes.get(nodo).nombre);

            for (int vecino : adyacencia.get(nodo)) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }

        System.out.println("Recorrido BFS: " + recorrido);
    }
}

public class ActividadTres {
    public static void main(String[] args) {
        Grafo redAlmacenes = new Grafo();

        redAlmacenes.agregarAlmacen(0, "Almacén A");
        redAlmacenes.agregarAlmacen(1, "Almacén B");
        redAlmacenes.agregarAlmacen(2, "Almacén C");
        redAlmacenes.agregarAlmacen(3, "Almacén D");
        redAlmacenes.agregarAlmacen(4, "Almacén E");

        redAlmacenes.conectarAlmacenes(0, 1);
        redAlmacenes.conectarAlmacenes(0, 2);
        redAlmacenes.conectarAlmacenes(1, 3);
        redAlmacenes.conectarAlmacenes(2, 4);
        redAlmacenes.conectarAlmacenes(3, 4);

        System.out.println("Exploración DFS desde el Almacén A:");
        redAlmacenes.dfs(0);

        System.out.println("\nExploración BFS desde el Almacén A:");
        redAlmacenes.bfs(0);
    }
}
