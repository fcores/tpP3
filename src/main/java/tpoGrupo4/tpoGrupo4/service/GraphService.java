package tpoGrupo4.tpoGrupo4.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import tpoGrupo4.tpoGrupo4.entity.LibroEntity;
import tpoGrupo4.tpoGrupo4.repository.LibroRepository;

import java.util.*;

@Service
public class GraphService {

    private final LibroRepository libroRepository;
    private Map<String, List<String>> adjacencyList;

    public GraphService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
        this.adjacencyList = new HashMap<>();
    }

    /**
     * Carga la base de datos de Neo4j y la convierte en una lista de adyacencia.
     */
    public Mono<Void> loadGraph() {
        return libroRepository.findAll()
                .collectList()
                .doOnNext(libros -> {
                    adjacencyList.clear();
                    for (LibroEntity libro : libros) {
                        adjacencyList.putIfAbsent(libro.getTitulo(), new ArrayList<>());
                        for (var autor : libro.getAutores()) {
                            adjacencyList.computeIfAbsent(autor.getNombre(), k -> new ArrayList<>()).add(libro.getTitulo());
                            adjacencyList.get(libro.getTitulo()).add(autor.getNombre());
                        }
                        for (var editorial : libro.getEditores()) {
                            adjacencyList.computeIfAbsent(editorial.getNombre(), k -> new ArrayList<>()).add(libro.getTitulo());
                            adjacencyList.get(libro.getTitulo()).add(editorial.getNombre());
                        }
                    }
                }).then();
    }

    /**
     * Busca un camino entre dos nodos utilizando backtracking (DFS).
     */
    public Mono<List<String>> findPath(String start, String end) {
        return Mono.fromCallable(() -> {
            List<String> path = new ArrayList<>();
            Set<String> visited = new HashSet<>();
            if (backtrack(start, end, path, visited)) {
                return path;
            } else {
                return Collections.emptyList();
            }
        });
    }

    private boolean backtrack(String current, String target, List<String> path, Set<String> visited) {
        if (visited.contains(current)) return false;
        path.add(current);
        visited.add(current);
        if (current.equals(target)) return true;
        if (adjacencyList.containsKey(current)) {
            for (String neighbor : adjacencyList.get(current)) {
                if (backtrack(neighbor, target, path, visited)) return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }

    /**
     * Busca el camino más corto entre dos nodos utilizando BFS.
     */
    public Mono<List<String>> findPathBFS(String start, String end) {
        return Mono.fromCallable(() -> {
            Queue<List<String>> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            queue.add(Collections.singletonList(start));

            while (!queue.isEmpty()) {
                List<String> path = queue.poll();
                String lastNode = path.get(path.size() - 1);

                if (lastNode.equals(end)) return path;
                if (!visited.add(lastNode)) continue;

                for (String neighbor : adjacencyList.getOrDefault(lastNode, Collections.emptyList())) {
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(neighbor);
                    queue.add(newPath);
                }
            }
            return Collections.emptyList();
        });
    }
}
