package ad.orm.hibernate.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "trabajo_producto")
public class Trabajo_producto {
    @EmbeddedId
    private Trabajo_productoId id = new Trabajo_productoId();
    @ManyToOne
    @MapsId("cod_trabajo")
    private Trabajo cod_trabajo;
    @ManyToOne
    @MapsId("cod_producto")
    private Producto cod_producto;
    @Column(name = "cantidad")
    private int cantidad;

    //********CONSTRUCTOR********//

    public Trabajo_producto() { }

    public Trabajo_producto(Trabajo cod_trabajo, Producto cod_producto, int cantidad) {
        this.cod_trabajo = cod_trabajo;
        this.cod_producto = cod_producto;
        this.cantidad = cantidad;
    }

    //********SETTER&GETTER********//

    public Trabajo getCod_trabajo() {
        return cod_trabajo;
    }
    public void setCod_trabajo(Trabajo cod_trabajo) {
        this.cod_trabajo = cod_trabajo;
    }
    public Producto getCod_producto() {
        return cod_producto;
    }
    public void setCod_producto(Producto cod_producto) {
        this.cod_producto = cod_producto;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //********TOSTRING********//

    @Override
    public String toString() {
        return cod_trabajo + " " + cod_producto + " " + cantidad;
    }

    @Embeddable
    public static class Trabajo_productoId implements Serializable {
        private static final long serialVersionUID = 1L;
        private long cod_trabajo;
        private long cod_producto;

        public Trabajo_productoId() {
        }

        public Trabajo_productoId(long cod_trabajo, long cod_producto) {
            this.cod_trabajo = cod_trabajo;
            this.cod_producto = cod_producto;
        }

        public long getCod_trabajo() {
            return cod_trabajo;
        }

        public void setCod_trabajo(long cod_trabajo) {
            this.cod_trabajo = cod_trabajo;
        }

        public long getCod_producto() {
            return cod_producto;
        }

        public void setCod_producto(long cod_producto) {
            this.cod_producto = cod_producto;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Trabajo_productoId that = (Trabajo_productoId) o;
            return cod_trabajo == that.cod_trabajo &&
                    cod_producto == that.cod_producto;
        }

        @Override
        public int hashCode() {
            return Objects.hash(cod_trabajo, cod_producto);
        }
    }
}
