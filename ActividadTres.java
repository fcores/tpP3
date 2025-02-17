package ClaseOnce;

public class ActividadTres {
    static final int N = 4;
    
    public static void main(String[] args) {
        char[][] tablero = new char[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tablero[i][j] = '.';
            }
        }
        
        colocarComputadoras(tablero, 0, new boolean[N]);
    }

    static void colocarComputadoras(char[][] tablero, int fila, boolean[] colUsadas) {
        if (fila == N) {
            colocarImpresoras(tablero, 0, new boolean[N]);
            return;
        }

        for (int col = 0; col < N; col++) {
            if (!colUsadas[col]) {
                tablero[fila][col] = 'C';
                colUsadas[col] = true;
                colocarComputadoras(tablero, fila + 1, colUsadas);
                tablero[fila][col] = '.';
                colUsadas[col] = false;
            }
        }
    }

    static void colocarImpresoras(char[][] tablero, int fila, boolean[] colUsadas) {
        if (fila == N) {
            imprimirTablero(tablero);
            return;
        }

        for (int col = 0; col < N; col++) {
            if (!colUsadas[col] && tablero[fila][col] != 'C') {
                tablero[fila][col] = 'I';
                colUsadas[col] = true;
                colocarImpresoras(tablero, fila + 1, colUsadas);
                tablero[fila][col] = '.';
                colUsadas[col] = false;
            }
        }
    }

    static void imprimirTablero(char[][] tablero) {
        System.out.println("Solución encontrada:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
