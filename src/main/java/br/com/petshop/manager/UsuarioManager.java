package br.com.petshop.manager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import br.com.petshop.exception.DadosCadastradosException;
import br.com.petshop.model.Usuario;
import br.com.petshop.repository.UsuarioRepository;

@Component
public class UsuarioManager {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) throws DadosCadastradosException{
        try{
            return usuarioRepository.save(usuario);
        } catch (DataIntegrityViolationException e) {
            throw new DadosCadastradosException(e.getMessage());
        }
    }

    public Usuario alterar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> contaNome(String nome){
        return usuarioRepository.findByNome(nome);
    }

    public Optional<Usuario> contaEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public List<Usuario> todasContas(){
        return usuarioRepository.findAll();
    }

    public void excluirConta(Long idConta){
        usuarioRepository.deleteById(idConta);
    }
    
}
