import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Elemento {
    double peso;
    double valor;
    double valorPorPeso;

    public Elemento(double peso, double valor) {
        this.peso = peso;
        this.valor = valor;
        this.valorPorPeso = valor / peso;
    }
}

public class Main {

    public static double maximizarValor(List<Elemento> elementos, double capacidad) {
        // Ordenar elementos por valorPorPeso en orden descendente
        elementos.sort((a, b) -> Double.compare(b.valorPorPeso, a.valorPorPeso));

        double pesoActual = 0;
        double valorTotal = 0;

        for (Elemento e : elementos) {
            if (pesoActual + e.peso <= capacidad) {
                // Añadir el elemento completo
                pesoActual += e.peso;
                valorTotal += e.valor;
                System.out.println("Añadido: Peso = " + e.peso + ", Valor = " + e.valor);
            } else {
                // Añadir una fracción del elemento
                double fraccion = (capacidad - pesoActual) / e.peso;
                valorTotal += e.valor * fraccion;
                pesoActual += e.peso * fraccion;
                System.out.println("Añadido fracción: Peso = " + (e.peso * fraccion) + ", Valor = " + (e.valor * fraccion));
                break;
            }
        }

        return valorTotal;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        List<Elemento> elementos = new ArrayList<>();
        elementos.add(new Elemento(10, 60));  // peso = 10, valor = 60
        elementos.add(new Elemento(20, 100)); // peso = 20, valor = 100
        elementos.add(new Elemento(30, 120)); // peso = 30, valor = 120

        double capacidad = 50;
        double valorMaximo = maximizarValor(elementos, capacidad);

        System.out.println("Valor total máximo: " + valorMaximo);
    }
}

//Input: Lista de elementos (peso, valor), capacidad del camión
//Output: Lista de elementos (completo o fraccionado) cargados en el camión, valor total

//1. Calcular valor_por_peso para cada elemento: valor / peso
//2. Ordenar los elementos por valor_por_peso en orden descendente
//3. Inicializar peso_actual = 0, valor_total = 0, lista_resultado vacía
//4. Para cada elemento en la lista ordenada:
//Si peso_actual + peso_elemento <= capacidad:
//Añadir el elemento completo al camión
//Actualizar peso_actual y valor_total
//Sino:
//Calcular la fracción que cabe
//Añadir esa fracción al camión
//Actualizar peso_actual y valor_total
//Terminar el bucle
//5. Retornar lista_resultado y valor_total
