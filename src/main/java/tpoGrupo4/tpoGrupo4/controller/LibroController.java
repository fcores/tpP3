package tpoGrupo4.tpoGrupo4.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tpoGrupo4.tpoGrupo4.entity.LibroEntity;
import tpoGrupo4.tpoGrupo4.repository.LibroRepository;

@RestController
@RequestMapping("/books")
public class LibroController {
    private final LibroRepository libroRepository;

    public LibroController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @PutMapping
    public Mono<LibroEntity> createOrUpdateBook(@RequestBody LibroEntity newBook) {
        return libroRepository.save(newBook);
    }

    @GetMapping(value = { "", "/" }, produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<LibroEntity> getBooks() {
        return libroRepository.findAll();
    }

    @DeleteMapping("/deleteAll")
    public Mono<Void> deleteAllBooks() {
        return libroRepository.deleteAllData();
    }
}
