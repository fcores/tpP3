package tpoGrupo4.tpoGrupo4.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;
import tpoGrupo4.tpoGrupo4.service.GraphService;

import java.util.*;

@RestController
@RequestMapping("/graph")
public class GraphController {

    private final GraphService graphService;

    @Autowired
    public GraphController(GraphService graphService) {
        this.graphService = graphService;
    }

    @PostMapping("/load")
    public Mono<ResponseEntity<String>> loadGraph() {
        return graphService.loadGraph()
                .thenReturn(ResponseEntity.ok("Graph loaded successfully"));
    }

    @GetMapping("/find-path")
    public Mono<ResponseEntity<List<String>>> findPath(@RequestParam String start, @RequestParam String end) {
        return graphService.findPath(start, end)
                .map(path -> path.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(path));
    }

    @GetMapping("/find-path-bfs")
    public Mono<ResponseEntity<List<String>>> findPathBFS(@RequestParam String start, @RequestParam String end) {
        return graphService.findPathBFS(start, end)
                .map(path -> path.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(path));
    }
}