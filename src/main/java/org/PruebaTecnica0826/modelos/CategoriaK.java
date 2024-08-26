package org.PruebaTecnica0826.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;


@Entity
@Table(name = "marcas")
public class CategoriaK {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  

    private Long id;
    @NotNull(message = "El nombre de la marca es obligatorio")

    private String nombreK;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreK() {
        return nombreK;
    }

    public void setNombreK(String nombreK) {
        this.nombreK = nombreK;
    }

   
}
