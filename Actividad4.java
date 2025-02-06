import java.math.BigInteger;

public class Actividad4 {
    public static long factorialLong(long numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos."); 
        } else if (numero == 0) {
            return 1;
        } else {
            return numero * factorialLong(numero - 1);
        }
    }

    public static BigInteger factorialInteger(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos.");
        }
        if (numero == 0) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(numero).multiply(factorialInteger(numero - 1));
    }

    public static void main(String[] args) {
        long numeroLong = 20;
        System.out.println("Factorial de " + numeroLong + " es: " + factorialLong(numeroLong));

        int numeroInteger = 50;
        System.out.println("Factorial de " + numeroInteger + " es: " + factorialInteger(numeroInteger));
        
    }
}
