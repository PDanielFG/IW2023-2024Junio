package com.example.application.data.repository;

import com.example.application.data.entity.Regalo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
public interface RegaloRepository extends JpaRepository<Regalo, Long>, JpaSpecificationExecutor<Regalo> {

}
