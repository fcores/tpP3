package tpoGrupo4.tpoGrupo4.entity;

import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Id;

@Node("Autor")
public class AutorEntity {

    @Id
    private String nombre;
    private Integer nacimiento;

    public AutorEntity(String nombre, Integer nacimiento) {
        this.nombre = nombre;
        this.nacimiento = nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Integer nacimiento) {
        this.nacimiento = nacimiento;
    }

    @Override
    public String toString() {
        return "AutorEntity{" +
                "nombre='" + nombre + '\'' +
                ", nacimiento=" + nacimiento +
                '}';
    }
}

