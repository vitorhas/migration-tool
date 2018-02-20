package com.vitorhas.migration.repository;

import com.vitorhas.migration.model.DocProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocProcessRepository extends JpaRepository<DocProcess, Integer> {

}
