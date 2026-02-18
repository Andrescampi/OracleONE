package com.alura.forohub.controller;

import com.alura.forohub.dto.*;
import com.alura.forohub.service.TopicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
@Tag(name = "Tópicos", description = "CRUD de tópicos del foro")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Operation(summary = "Crear un nuevo tópico")
    public ResponseEntity<DetalleTopicoDTO> registrar(
            @RequestBody @Valid RegistrarTopicoDTO dto,
            UriComponentsBuilder uriBuilder) {

        DetalleTopicoDTO detalle = topicoService.registrar(dto);
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(detalle.id()).toUri();
        return ResponseEntity.created(uri).body(detalle);
    }

    @GetMapping
    @Operation(summary = "Listar todos los tópicos activos (paginado)")
    public ResponseEntity<Page<ListarTopicoDTO>> listar(
            @PageableDefault(size = 10, sort = "fechaCreacion") Pageable pageable) {
        return ResponseEntity.ok(topicoService.listar(pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener detalle de un tópico por ID")
    public ResponseEntity<DetalleTopicoDTO> detalle(@PathVariable Long id) {
        return ResponseEntity.ok(topicoService.detalle(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un tópico")
    public ResponseEntity<DetalleTopicoDTO> actualizar(
            @PathVariable Long id,
            @RequestBody ActualizarTopicoDTO dto) {
        return ResponseEntity.ok(topicoService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar (desactivar) un tópico")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        topicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
