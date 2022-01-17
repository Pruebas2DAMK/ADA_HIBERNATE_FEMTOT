package ad.orm.hibernate.domain;

import ad.orm.hibernate.domain.Trabajo_producto.Trabajo_productoId;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Trabajo_producto.class)
public abstract class Trabajo_producto_ {

	public static volatile SingularAttribute<Trabajo_producto, Trabajo> cod_trabajo;
	public static volatile SingularAttribute<Trabajo_producto, Producto> cod_producto;
	public static volatile SingularAttribute<Trabajo_producto, Trabajo_productoId> id;
	public static volatile SingularAttribute<Trabajo_producto, Integer> cantidad;

	public static final String COD_TRABAJO = "cod_trabajo";
	public static final String COD_PRODUCTO = "cod_producto";
	public static final String ID = "id";
	public static final String CANTIDAD = "cantidad";

}

