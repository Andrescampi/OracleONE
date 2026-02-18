package com.alura.forohub.service;

import com.alura.forohub.dto.*;
import com.alura.forohub.exception.ValidacionException;
import com.alura.forohub.model.Topico;
import com.alura.forohub.model.Usuario;
import com.alura.forohub.model.Curso;
import com.alura.forohub.repository.CursoRepository;
import com.alura.forohub.repository.TopicoRepository;
import com.alura.forohub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public DetalleTopicoDTO registrar(RegistrarTopicoDTO dto) {
        // Validar duplicados
        if (topicoRepository.existsByTitulo(dto.titulo())) {
            throw new ValidacionException("Ya existe un tópico con ese título");
        }
        if (topicoRepository.existsByMensaje(dto.mensaje())) {
            throw new ValidacionException("Ya existe un tópico con ese mensaje");
        }

        Usuario autor = usuarioRepository.findById(dto.autorId())
                .orElseThrow(() -> new ValidacionException("Autor no encontrado con id: " + dto.autorId()));

        Curso curso = cursoRepository.findById(dto.cursoId())
                .orElseThrow(() -> new ValidacionException("Curso no encontrado con id: " + dto.cursoId()));

        Topico topico = new Topico(dto, autor, curso);
        topicoRepository.save(topico);
        return new DetalleTopicoDTO(topico);
    }

    public Page<ListarTopicoDTO> listar(Pageable pageable) {
        return topicoRepository.findByActivoTrue(pageable).map(ListarTopicoDTO::new);
    }

    public DetalleTopicoDTO detalle(Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new ValidacionException("Tópico no encontrado con id: " + id));
        if (!topico.getActivo()) {
            throw new ValidacionException("Tópico no encontrado con id: " + id);
        }
        return new DetalleTopicoDTO(topico);
    }

    @Transactional
    public DetalleTopicoDTO actualizar(Long id, ActualizarTopicoDTO dto) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new ValidacionException("Tópico no encontrado con id: " + id));
        if (!topico.getActivo()) {
            throw new ValidacionException("Tópico no encontrado con id: " + id);
        }
        topico.actualizar(dto);
        return new DetalleTopicoDTO(topico);
    }

    @Transactional
    public void eliminar(Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new ValidacionException("Tópico no encontrado con id: " + id));
        topico.eliminar();
    }
}
