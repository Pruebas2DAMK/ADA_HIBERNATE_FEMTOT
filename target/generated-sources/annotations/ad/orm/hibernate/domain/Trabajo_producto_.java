package ad.orm.hibernate.domain;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Trabajo_producto.class)
public abstract class Trabajo_producto_ {

	public static volatile SingularAttribute<Trabajo_producto, Trabajo> trabajoToProducto;
	public static volatile SingularAttribute<Trabajo_producto, Producto> productoToTrabajo;
	public static volatile SingularAttribute<Trabajo_producto, Integer> cantidad;

	public static final String TRABAJO_TO_PRODUCTO = "trabajoToProducto";
	public static final String PRODUCTO_TO_TRABAJO = "productoToTrabajo";
	public static final String CANTIDAD = "cantidad";

}

