package br.unisinos.edu.dev2.covid.designpatterns.api.repository;

import br.unisinos.edu.dev2.covid.designpatterns.api.entity.CasoCovid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasosCovidRepository extends JpaRepository<CasoCovid, Long> {
}
