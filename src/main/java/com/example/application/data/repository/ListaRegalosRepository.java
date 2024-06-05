package com.example.application.data.repository;

import com.example.application.data.entity.ListaRegalos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
public interface ListaRegalosRepository extends JpaRepository<ListaRegalos, Long>, JpaSpecificationExecutor<ListaRegalos> {

}