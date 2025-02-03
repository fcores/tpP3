import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main5 {
    public static void main(String[] args) {
        // Lista de corredores
        List<Corredor> corredores = new ArrayList<>();
        corredores.add(new Corredor("A", "Facundo", 85));
        corredores.add(new Corredor("B", "Lucía", 92));
        corredores.add(new Corredor("A", "Joaquín", 78));
        corredores.add(new Corredor("B", "Sofía", 97));
        corredores.add(new Corredor("A", "Martín", 88));

        // Encontrar los mejores tiempos por categoría
        Map<String, Corredor> mejoresPorCategoria = encontrarMejoresPorCategoria(corredores, 0, corredores.size());

        // Imprimir resultados
        for (Map.Entry<String, Corredor> entry : mejoresPorCategoria.entrySet()) {
            System.out.println("Categoría: " + entry.getKey() + ", Mejor Corredor: " + entry.getValue());
        }
    }

    private static Map<String, Corredor> encontrarMejoresPorCategoria(List<Corredor> corredores, int inicio, int fin) {
        if (inicio == fin - 1) {
            // Caso base: solo un corredor
            Map<String, Corredor> resultado = new HashMap<>();
            Corredor corredor = corredores.get(inicio);
            resultado.put(corredor.getCategoria(), corredor);
            return resultado;
        }

        // Dividir la lista en dos mitades
        int mitad = (inicio + fin) / 2;
        Map<String, Corredor> mejoresIzq = encontrarMejoresPorCategoria(corredores, inicio, mitad);
        Map<String, Corredor> mejoresDer = encontrarMejoresPorCategoria(corredores, mitad, fin);

        // Combinar resultados
        return combinarResultados(mejoresIzq, mejoresDer);
    }

    private static Map<String, Corredor> combinarResultados(Map<String, Corredor> izq, Map<String, Corredor> der) {
        Map<String, Corredor> combinados = new HashMap<>(izq);

        for (Map.Entry<String, Corredor> entry : der.entrySet()) {
            String categoria = entry.getKey();
            Corredor corredorDer = entry.getValue();

            if (combinados.containsKey(categoria)) {
                Corredor corredorIzq = combinados.get(categoria);
                if (corredorDer.getTiempo() < corredorIzq.getTiempo()) {
                    combinados.put(categoria, corredorDer);
                }
            } else {
                combinados.put(categoria, corredorDer);
            }
        }

        return combinados;
    }
}

// Clase Corredor
class Corredor {
    private String categoria;
    private String nombre;
    private int tiempo;

    public Corredor(String categoria, String nombre, int tiempo) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getTiempo() {
        return tiempo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Tiempo: " + tiempo;
    }
}