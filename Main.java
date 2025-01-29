//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int n = 3; // Tamaño de las matrices cuadradas // 1
        int [][] mat1 = {{4,5,6},{7,8,9},{5,6,7}}; // 1
        int [][] mat2 = {{4,35,38},{7,48,8},{5,6,8}}; // 1
        int [][] matR; // n´2
        matR = multiplicarMatriz(mat1,mat2,n);
        // Mostrar el resultado
        System.out.println("Matriz resultado:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matR[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static int[][] multiplicarMatriz(int [][] mat1,int [][]mat2,int n){
        int [][] matR = new int[n][n]; // 1
        // Multiplicación de matrices
        for (int i = 0; i < n; i++) { // Recorre las filas de A // 1 + (N+1) +2N // PORQUE LA SUMA Y LA ASIGNACION SON DOS OPERACIONES
            for (int j = 0; j <n; j++) { // Recorre las columnas de B // 1 + (N+1) + N
                for (int k = 0; k < n; k++) { // Realiza el producto escalar // 1 + (N+1) + N
                    matR[i][j] += mat1[i][k] * mat2[k][j]; // 3N
                }
            }
        // 2+3N + N( 2+3N + N(2+3N +3N))
        // 2 + 3N + 2N + 3N´2 + N´2(2+3N + 3N) =
        // 2 + 3N + 2N + 3N´2 + 2N´2 + 3N´3 + 3N´3
        // 2 + 5N + 5N´2 + 6N´3
        // f(n) = 2 + 5N'2 + 6N´3
        // Demostracion
        // 2 + 5N'2 + 6N´3 <= c x n´3
        // 2/N´3 + 5/N + 6 <= c
        // si n =1
        // 2 + 5 + 6 <= c
        // c =18
        // f(n) = 2 + 5N'2 + 6N´3 pertenece a O(n´3) para c= 18 y n0=1
        }return matR; //1

    }


}