import java.util.Scanner;

public class Actividad3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();

        System.out.print("Ingrese el tipo de operación (suma: +; resta: -; multiplicacion: *; division: /): ");
        char operacion = scanner.next().charAt(0);

        double resultado;
        boolean operacionValida = true;

        switch (operacion) {
            case '+':
                resultado = num1 + num2;
                break;
            case '-':
                resultado = num1 - num2;
                break;
            case '*':
                resultado = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    System.out.println("Error: No se puede dividir por cero.");
                    operacionValida = false;
                    resultado = 0;
                }
                break;
            default:
                System.out.println("Operación no válida.");
                operacionValida = false;
                resultado = 0;
        }

        if (operacionValida) {
            System.out.println("El resultado es: " + resultado);
        }

        scanner.close();
    }
}