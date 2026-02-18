package com.alura.forohub.controller;

import com.alura.forohub.dto.AutenticacionDTO;
import com.alura.forohub.dto.TokenDTO;
import com.alura.forohub.model.Usuario;
import com.alura.forohub.security.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@Tag(name = "Autenticación", description = "Endpoints para autenticación de usuarios")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Operation(summary = "Iniciar sesión y obtener JWT")
    public ResponseEntity<TokenDTO> login(@RequestBody @Valid AutenticacionDTO dto) {
        var authToken = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var autenticado = authenticationManager.authenticate(authToken);
        var token = tokenService.generarToken((Usuario) autenticado.getPrincipal());
        return ResponseEntity.ok(new TokenDTO(token));
    }
}
