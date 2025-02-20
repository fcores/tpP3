package tpoGrupo4.tpoGrupo4.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Id;
import com.fasterxml.jackson.annotation.JsonProperty;

@Node("Editorial")
public class EditorialEntity {

    @Id
    @GeneratedValue
    private Long id;


    private String nombre;

    // Constructor vacío necesario para Jackson
    public EditorialEntity() {}

    public EditorialEntity(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

}
