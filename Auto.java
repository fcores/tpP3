package ClaseUno.RepasoPOO;

public class Auto extends Vehiculo{

    private int cantidadDePuertas;

    public Auto(String matricula, String marca, String modelo, int cantidadDePuertas) {
        super(matricula, marca, modelo);
        this.cantidadDePuertas = cantidadDePuertas;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Puertas: " + cantidadDePuertas);
    }
    
}
