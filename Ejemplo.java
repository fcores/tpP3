package ClaseSiete;

public class Ejemplo {

    public static void main(String[] args) {
        
        // creo la lista de peso
        
        int[] pesos = {2,3};

        // creo la lista de valores

        int[] valores = {3,4};

        // creo la variable de capacidad maxima

        int capacidadMaximaMochila = 4;

        // creo la varible del mejor valor

        int mejorValor = 0;

        // condicion

        if(pesos[0] <= capacidadMaximaMochila){
            mejorValor = valores[0];
        }

        if(pesos[1] <= capacidadMaximaMochila){
            mejorValor = Math.max(valores[1], mejorValor);
        }

        if (pesos[0] + pesos[1] <= capacidadMaximaMochila) {
            mejorValor = valores[0] + valores[1];
        }

        System.out.println("El valor máximo que se puede obtener es: " + mejorValor);
    }
    
}
