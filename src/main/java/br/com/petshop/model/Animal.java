package br.com.petshop.model;

import java.util.Date;

import javax.persistence.Entity;

import br.com.petshop.enums.PorteAnimal;
import br.com.petshop.enums.TipoAnimal;
import lombok.Data;

@Data
@Entity
public class Animal {

    private Long id;
    private String nome;
    private TipoAnimal tipoAnimal;
    private String raca;
    private PorteAnimal porteAnimal;
    private Date anoNascimento;
    private String descricao;
    
    
}
