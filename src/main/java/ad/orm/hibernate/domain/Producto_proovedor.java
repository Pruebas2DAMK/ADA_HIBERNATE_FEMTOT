package ad.orm.hibernate.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "producto_proovedor")
//Las relaciones de muchos a muchos con atributos se modelan con relaciones many to one
public class Producto_proovedor {
    //https://thorben-janssen.com/hibernate-tip-many-to-many-association-with-additional-attributes/
    @EmbeddedId
    private Producto_proovedorId id = new Producto_proovedorId();
    @ManyToOne
    @MapsId("cod_producto")
    private Producto cod_producto;
    @ManyToOne
    @MapsId("cod_proovedor")
    private Proovedor cod_proovedor;
    @Column(name = "precio")
    private float precio;
    @Column(name = "descuento")
    private float descuento;

    //********CONSTRUCTOR********//

    public Producto_proovedor() { }

    public Producto_proovedor(Producto cod_producto, Proovedor cod_proovedor, float precio, float descuento) {
        this.cod_producto = cod_producto;
        this.cod_proovedor = cod_proovedor;
        this.precio = precio;
        this.descuento = descuento;
    }

    //********SETTER&GETTER********//

    public Producto getCod_producto() {
        return cod_producto;
    }
    public void setCod_producto(Producto cod_producto) {
        this.cod_producto = cod_producto;
    }
    public Proovedor getCod_proovedor() {
        return cod_proovedor;
    }
    public void setCod_proovedor(Proovedor cod_proovedor) {
        this.cod_proovedor = cod_proovedor;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public float getDescuento() {
        return descuento;
    }
    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }


    //********TOSTRING********//

    @Override
    public String toString() {
        return  cod_producto.getCod_producto() + " " + cod_proovedor.getCod_proovedor() +
                " " + precio + " " + descuento;
    }
    @Embeddable
    public static class Producto_proovedorId implements Serializable {
        private static final long serialVersionUID = 1L;
        private long cod_producto;
        private long cod_proovedor;

        public Producto_proovedorId() {
        }

        public Producto_proovedorId(long cod_producto, long cod_proovedor) {
            this.cod_producto = cod_producto;
            this.cod_proovedor = cod_proovedor;
        }

        public long getCod_producto() {
            return cod_producto;
        }

        public void setCod_producto(long cod_producto) {
            this.cod_producto = cod_producto;
        }

        public long getCod_proovedor() {
            return cod_proovedor;
        }

        public void setCod_proovedor(long cod_proovedor) {
            this.cod_proovedor = cod_proovedor;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Producto_proovedorId that = (Producto_proovedorId) o;
            return cod_producto == that.cod_producto &&
                    cod_proovedor == that.cod_proovedor;
        }

        @Override
        public int hashCode() {
            return Objects.hash(cod_producto, cod_proovedor);
        }
    }
}

