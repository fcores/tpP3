

import java.util.*;

class Node {
    String name;
    int cost;

    public Node(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}

public class UCS {
    private final Map<String, List<Node>> graph = new HashMap<>();

    // Método para agregar conexiones al grafo
    public void addEdge(String from, String to, int cost) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.get(from).add(new Node(to, cost));
    }

    // Método para realizar la búsqueda UCS con rastreo de ruta
    public List<String> uniformCostSearch(String start, String goal) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        priorityQueue.add(new Node(start, 0));

        Map<String, Integer> costSoFar = new HashMap<>();
        costSoFar.put(start, 0);

        Map<String, String> cameFrom = new HashMap<>();
        cameFrom.put(start, null);

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            // Si alcanzamos el destino, reconstruimos la ruta
            if (current.name.equals(goal)) {
                return reconstructPath(cameFrom, goal, costSoFar.get(goal));
            }

            // Explorar vecinos
            for (Node neighbor : graph.getOrDefault(current.name, new ArrayList<>())) {
                int newCost = costSoFar.get(current.name) + neighbor.cost;

                if (!costSoFar.containsKey(neighbor.name) || newCost < costSoFar.get(neighbor.name)) {
                    costSoFar.put(neighbor.name, newCost);
                    cameFrom.put(neighbor.name, current.name);
                    priorityQueue.add(new Node(neighbor.name, newCost));
                }
            }
        }

        return null; // Retorna null si no hay camino posible
    }

    // Método para reconstruir la ruta óptima
    private List<String> reconstructPath(Map<String, String> cameFrom, String goal, int totalCost) {
        List<String> path = new ArrayList<>();
        String current = goal;

        while (current != null) {
            path.add(current);
            current = cameFrom.get(current);
        }

        Collections.reverse(path);
        System.out.println("El costo mínimo es: " + totalCost);
        return path;
    }

    public static void main(String[] args) {
        UCS ucs = new UCS();

        // Agregar conexiones (Ejemplo de rutas)
        ucs.addEdge("A", "B", 2);
        ucs.addEdge("A", "C", 4);
        ucs.addEdge("B", "C", 1);
        ucs.addEdge("B", "D", 7);
        ucs.addEdge("C", "E", 3);
        ucs.addEdge("D", "E", 1);

        // Ejecutar UCS
        String startCity = "A";
        String goalCity = "E";
        List<String> route = ucs.uniformCostSearch(startCity, goalCity);

        if (route != null) {
            System.out.println("Itinerario de escalas: " + String.join(" -> ", route));
        } else {
            System.out.println("No se encontró una ruta desde " + startCity + " hasta " + goalCity);
        }
    }
}
