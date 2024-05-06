package com.Springzada.API.repository;
import com.Springzada.API.model.FazendaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FazendaRepository extends JpaRepository<FazendaModel, Integer>{

    FazendaModel findByNome(String nome);

}
