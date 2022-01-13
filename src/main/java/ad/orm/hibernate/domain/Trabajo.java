package ad.orm.hibernate.domain;

import java.util.Date;

public class Trabajo {

    private int cod_trabajo;
    private int cod_clienteFK;
    private String descripcion;
    private Tipo tipo;
    private Estado estado;
    //TODO : Averiguar los ENUM y sus problemas y la diferencia entre conversion Tinyint - Boolean
    private boolean pagado;
    private boolean presupuestado;
    private Date fecha_creacion;
    private Date fecha_inicio;
    private Date fecha_fin;

    //********CONSTRUCTOR********//

    public Trabajo() { }

    public Trabajo(int cod_clienteFK, String descripcion, Tipo tipo,Estado estado, boolean pagado,boolean presupuestado, Date fecha_creacion, Date fecha_inicio, Date fecha_fin) {
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
    public int getCod_clienteFK() {
        return cod_clienteFK;
    }
    public void setCod_clienteFK(int cod_clienteFK) {
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
        return cod_trabajo + " " + cod_clienteFK +
                " " + descripcion + " " + tipo + " " + estado +
                " " + pagado + " " + presupuestado + " " + fecha_creacion +
                " " + fecha_inicio + " " + fecha_fin;
    }
}
