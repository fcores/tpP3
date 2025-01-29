package ClaseUno.RepasoPOO;

import java.util.ArrayList;
import java.util.List;

public class GestionVehiculos {

    public static void main(String[] args) {
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        
        listaVehiculos.add(new Auto("ABC123", "Toyota", "Corolla", 4));
        listaVehiculos.add(new Camion("XYZ789", "Volvo", "FH16", 20));
        listaVehiculos.add(new Moto("MNO456", "Honda", "CBR600", "Deportiva"));

        for (Vehiculo v : listaVehiculos) {
            v.mostrarInformacion();
            System.out.println("--------------------");
        }
    }
    
}
