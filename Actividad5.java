public class Actividad5 {
    public static int suma(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo.");
        }
        if (n == 0) {
            return 0;
        }
        return n + suma(n - 1);
    }

    public static void main(String[] args) {
        int num = 10;
        System.out.println("La suma de los primeros " + num + " números es: " + suma(num));
    }
}
