package com.alura.forohub.dto;

import com.alura.forohub.model.StatusTopico;

public record ActualizarTopicoDTO(
        String titulo,
        String mensaje,
        StatusTopico status
) {}
