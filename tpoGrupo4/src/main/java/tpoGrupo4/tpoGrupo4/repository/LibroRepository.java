package tpoGrupo4.tpoGrupo4.repository;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import reactor.core.publisher.Mono;
import tpoGrupo4.tpoGrupo4.entity.LibroEntity;

public interface LibroRepository extends ReactiveNeo4jRepository<LibroEntity,Long> {
    Mono<LibroEntity> findOneByTitulo(String titulo);

    @Query("MATCH (n) DETACH DELETE n")
    Mono<Void> deleteAllData();

}
