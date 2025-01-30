package clase3;

public class QuickSort {

    // Método principal para realizar QuickSort utilizando Divide y Vencerás
    public static void quickSort(int[] arreglo, int bajo, int alto) {
        if (bajo < alto) {
            // Divide: Encuentra el índice de partición
            int indiceParticion = particion(arreglo, bajo, alto);

            // Vencer: Ordena recursivamente las dos subpartes del arreglo
            quickSort(arreglo, bajo, indiceParticion - 1); // Subarreglo izquierdo
            quickSort(arreglo, indiceParticion + 1, alto); // Subarreglo derecho
        }
    }

    // Método para particionar el arreglo
    private static int particion(int[] arreglo, int bajo, int alto) {
        int pivote = arreglo[alto]; // Se selecciona el último elemento como pivote
        int i = bajo - 1; // Índice del límite de elementos menores al pivote

        // Iterar sobre el subarreglo
        for (int j = bajo; j < alto; j++) {
            if (arreglo[j] <= pivote) {
                i++;
                intercambiar(arreglo, i, j); // Intercambia elementos
            }
        }

        // Coloca el pivote en su posición correcta
        intercambiar(arreglo, i + 1, alto);
        return i + 1; // Retorna el índice del pivote
    }

    // Método auxiliar para intercambiar dos elementos en el arreglo
    private static void intercambiar(int[] arreglo, int i, int j) {
        int temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
    }

    // Método principal para probar el QuickSort
    public static void main(String[] args) {
        int[] arreglo = {10, 7, 8, 9, 1, 5};
        System.out.println("Arreglo original:");
        imprimirArreglo(arreglo);

        // Ordenar el arreglo usando QuickSort
        quickSort(arreglo, 0, arreglo.length - 1);

        System.out.println("Arreglo ordenado:");
        imprimirArreglo(arreglo);
    }

    // Método para imprimir un arreglo
    private static void imprimirArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}