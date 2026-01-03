package com.cursos.plataforma.models;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nombre_curso", nullable=false, length=100)
    private String nombre;
    @Column(name="duracion_curso", nullable=false, length=100)
    private String duracion;
    @Column(name="descripcion_curso", nullable=false, length=100)
    private String descripcion;
    @Column(name="fecha_inicio", nullable=false, length=100)
    private String fechaInicio;
    @Column(name="precio_curso", nullable=false)
    private double precio;
    @Column(name="url_imagen")
    private String urlImagen;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="detalle_id", referencedColumnName="id")
    private DetalleCurso detalle;


    public Curso(){

    }

    public Curso(Integer id, String nombre, String duracion, String descripcion, String fechaInicio){
        this.id= id;
        this.nombre=nombre;
        this.duracion=duracion;
        this.descripcion=descripcion;
        this.fechaInicio=fechaInicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public DetalleCurso getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleCurso detalle) {
        this.detalle = detalle;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    

    

    

    

    
}
