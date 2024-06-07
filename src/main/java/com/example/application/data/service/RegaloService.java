package com.example.application.data.service;
import com.example.application.data.entity.Regalo;
import com.example.application.data.repository.RegaloRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegaloService {
    private final RegaloRepository regaloRepository;

    public RegaloService(RegaloRepository regaloRepository) {
        this.regaloRepository = regaloRepository;
    }

    public List<Regalo> findAll() {
        return regaloRepository.findAll();
    }
    public long count() {
        return regaloRepository.count();
    }
    public void delete(Regalo regalo) {
        regaloRepository.delete(regalo);
    }
    public void save(Regalo regalo) {
        if (regalo == null) {
            System.err.println("Regalo is null");
            return;
        }
        regaloRepository.save(regalo);
    }
    public Regalo findByID(Long id) {
        return regaloRepository.findById(id).orElse(null);
    }
}
