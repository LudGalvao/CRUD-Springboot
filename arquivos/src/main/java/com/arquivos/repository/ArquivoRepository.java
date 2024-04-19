package com.arquivos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arquivos.entity.Arquivo;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, String> {

}
