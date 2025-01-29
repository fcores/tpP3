package ClaseUno.RepasoPOO;

public class Vehiculo {

    private String matricula;
    private String marca;
    private String modelo;

    public Vehiculo(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    public void mostrarInformacion() {
        System.out.println("Matrícula: " + matricula + ", Marca: " + marca + ", Modelo: " + modelo);
    }
    
}
