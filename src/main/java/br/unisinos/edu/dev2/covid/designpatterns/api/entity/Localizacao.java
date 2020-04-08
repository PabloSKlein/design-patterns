package br.unisinos.edu.dev2.covid.designpatterns.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Localizacao {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idLocalizacao;
    @Column
    private String cidade;
    @Column
    private String bairro;
    @Column
    private String uf;
    @OneToMany(mappedBy = "localizacao")
    private List<CasoCovid> casosCovid;
}
