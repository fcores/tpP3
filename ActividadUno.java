package ClaseOnce;

public class ActividadUno {
    static final int N = 4;

    public static void main(String[] args) {
        char[][] tablero = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tablero[i][j] = '.';
            }
        }

        colocarReinas(tablero, 0, 0, 0);
    }

    static void colocarReinas(char[][] tablero, int fila, int col, int numReinas) {
        if (numReinas == 2) {
            imprimirTablero(tablero);
            return;
        }

        for (int i = fila; i < N; i++) {
            for (int j = (i == fila ? col : 0); j < N; j++) {
                if (esPosicionValida(tablero, i, j)) {
                    tablero[i][j] = 'Q';
                    colocarReinas(tablero, i, j + 1, numReinas + 1);
                    tablero[i][j] = '.';
                }
            }
        }
    }

    static boolean esPosicionValida(char[][] tablero, int fila, int col) {
        for (int i = 0; i < fila; i++) {
            if (tablero[i][col] == 'Q') return false;
        }

        for (int i = fila - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (tablero[i][j] == 'Q') return false;
        }
        for (int i = fila - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (tablero[i][j] == 'Q') return false;
        }

        return true;
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
