package ad.orm.hibernate.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "trabajo")
public class Trabajo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_trabajo;

    @ManyToOne
    @JoinColumn(name = "cod_clienteFK")
    private Cliente cod_clienteFK;

    @Column(name = "descripcion")
    private String descripcion;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private Tipo tipo;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado;
    @Column(columnDefinition = "TINYINT",name = "pagado")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean pagado;
    @Column(columnDefinition = "TINYINT",name = "presupuestado")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean presupuestado;
    //TODO :  fecha creacion mirar si crea por defecto o colocarlo en constructor
    @Column(name = "fecha_creacion")
    private Date fecha_creacion;
    @Column(name = "fecha_inicio")
    private Date fecha_inicio;
    @Column(name = "fecha_fin")
    private Date fecha_fin;

    //ManyToMany Trabajo_Producto

    @OneToMany(mappedBy = "trabajoToProducto")
    List<Trabajo_producto>productosToTrabajos = new ArrayList<>();

    //********CONSTRUCTOR********//

    public Trabajo() { }

    public Trabajo(Cliente cod_clienteFK, String descripcion, Tipo tipo,Estado estado, boolean pagado,boolean presupuestado, Date fecha_creacion, Date fecha_inicio, Date fecha_fin) {
        this.cod_clienteFK = cod_clienteFK;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.estado = estado;
        this.pagado = pagado;
        this.presupuestado = presupuestado;
        this.fecha_creacion = fecha_creacion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    //********SETTER&GETTER********//

    public int getCod_trabajo() {
        return cod_trabajo;
    }
    public void setCod_trabajo(int cod_trabajo) {
        this.cod_trabajo = cod_trabajo;
    }
    public Cliente getCod_clienteFK() {
        return cod_clienteFK;
    }
    public void setCod_clienteFK(Cliente cod_clienteFK) {
        this.cod_clienteFK = cod_clienteFK;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public boolean isPagado() {
        return pagado;
    }
    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }
    public Date getFecha_creacion() {
        return fecha_creacion;
    }
    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    public Date getFecha_inicio() {
        return fecha_inicio;
    }
    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
    public Date getFecha_fin() {
        return fecha_fin;
    }
    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public boolean isPresupuestado() {
        return presupuestado;
    }
    public void setPresupuestado(boolean presupuestado) {
        this.presupuestado = presupuestado;
    }

    @Override
    public String toString() {
        return cod_trabajo + " " + cod_clienteFK.getCod_cliente() +
                " " + descripcion + " " + tipo + " " + estado +
                " " + pagado + " " + presupuestado + " " + fecha_creacion +
                " " + fecha_inicio + " " + fecha_fin;
    }
}
