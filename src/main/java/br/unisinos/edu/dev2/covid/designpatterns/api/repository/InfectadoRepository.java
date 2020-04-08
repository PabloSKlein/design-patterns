package br.unisinos.edu.dev2.covid.designpatterns.api.repository;

import br.unisinos.edu.dev2.covid.designpatterns.api.entity.Infectado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfectadoRepository extends JpaRepository<Infectado, Long> {
}
