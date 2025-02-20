package tpoGrupo4.tpoGrupo4.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

public class AutorEntity {
    public Long getId() {
        return id;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private Integer nacimiento;

    public AutorEntity(String nombre, Integer nacimiento) {
        this.nombre = nombre;
        this.nacimiento = nacimiento;

    }

    @Override
    public String toString() {
        return "AutorEntity{" +
                "name='" + nombre + '\'' +
                ", born=" + nacimiento +
                '}';
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
    //Getters omitted
}
