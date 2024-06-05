package com.example.application.data.entity;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "table_allegado")
public class Allegado{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apodo;

    @ManyToMany(mappedBy = "allegados")
    private List<User> users;



    public Allegado() {
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
    public String getApodo() {
        return apodo;
    }
    public void setApodo(String apodo) {
        this.apodo = apodo;
    }
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }



}
