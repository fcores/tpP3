

public class Main {

    // Tamaño del tablero
    private static final int SIZE = 6;
    private static final int SUBGRID_ROWS = 2;
    private static final int SUBGRID_COLS = 3;

    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 6, 0},
                {6, 0, 0, 3, 0, 2},
                {0, 6, 0, 0, 0, 4},
                {4, 0, 0, 0, 5, 0},
                {0, 0, 3, 6, 0, 0},
                {0, 5, 0, 0, 2, 1}
        };

        if (solveSudoku(board)) {
            printBoard(board);
        } else {
            System.out.println("No existe solución para este Sudoku.");
        }
    }

    // Método que resuelve el Sudoku usando backtracking
    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {  // Encuentra una celda vacía
                    for (int num = 1; num <= 6; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            // Recursivamente intenta resolver el tablero
                            if (solveSudoku(board)) {
                                return true;
                            }

                            // Deshacer el intento si falla
                            board[row][col] = 0;
                        }
                    }
                    return false;  // Si ningún número es válido, retrocede
                }
            }
        }
        return true;  // El tablero está completo y es válido
    }

    // Método para verificar si un número puede ser colocado en una posición
    private static boolean isValid(int[][] board, int row, int col, int num) {
        // Verificar si el número está en la fila
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Verificar si el número está en la columna
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Verificar si el número está en el subcuadrante 2x3
        int startRow = (row / SUBGRID_ROWS) * SUBGRID_ROWS;
        int startCol = (col / SUBGRID_COLS) * SUBGRID_COLS;
        for (int i = 0; i < SUBGRID_ROWS; i++) {
            for (int j = 0; j < SUBGRID_COLS; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;  // Si pasa todas las pruebas, es válido
    }

    // Método para imprimir el tablero
    private static void printBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
