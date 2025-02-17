package ClaseOnce;

import java.util.ArrayList;
import java.util.List;

public class ActividadDos {
    private static final int N = 4; // Tamaño de la habitación 4x4

    public static void main(String[] args) {
        List<int[][]> soluciones = new ArrayList<>();
        int[][] habitacion = new int[N][N];
        resolver(habitacion, 0, soluciones);

        
        int count = 1;
        for (int[][] solucion : soluciones) {
            System.out.println("Solución " + count + ":");
            imprimirHabitacion(solucion);
            count++;
        }
    }

    private static void resolver(int[][] habitacion, int fila, List<int[][]> soluciones) {
        if (fila == N) {
            soluciones.add(copiarHabitacion(habitacion));
            return;
        }

        for (int col = 0; col < N; col++) {
            if (esUbicacionValida(habitacion, fila, col)) {
                habitacion[fila][col] = 1; 
                resolver(habitacion, fila + 1, soluciones);
                habitacion[fila][col] = 2; 
                resolver(habitacion, fila + 1, soluciones);
                habitacion[fila][col] = 0; 
            }
        }
    }

    private static boolean esUbicacionValida(int[][] habitacion, int fila, int col) {
        for (int i = 0; i < fila; i++) {
            if (habitacion[i][col] != 0) {
                return false; 
            }
        }
        return true;
    }

    private static int[][] copiarHabitacion(int[][] habitacion) {
        int[][] copia = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(habitacion[i], 0, copia[i], 0, N);
        }
        return copia;
    }

    private static void imprimirHabitacion(int[][] habitacion) {
        for (int[] fila : habitacion) {
            for (int celda : fila) {
                System.out.print((celda == 1 ? "E" : celda == 2 ? "S" : ".") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
