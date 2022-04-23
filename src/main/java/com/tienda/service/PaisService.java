
package com.tienda.service;

import java.util.Optional;
import com.tienda.service.IPaisService;
import com.tienda.repository.PaisRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.tienda.entity.Pais;
import java.util.List;

@Service
public class PaisService implements IPaisService {

    @Autowired
    private PaisRepository paisRepository;

   
    @Override
    public List<Pais> listCountry() {
        return (List<Pais>) paisRepository.findAll();
    }


}
