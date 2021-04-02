package com.departamentos.domain.etities;

import com.departamentos.enums.Uf;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "enderecos")
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bairro;
    private String cep;
    private String cidade;
    private String complemento;
    private String logradouro;
    private String numero;

    @Column(length = 2)
    @Enumerated(EnumType.STRING)
    private Uf uf;
}
