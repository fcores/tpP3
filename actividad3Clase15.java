import java.util.*;

class Sucursal {
    String nombre;
    int monto; // Positivo para cobro, negativo para pago

    public Sucursal(String nombre, int monto) {
        this.nombre = nombre;
        this.monto = monto;
    }
}

public class Main {
    public static void main(String[] args) {
        // Definir el saldo inicial del cobrador
        int saldoInicial = 100;

        // Lista de sucursales con cobros (+) y pagos (-)
        List<Sucursal> sucursales = Arrays.asList(
                new Sucursal("Sucursal A", 50),
                new Sucursal("Sucursal B", -30),
                new Sucursal("Sucursal C", 70),
                new Sucursal("Sucursal D", -50),
                new Sucursal("Sucursal E", 20),
                new Sucursal("Sucursal F", -20)
        );

        // Ejecutar el recorrido óptimo
        realizarRecorrido(saldoInicial, sucursales);
    }

    public static void realizarRecorrido(int saldo, List<Sucursal> sucursales) {
        PriorityQueue<Sucursal> cola = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.monto, a.monto) // Ordenar por monto descendente
        );

        cola.addAll(sucursales); // Agregar todas las sucursales a la cola de prioridad

        System.out.println("Recorrido óptimo:");
        while (!cola.isEmpty()) {
            Sucursal mejorOpcion = null;

            // Buscar la mejor opción sin que el saldo se vuelva negativo
            for (Sucursal s : cola) {
                if (saldo + s.monto >= 0) {
                    mejorOpcion = s;
                    break;
                }
            }

            // Si no hay opción válida, detener el recorrido
            if (mejorOpcion == null) {
                System.out.println("No se puede continuar, saldo insuficiente.");
                break;
            }

            // Realizar la transacción y actualizar el saldo
            saldo += mejorOpcion.monto;
            System.out.println("Visita: " + mejorOpcion.nombre + " (Monto: " + mejorOpcion.monto + ") - Saldo Actual: " + saldo);

            // Eliminar la sucursal visitada
            cola.remove(mejorOpcion);
        }
    }
}
