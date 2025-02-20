package tpoGrupo4.tpoGrupo4.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.neo4j.core.schema.*;

import java.util.HashSet;
import java.util.Set;

@Node("Libro")
public class LibroEntity {
    @Id
    @GeneratedValue
    private Long isbn;

    @JsonProperty("Titulo")
    private final String titulo;

    private final String resumen;

    @Relationship(type = "ESCRITO_POR", direction = Relationship.Direction.OUTGOING)
    private Set<AutorEntity> autores = new HashSet<>();

    @Relationship(type = "PUBLICADO_POR", direction = Relationship.Direction.OUTGOING)
    @JsonProperty("editores")
    private Set<EditorialEntity> editores = new HashSet<>();

    public Long getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "LibroEntity{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", resumen='" + resumen + '\'' +
                ", autor=" + autores +
                ", editores=" + editores +
                '}';
    }

    public String getResumen() {
        return resumen;
    }

    public Set<AutorEntity> getAutores() {
        return autores;
    }

    public void setAutores(Set<AutorEntity> autores) {
        this.autores = autores;
    }

    public Set<EditorialEntity> getEditores() {
        return editores;
    }

    public void setEditores(Set<EditorialEntity> editores) {
        this.editores = editores;
    }

    public LibroEntity(String titulo, String resumen) {
        this.titulo = titulo;
        this.resumen = resumen;
    }


}