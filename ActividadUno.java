package ClaseSeis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ActividadUno {

    private Map<String, Set<String>> listaAdyacencia;

    public ActividadUno() {
        this.listaAdyacencia = new HashMap<>();
    }

    // Agregar un nuevo usuario
    public void agregarUsuario(String usuario) {
        listaAdyacencia.putIfAbsent(usuario, new HashSet<>());
    }

    // Seguir a otro usuario
    public void seguir(String seguidor, String seguido) {
        if (listaAdyacencia.containsKey(seguidor) && listaAdyacencia.containsKey(seguido)) {
            listaAdyacencia.get(seguidor).add(seguido);
        } else {
            System.out.println("Uno o ambos usuarios no existen.");
        }
    }

    // Dejar de seguir a otro usuario
    public void dejarDeSeguir(String seguidor, String seguido) {
        if (listaAdyacencia.containsKey(seguidor) && listaAdyacencia.containsKey(seguido)) {
            listaAdyacencia.get(seguidor).remove(seguido);
        } else {
            System.out.println("Uno o ambos usuarios no existen.");
        }
    }

    // Obtener la lista de usuarios que sigue un usuario dado
    public void listarSeguidos(String usuario) {
        if (listaAdyacencia.containsKey(usuario)) {
            System.out.println(usuario + " sigue a: " + listaAdyacencia.get(usuario));
        } else {
            System.out.println("El usuario no existe.");
        }
    }

    // Obtener la lista de seguidores de un usuario
    public void listarSeguidores(String usuario) {
        if (!listaAdyacencia.containsKey(usuario)) {
            System.out.println("El usuario no existe.");
            return;
        }

        Set<String> seguidores = new HashSet<>();
        for (String u : listaAdyacencia.keySet()) {
            if (listaAdyacencia.get(u).contains(usuario)) {
                seguidores.add(u);
            }
        }
        System.out.println("Seguidores de " + usuario + ": " + seguidores);
    }

    public static void main(String[] args) {
        ActividadUno red = new ActividadUno();

        // Agregar usuarios
        red.agregarUsuario("Matias");
        red.agregarUsuario("Juan");
        red.agregarUsuario("Carlos");

        // Seguir usuarios
        red.seguir("Matias", "Juan");
        red.seguir("Juan", "Carlos");
        red.seguir("Carlos", "Matias");

        // Mostrar seguidores y seguidos
        red.listarSeguidos("Juan");
        red.listarSeguidores("Carlos");

        // Dejar de seguir
        red.dejarDeSeguir("Juan", "Carlos");
        red.listarSeguidos("Juan");
    }
    
}
