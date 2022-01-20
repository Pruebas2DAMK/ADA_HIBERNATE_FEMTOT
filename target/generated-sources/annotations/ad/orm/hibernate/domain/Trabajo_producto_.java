package ad.orm.hibernate.domain;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(trabajo_producto.class)
public abstract class trabajo_producto_ {

	public static volatile SingularAttribute<trabajo_producto, Integer> peso;
	public static volatile SingularAttribute<trabajo_producto, Trabajo> trabajo;
	public static volatile SingularAttribute<trabajo_producto, Producto> producto;
	public static volatile SingularAttribute<trabajo_producto, Integer> cantidad;

	public static final String PESO = "peso";
	public static final String TRABAJO = "trabajo";
	public static final String PRODUCTO = "producto";
	public static final String CANTIDAD = "cantidad";

}

