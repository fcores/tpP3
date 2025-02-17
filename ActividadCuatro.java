package ClaseDoce;

import java.util.*;

class Usuario {
    int id;
    String nombre;

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

class RedSocial {
    private Map<Integer, Usuario> usuarios;
    private Map<Integer, List<Integer>> amistades;

    public RedSocial() {
        usuarios = new HashMap<>();
        amistades = new HashMap<>();
    }

    public void agregarUsuario(int id, String nombre) {
        usuarios.put(id, new Usuario(id, nombre));
        amistades.put(id, new ArrayList<>());
    }

    public void conectarUsuarios(int id1, int id2) {
        if (usuarios.containsKey(id1) && usuarios.containsKey(id2)) {
            amistades.get(id1).add(id2);
            amistades.get(id2).add(id1); // Relación bidireccional
        }
    }

    public void dfs(int inicio) {
        Set<Integer> visitados = new HashSet<>();
        List<String> recorrido = new ArrayList<>();
        dfsRecursivo(inicio, visitados, recorrido);
        System.out.println("Recorrido DFS: " + recorrido);
    }

    private void dfsRecursivo(int usuario, Set<Integer> visitados, List<String> recorrido) {
        visitados.add(usuario);
        recorrido.add(usuarios.get(usuario).nombre);

        for (int amigo : amistades.get(usuario)) {
            if (!visitados.contains(amigo)) {
                dfsRecursivo(amigo, visitados, recorrido);
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
            int usuario = cola.poll();
            recorrido.add(usuarios.get(usuario).nombre);

            for (int amigo : amistades.get(usuario)) {
                if (!visitados.contains(amigo)) {
                    visitados.add(amigo);
                    cola.add(amigo);
                }
            }
        }

        System.out.println("Recorrido BFS: " + recorrido);
    }
}

public class ActividadCuatro {
    public static void main(String[] args) {
        RedSocial red = new RedSocial();

        red.agregarUsuario(0, "Alice");
        red.agregarUsuario(1, "Bob");
        red.agregarUsuario(2, "Charlie");
        red.agregarUsuario(3, "David");
        red.agregarUsuario(4, "Emma");

        red.conectarUsuarios(0, 1);
        red.conectarUsuarios(0, 2);
        red.conectarUsuarios(1, 3);
        red.conectarUsuarios(2, 4);
        red.conectarUsuarios(3, 4);

        System.out.println("Exploración DFS desde Alice:");
        red.dfs(0);

        System.out.println("\nExploración BFS desde Alice:");
        red.bfs(0);
    }
}
