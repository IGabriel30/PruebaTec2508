package org.PruebaTecnica0826.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class ProductoK {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre es requerido.")
    private String nombreK;

    @NotBlank(message = "El precio es requerido.")
    private BigDecimal precioK;

    
    @NotBlank(message = "El precio es requerido.")
    private Integer existenciaK;


    public Integer getExistenciaK() {
        return existenciaK;
    }

    public void setExistenciaK(Integer existenciaK) {
        this.existenciaK = existenciaK;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreK() {
        return nombreK;
    }

    public void setNombreK(String nombreK) {
        this.nombreK = nombreK;
    }

    public BigDecimal getPrecioK() {
        return precioK;
    }

    public void setPrecioK(BigDecimal precioK) {
        this.precioK = precioK;
    }
}
