import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = cargarDatos();
        System.out.println(obtenerMayores(numeros, 4));
    }

    private static ArrayList<Integer> obtenerMayores(ArrayList<Integer> numeros, int cantidad) {
        return obtenerMayores(numeros, cantidad, 0, numeros.size());
    }

    private static ArrayList<Integer> obtenerMayores(ArrayList<Integer> numeros, int cantidad, int inicio, int fin) {
        // Caso base: Si el intervalo tiene menos o igual elementos que la cantidad requerida
        if (fin - inicio <= cantidad) {
            ArrayList<Integer> sublista = new ArrayList<>(numeros.subList(inicio, fin));
            sublista.sort(Collections.reverseOrder());
            return sublista;
        }

        // Dividir la lista en dos mitades
        int mitad = (inicio + fin) / 2;

        // Resolver recursivamente las dos mitades
        ArrayList<Integer> izquierda = obtenerMayores(numeros, cantidad, inicio, mitad);
        ArrayList<Integer> derecha = obtenerMayores(numeros, cantidad, mitad, fin);

        // Combinar los resultados de las dos mitades
        return combinar(izquierda, derecha, cantidad);
    }

    private static ArrayList<Integer> combinar(ArrayList<Integer> izquierda, ArrayList<Integer> derecha, int cantidad) {
        ArrayList<Integer> resultado = new ArrayList<>();
        int i = 0, j = 0;

        // Combinar las dos listas ordenadas
        while (resultado.size() < cantidad && (i < izquierda.size() || j < derecha.size())) {
            if (j >= derecha.size() || (i < izquierda.size() && izquierda.get(i) >= derecha.get(j))) {
                resultado.add(izquierda.get(i));
                i++;
            } else {
                resultado.add(derecha.get(j));
                j++;
            }
        }

        return resultado;
    }

    private static ArrayList<Integer> cargarDatos() {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(12);
        numeros.add(20);
        numeros.add(10);
        numeros.add(15);
        numeros.add(8);
        numeros.add(25);
        numeros.add(30);
        return numeros;
    }
}