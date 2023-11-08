package org.yurov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yurov.model.Base;

import java.util.List;

@Repository
public interface BaseRepository extends JpaRepository<Base,Long> {
    List<Base> findByBaseOwner(String owner);
    List<Base> findAllByBaseName(String baseName);
}
