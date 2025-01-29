//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int [][] mat = {{4,5,6},{7,8,9},{5,6,7}};
        System.out.println(calcularPromedio(mat));

    }
    private static double calcularPromedio(int [][] mat){
        float cantidadElementos = 0; //1
        float suma = 0; //1

        for(int i=0;i< mat.length;i++) { //1+n+2n
            for (int j = 0; j < mat[i].length; j++) { // 3n +1
                suma = mat[i][j] + suma; // 3 n
                cantidadElementos++; //2n
            }
        }
        return suma/cantidadElementos; //2
    }// complejidad = 1 + 1 +3n + 1 + n (3n + 1 + 3n + 2n)
    //complejidad = 8n´2 + 5 n + 8
    // 8 n´2 + 5 n + 8 <= c n´2
    // 8 n´2/n´2 + 5n/n´2 + 8/n´2 <= c n´2/n´2
    // 8 + 5/n + 8/n´2 <= c
    // tanteo > n=1
    // 8 + 5 + 8 <= 21
    // f(n) pertenece a O(n´2) para c=21 y n0 = 1

}