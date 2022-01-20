package ad.orm.hibernate.domain;

import javax.persistence.*;
import java.io.Serializable;
  @Entity
  @Table(name = "trabajo_producto")
  public class trabajo_producto implements Serializable {
    @ManyToOne()
    @Id
    Trabajo trabajo;
    @ManyToOne()
    @Id
    Producto producto;
    @Column(name = "cantidad")
    int cantidad;


}
