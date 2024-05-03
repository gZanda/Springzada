package com.Springzada.API.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Springzada.API.model.FazendaModel;
import com.Springzada.API.repository.FazendaRepository;
import com.Springzada.API.dto.FazendaRecord;
import org.springframework.beans.BeanUtils;

@Service
public class FazendaService {

    @Autowired
    private FazendaRepository repository;

    public FazendaModel saveFazenda(FazendaRecord fazenda) {
        var fazendaModel = new FazendaModel();
        BeanUtils.copyProperties(fazenda, fazendaModel);
        return repository.save(fazendaModel);
    }

}
