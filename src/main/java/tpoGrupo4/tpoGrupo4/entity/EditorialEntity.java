package tpoGrupo4.tpoGrupo4.entity;

import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Id;

@Node("Editorial")
public class EditorialEntity {

    @Id
    private String nombre;

    public EditorialEntity() {}

    public EditorialEntity(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "EditorialEntity{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
