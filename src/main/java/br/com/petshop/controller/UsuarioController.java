package br.com.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.petshop.models.Usuario;
import br.com.petshop.repository.UsuarioRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public List<Usuario> exibeUsuarios(){
        return usuarioRepository.findAll();
    }
}
