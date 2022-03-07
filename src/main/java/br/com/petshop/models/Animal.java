package br.com.petshop.models;

import br.com.petshop.enums.TipoAnimal;
import lombok.Data;

@Data
public class Animal {

    private String nome;
    private TipoAnimal tipoAnimal;
    private String raca;
    private int idade;
    
    
}
