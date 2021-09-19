package com.giraldo.parqueo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giraldo.parqueo.model.Costo;


@Repository
public interface CostoRepository extends JpaRepository<Costo, Long>{



}
