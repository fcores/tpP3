import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static List<Integer> obtenerComprobantesMinimos(List<Integer> comprobantes, int montoObjetivo) {
        // Crear una copia mutable de la lista de comprobantes
        List<Integer> comprobantesMutable = new ArrayList<>(comprobantes);

        // Ordenar los comprobantes en orden descendente
        Collections.sort(comprobantesMutable, Collections.reverseOrder());

        List<Integer> resultado = new ArrayList<>();
        int montoRestante = montoObjetivo;

        // Seleccionar comprobantes con un enfoque greedy
        for (int comprobante : comprobantesMutable) {
            while (montoRestante >= comprobante) {
                resultado.add(comprobante);
                montoRestante -= comprobante;
            }
        }

        // Verificar si se alcanzó el monto objetivo
        if (montoRestante == 0) {
            return resultado;
        } else {
            throw new IllegalArgumentException("No es posible alcanzar el monto objetivo con los comprobantes disponibles.");
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        List<Integer> comprobantes = List.of(100, 50, 20, 10, 5, 1);
        int montoObjetivo = 93;

        try {
            List<Integer> resultado = obtenerComprobantesMinimos(comprobantes, montoObjetivo);
            System.out.println("Comprobantes utilizados: " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
//Input: lista_de_comprobantes (valores de los comprobantes), monto_objetivo
//Output: conjunto de comprobantes utilizados para alcanzar el monto objetivo

//1. Ordenar lista_de_comprobantes en orden descendente
//2. Inicializar monto_restante = monto_objetivo
//3. Inicializar lista_resultado vacía
//4. Para cada comprobante en lista_de_comprobantes:
//Si monto_restante >= comprobante:
//Agregar comprobante a lista_resultado
//Restar comprobante de monto_restante
//5. Si monto_restante == 0:
//Retornar lista_resultado
//Sino:
//Retornar "No es posible alcanzar el monto objetivo con los comprobantes disponibles"