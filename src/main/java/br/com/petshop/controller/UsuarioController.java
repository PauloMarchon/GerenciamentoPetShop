package br.com.petshop.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.petshop.manager.UsuarioManager;
import br.com.petshop.model.Usuario;
import br.com.petshop.repository.UsuarioRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8080")
public class UsuarioController {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioManager usuarioManager;

    @GetMapping("/usuarios")
    public List<Usuario> listaUsuarios(){
        return usuarioRepository.findAll();
    }

    @PostMapping("salvar")
    public @ResponseBody ResponseEntity<Usuario> salvar (@RequestBody @Validated Usuario usuario){
        return new ResponseEntity<Usuario>(usuarioManager.salvar(usuario), HttpStatus.CREATED);
    }

    @PutMapping("alterar")
    public @ResponseBody ResponseEntity<Usuario> alterar (@Valid @RequestBody Usuario usuario){
        return new ResponseEntity<Usuario>(usuarioManager.alterar(usuario), HttpStatus.OK);
    }

    @GetMapping("listar-todas")
    public @ResponseBody ResponseEntity<List<Usuario>> listarTodas(){
        return new ResponseEntity<List<Usuario>>(usuarioManager.todasContas(), HttpStatus.OK);
    }

    @DeleteMapping("excluir/{id}")
    public @ResponseBody ResponseEntity<?> excluir(@PathVariable Long id){
        usuarioManager.excluirConta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("validar-email/{email}")
    public @ResponseBody ResponseEntity<?> validaEmail(@PathVariable String email){
        Optional<Usuario> usuarioCadastrado = usuarioManager.contaEmail(email);
        if(usuarioCadastrado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
 
}
