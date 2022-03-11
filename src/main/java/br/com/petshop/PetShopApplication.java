package br.com.petshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.petshop.models.Usuario;
import br.com.petshop.repository.UsuarioRepository;

@SpringBootApplication
public class PetShopApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PetShopApplication.class, args);
	}

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario usuarioAdmin = Usuario.builder()
							.nome("admin")
							.email("admin@admin.com")
							.senha("admin")
							.build();

		usuarioRepository.save(usuarioAdmin);
	}


}
