package ad.orm.hibernate.domain;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "trabajo_producto")
public class Trabajo_producto implements Serializable {
   @ManyToOne()
    @Id
    private Trabajo trabajoToProducto;
    @ManyToOne()
    @Id
    private Producto productoToTrabajo;
    @Column(name = "cantidad")
    int cantidad;

    public Trabajo_producto() {
    }

 public Trabajo getTrabajoToProducto() {
  return trabajoToProducto;
 }

 public void setTrabajoToProducto(Trabajo trabajoToProducto) {
  this.trabajoToProducto = trabajoToProducto;
 }

 public Producto getProductoToTrabajo() {
  return productoToTrabajo;
 }

 public void setProductoToTrabajo(Producto productoToTrabajo) {
  this.productoToTrabajo = productoToTrabajo;
 }

 public int getCantidad() {
  return cantidad;
 }

 public void setCantidad(int cantidad) {
  this.cantidad = cantidad;
 }
}
