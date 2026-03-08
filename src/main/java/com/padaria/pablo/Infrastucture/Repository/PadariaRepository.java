package com.padaria.pablo.Infrastucture.Repository;

import com.padaria.pablo.Infrastucture.Entitys.Padaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PadariaRepository extends JpaRepository<Padaria, Long> {
}
