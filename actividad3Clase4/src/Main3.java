import java.util.ArrayList;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        // Lista de clientes
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Facundo", 85));
        clientes.add(new Cliente(2, "Lucía", 92));
        clientes.add(new Cliente(3, "Joaquín", 78));
        clientes.add(new Cliente(4, "Sofía", 97));
        clientes.add(new Cliente(5, "Martín", 88));

        // Encontrar los dos clientes con los máximos scoring
        Cliente[] mejoresClientes = encontrarDosMaximosClientes(clientes, 0, clientes.size());
        System.out.println("Primer cliente con mayor scoring: " + mejoresClientes[0]);
        System.out.println("Segundo cliente con mayor scoring: " + mejoresClientes[1]);
    }

    private static Cliente[] encontrarDosMaximosClientes(List<Cliente> listaClientes, int inicio, int fin) {
        if (inicio == fin - 1) {
            // Caso base: si hay solo un cliente, el segundo máximo es nulo
            return new Cliente[]{listaClientes.get(inicio), null};
        } else if (inicio == fin - 2) {
            // Caso base: si hay dos clientes, devolverlos en orden descendente
            Cliente c1 = listaClientes.get(inicio);
            Cliente c2 = listaClientes.get(inicio + 1);
            if (c1.getScoring() > c2.getScoring()) {
                return new Cliente[]{c1, c2};
            } else {
                return new Cliente[]{c2, c1};
            }
        }

        // Dividir la lista en dos mitades
        int mitad = (inicio + fin) / 2;
        Cliente[] maxIzq = encontrarDosMaximosClientes(listaClientes, inicio, mitad);
        Cliente[] maxDer = encontrarDosMaximosClientes(listaClientes, mitad, fin);

        // Combinar los resultados
        Cliente primerMaximo, segundoMaximo;

        if (maxIzq[0].getScoring() > maxDer[0].getScoring()) {
            primerMaximo = maxIzq[0];
            segundoMaximo = maxIzq[1] != null && maxIzq[1].getScoring() > maxDer[0].getScoring()
                    ? maxIzq[1]
                    : maxDer[0];
        } else {
            primerMaximo = maxDer[0];
            segundoMaximo = maxDer[1] != null && maxDer[1].getScoring() > maxIzq[0].getScoring()
                    ? maxDer[1]
                    : maxIzq[0];
        }

        return new Cliente[]{primerMaximo, segundoMaximo};
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