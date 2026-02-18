package com.alura.forohub.model;

import com.alura.forohub.dto.ActualizarTopicoDTO;
import com.alura.forohub.dto.RegistrarTopicoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private StatusTopico status;

    private Boolean activo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Topico(RegistrarTopicoDTO dto, Usuario autor, Curso curso) {
        this.titulo = dto.titulo();
        this.mensaje = dto.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.status = StatusTopico.ABIERTO;
        this.activo = true;
        this.autor = autor;
        this.curso = curso;
    }

    public void actualizar(ActualizarTopicoDTO dto) {
        if (dto.titulo() != null) this.titulo = dto.titulo();
        if (dto.mensaje() != null) this.mensaje = dto.mensaje();
        if (dto.status() != null) this.status = dto.status();
    }

    public void eliminar() {
        this.activo = false;
    }
}
