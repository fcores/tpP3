package tpoGrupo4.tpoGrupo4.entity;

import org.springframework.data.neo4j.core.schema.*;
import java.util.HashSet;
import java.util.Set;

@Node("Libro")
public class LibroEntity {

    @Id
    private final String titulo;

    @Property("tagline")
    private final String resumen;

    @Relationship(type = "ESCRITO_POR", direction = Relationship.Direction.OUTGOING)
    private Set<AutorEntity> autores = new HashSet<>();

    @Relationship(type = "PUBLICADO_POR", direction = Relationship.Direction.OUTGOING)
    private Set<EditorialEntity> editores = new HashSet<>();

    public LibroEntity(String titulo, String resumen) {
        this.titulo = titulo;
        this.resumen = resumen;
    }

    public String getTitulo() {
        return titulo;
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

    @Override
    public String toString() {
        return "LibroEntity{" +
                "titulo='" + titulo + '\'' +
                ", resumen='" + resumen + '\'' +
                ", autores=" + autores +
                ", editores=" + editores +
                '}';
    }
}
