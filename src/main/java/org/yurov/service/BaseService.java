package org.yurov.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yurov.model.Base;
import org.yurov.repository.BaseRepository;

import java.util.List;

@Service
@Slf4j
public class BaseService implements IBaseService {
    private final BaseRepository baseRepository;

    @Autowired
    public BaseService(BaseRepository baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public List<Base> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public Base findById(Long id) {
        return baseRepository.findById(id).orElse(null);
    }


    @Override
    public Base saveBase(Base base) {
        return baseRepository.save(base);
    }

    @Override
    public void deleteById(Long id) {
        baseRepository.deleteById(id);
    }

    @Override
    public List<Base> findByOwner(String owner) {
        return baseRepository.findByBaseOwner(owner);

    }
    @Override
    public List<Base> findByBaseName(String baseName) {
        return baseRepository.findAllByBaseName(baseName);
    }
}
