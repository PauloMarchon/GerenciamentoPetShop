package br.com.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petshop.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    

}
