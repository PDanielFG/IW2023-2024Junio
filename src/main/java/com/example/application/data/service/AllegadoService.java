package com.example.application.data.repository;
import com.example.application.data.entity.Allegado;
import com.example.application.data.repository.AllegadoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AllegadoService {
    private final AllegadoRepository allegadoRepository;

    public AllegadoService(AllegadoRepository allegadoRepository) {
        this.allegadoRepository = allegadoRepository;
    }

    public List<Allegado> findAll() {
        return allegadoRepository.findAll();
    }
    public long count() {
        return allegadoRepository.count();
    }
    public void delete(Allegado allegado) {
        allegadoRepository.delete(allegado);
    }
    public void save(Allegado allegado) {
        if (allegado == null) {
            System.err.println("Regalo is null");
            return;
        }
        allegadoRepository.save(allegado);
    }
    public Allegado findByID(Long id) {
        return allegadoRepository.findById(id).orElse(null);
    }
}