package br.unisinos.edu.dev2.covid.designpatterns.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Data
public class CasoCovid {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCasoCovid;
    @Column
    private LocalDateTime dataRegistro;
    @OneToOne
    @MapsId
    private Infectado infectado;
    @ManyToOne
    @JoinColumn(name = "idLocalizacao", nullable = false)
    private Localizacao localizacao;
}
