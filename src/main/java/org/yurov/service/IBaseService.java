package org.yurov.service;

import org.springframework.stereotype.Service;
import org.yurov.model.Base;

import java.util.List;

@Service
public interface IBaseService {
    //отображаем все
    List<Base> findAll();

    //ищем по id
    Base findById(Long id);

    //сохраняем в бд
    Base saveBase(Base base);

    //удаляем из БД
    void deleteById(Long id);

    //ищем по владельцу
    List<Base> findByOwner(String owner);

    //ищем по имени базы
    List<Base> findByBaseName(String baseName);
}
