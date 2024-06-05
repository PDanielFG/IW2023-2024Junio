package com.example.application.data.entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "table_lista_regalos")
public class ListaRegalos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double costeTotal;
    private EstadoLista estadoGlobal;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "listaRegalos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Regalo> listaRegalos;



    public ListaRegalos() {
    }
    //metodos getters y setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getCosteTotal() {
        return costeTotal;
    }
    public void setCosteTotal(double costeTotal) {
        this.costeTotal = costeTotal;
    }
    public EstadoLista getEstadoGlobal() {
        return estadoGlobal;
    }
    public void setEstadoGlobal(EstadoLista estadoGlobal) {
        this.estadoGlobal = estadoGlobal;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public List<Regalo> getRegalos() {
        return listaRegalos;
    }
    public void setRegalos(List<Regalo> regalos) {
        this.listaRegalos = regalos;
    }



    public enum EstadoLista {
        CERRADA,
        PENDIENTE
    }
}
