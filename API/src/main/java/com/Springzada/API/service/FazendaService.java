package com.Springzada.API.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Springzada.API.model.FazendaModel;
import com.Springzada.API.repository.FazendaRepository;
import com.Springzada.API.dto.FazendaRespDTO;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Service
public class FazendaService {

    @Autowired
    private FazendaRepository repository;

    // Create a new Fazenda
    public FazendaModel saveFazenda(FazendaRespDTO fazenda) {

        var fazendaModel = new FazendaModel();
        BeanUtils.copyProperties(fazenda, fazendaModel);
        return repository.save(fazendaModel);

    }

    // Get all Fazendas
    public List<FazendaRespDTO> getFazendas() {

        return repository.findAll().stream().map(fazenda -> new FazendaRespDTO(fazenda.getNome(), fazenda.getArea())).toList();

    }

    // Get one Fazenda by name
    public FazendaModel getFazenda(String nome) {

        return repository.findByNome(nome);
        
    }

    // Edit one Fazenda by name
    public FazendaModel editFazenda(String nome, FazendaRespDTO fazenda) {

        var fazendaModel = repository.findByNome(nome);

        if (fazendaModel == null) {
            return null;
        }

        BeanUtils.copyProperties(fazenda, fazendaModel);
        return repository.save(fazendaModel);
    }

    // Delete one Fazenda by name
    public Boolean deleteFazenda(String nome) {

        var fazendaModel = repository.findByNome(nome);

        if (fazendaModel == null) {
            return false;
        }

        repository.delete(fazendaModel);
        return true;

    }

}
