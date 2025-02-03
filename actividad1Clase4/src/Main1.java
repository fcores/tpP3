import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        // Lista de clientes
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Facundo", 85));
        clientes.add(new Cliente(2, "Lucía", 92));
        clientes.add(new Cliente(3, "Joaquín", 78));
        clientes.add(new Cliente(4, "Sofía", 97));
        clientes.add(new Cliente(5, "Martín", 88));

        // Encontrar el cliente con el mayor scoring
        Cliente mejorCliente = encontrarMaximoClientes(clientes, 0, clientes.size());
        System.out.println("Cliente con el mayor scoring: " + mejorCliente);
    }

    private static Cliente encontrarMaximoClientes(List<Cliente> listaClientes, int inicio, int fin) {
        if (inicio == fin - 1) {
            return listaClientes.get(inicio); // Caso base
        }

        int mitad = (inicio + fin) / 2;

        // Dividir y encontrar el máximo en ambas mitades
        Cliente maxIzq = encontrarMaximoClientes(listaClientes, inicio, mitad);
        Cliente maxDer = encontrarMaximoClientes(listaClientes, mitad, fin);

        // Combinar: devolver el cliente con el mayor scoring
        return (maxIzq.getScoring() >= maxDer.getScoring()) ? maxIzq : maxDer;
    }
}

// Clase Cliente
class Cliente {
    private int id;
    private String nombre;
    private int scoring;

    public Cliente(int id, String nombre, int scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }

    public int getScoring() {
        return scoring;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Scoring: " + scoring;
    }
}

//FUNCIÓN encontrarMaximoClientes(listaClientes, inicio, fin):
//    SI (inicio == fin - 1) ENTONCES
//        RETORNAR listaClientes[inicio]  // Caso base: un solo cliente en la lista
//
//    mitad <- (inicio + fin) DIV 2
//
//    // Dividir la lista en dos sublistas
//    maxIzq <- encontrarMaximoClientes(listaClientes, inicio, mitad)
//    maxDer <- encontrarMaximoClientes(listaClientes, mitad, fin)
//
//    // Combinar: comparar y retornar el cliente con mayor scoring
//    SI (maxIzq.scoring >= maxDer.scoring) ENTONCES
//        RETORNAR maxIzq
//    SINO
//        RETORNAR maxDer