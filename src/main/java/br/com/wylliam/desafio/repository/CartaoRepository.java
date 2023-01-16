package br.com.wylliam.desafio.repository;

import br.com.wylliam.desafio.domain.entity.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, String> {


}
