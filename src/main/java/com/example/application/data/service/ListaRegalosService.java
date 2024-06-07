package com.example.application.data.service;

import com.example.application.data.entity.ListaRegalos;
import com.example.application.data.repository.ListaRegalosRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ListaRegalosService {
    private final ListaRegalosRepository listaRegalosRepository;

    public ListaRegalosService(ListaRegalosRepository listaRegalosRepository) {
        this.listaRegalosRepository = listaRegalosRepository;
    }

    public List<ListaRegalos> findAll() {
        return listaRegalosRepository.findAll();
    }
    public long count() {
        return listaRegalosRepository.count();
    }
    public void delete(ListaRegalos listaRegalos) {
        listaRegalosRepository.delete(listaRegalos);
    }
    public void save(ListaRegalos listaRegalos) {
        if (listaRegalos == null) {
            System.err.println("ListaRegalo is null");
            return;
        }
        listaRegalosRepository.save(listaRegalos);
    }
    public ListaRegalos findByID(Long id) {
        return listaRegalosRepository.findById(id).orElse(null);
    }
}