import java.util.*;

class Nodo {
    String nombre;
    double montoCripto; // Monto a cobrar (+) o pagar (-) en criptomonedas
    double precioCripto; // Precio actual de la criptomoneda en USD

    public Nodo(String nombre, double montoCripto, double precioCripto) {
        this.nombre = nombre;
        this.montoCripto = montoCripto;
        this.precioCripto = precioCripto;
    }

    public double valorEnUSD() {
        return montoCripto * precioCripto; // Conversión a USD
    }
}

public class Main {
    public static void main(String[] args) {
        // Definir el saldo inicial en criptomonedas y su precio en USD
        double saldoCripto = 5.0; // 5 criptomonedas iniciales
        double precioInicial = 200.0; // 1 cripto = 200 USD
        double saldoUSD = saldoCripto * precioInicial; // Conversión inicial

        // Lista de nodos con transacciones en cripto y precio de la cripto en USD
        List<Nodo> nodos = Arrays.asList(
                new Nodo("Nodo A", 3.0, 210.0),  // Cobro de 3 cripto, precio 210 USD
                new Nodo("Nodo B", -2.5, 190.0), // Pago de 2.5 cripto, precio 190 USD
                new Nodo("Nodo C", 4.0, 205.0),  // Cobro de 4 cripto, precio 205 USD
                new Nodo("Nodo D", -1.5, 195.0), // Pago de 1.5 cripto, precio 195 USD
                new Nodo("Nodo E", 2.0, 200.0)   // Cobro de 2 cripto, precio 200 USD
        );

        // Ejecutar el recorrido óptimo
        realizarRecorrido(saldoCripto, saldoUSD, nodos);
    }

    public static void realizarRecorrido(double saldoCripto, double saldoUSD, List<Nodo> nodos) {
        PriorityQueue<Nodo> cola = new PriorityQueue<>(
                (a, b) -> Double.compare(b.valorEnUSD(), a.valorEnUSD()) // Priorizar mayor valor en USD
        );

        cola.addAll(nodos); // Agregar nodos a la cola de prioridad

        System.out.println("Recorrido óptimo en criptomonedas:");
        while (!cola.isEmpty()) {
            Nodo mejorOpcion = null;

            // Buscar la mejor opción sin que el saldo cripto se vuelva negativo
            for (Nodo n : cola) {
                if (saldoCripto + n.montoCripto >= 0) {
                    mejorOpcion = n;
                    break;
                }
            }

            // Si no hay opción válida, detener el recorrido
            if (mejorOpcion == null) {
                System.out.println("No se puede continuar, saldo de criptomonedas insuficiente.");
                break;
            }

            // Realizar la transacción y actualizar el saldo
            saldoCripto += mejorOpcion.montoCripto;
            saldoUSD = saldoCripto * mejorOpcion.precioCripto; // Conversión a USD con nueva tasa

            System.out.println("Visita: " + mejorOpcion.nombre +
                    " (Monto en Cripto: " + mejorOpcion.montoCripto +
                    ", Precio: $" + mejorOpcion.precioCripto + " USD) - " +
                    "Saldo Cripto: " + saldoCripto +
                    ", Saldo en USD: $" + saldoUSD);

            // Eliminar el nodo visitado
            cola.remove(mejorOpcion);
        }
    }
}
