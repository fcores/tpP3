public class Actividad5 {
    public static int suma(int n) {
        if (n < 0) {//1
            throw new IllegalArgumentException("El número debe ser no negativo.");//1
        }
        if (n == 0) {//1
            return 0;//1
        }
        return n + suma(n - 1);//O(n)
    }

    //T(n)=a⋅T( n/b ) + f(n)
    //a=1
    //T(n/b) = T(n-1)
    //f(n) = O(1)
    //T(n) = T(n-1) + O(1)
    //T(n) = T(0) + n*O(1)

    public static void main(String[] args) {
        int num = 10;
        System.out.println("La suma de los primeros " + num + " números es: " + suma(num));
    }
}
