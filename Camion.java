package ClaseUno.RepasoPOO;

public class Camion extends Vehiculo{

    private double capacidadDeCarga;

    public Camion(String matricula, String marca, String modelo, double capacidadDeCarga) {
        super(matricula, marca, modelo);
        this.capacidadDeCarga = capacidadDeCarga;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Capacidad de carga: " + capacidadDeCarga + " toneladas");
    }
    
}
