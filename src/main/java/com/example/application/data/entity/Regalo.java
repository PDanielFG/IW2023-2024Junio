package com.example.application.data.entity;
import jakarta.persistence.*;

@Entity
public class Regalo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;

    private EstadoRegalo estado;
    private String url;


    @ManyToOne
    @JoinColumn(name = "lista_regalo_id", nullable = false)
    private ListaRegalos listaRegalos;


    //metodos getters y setters
    public Regalo() {
    }
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
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public EstadoRegalo getEstado() {
        return estado;
    }
    public void setEstado(EstadoRegalo estado) {
        this.estado = estado;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public ListaRegalos getListaRegalos() {
        return listaRegalos;
    }
    public void setListaRegalos(ListaRegalos listaRegalos) {
        this.listaRegalos = listaRegalos;
    }


    public enum EstadoRegalo {
        POR_COMPRAR,
        PENDIENTE_DE_RECIBIR,
        RECIBIDO
    }

}
