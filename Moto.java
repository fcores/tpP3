package ClaseUno.RepasoPOO;

public class Moto extends Vehiculo{

    private String tipoDeMoto;

    public Moto(String matricula, String marca, String modelo, String tipoDeMoto) {
        super(matricula, marca, modelo);
        this.tipoDeMoto = tipoDeMoto;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tipo de moto: " + tipoDeMoto);
    }
    
}
