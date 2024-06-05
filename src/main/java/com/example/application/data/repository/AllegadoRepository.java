package com.example.application.data.repository;
import com.example.application.data.entity.Allegado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
public interface AllegadoRepository extends JpaRepository<Allegado, Long>, JpaSpecificationExecutor<Allegado>{
}
