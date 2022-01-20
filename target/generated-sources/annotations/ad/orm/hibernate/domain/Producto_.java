package ad.orm.hibernate.domain;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Producto.class)
public abstract class Producto_ {

	public static volatile SingularAttribute<Producto, Integer> cod_producto;
	public static volatile ListAttribute<Producto, trabajo_producto> trabajos;
	public static volatile SingularAttribute<Producto, String> nombre;

	public static final String COD_PRODUCTO = "cod_producto";
	public static final String TRABAJOS = "trabajos";
	public static final String NOMBRE = "nombre";

}

