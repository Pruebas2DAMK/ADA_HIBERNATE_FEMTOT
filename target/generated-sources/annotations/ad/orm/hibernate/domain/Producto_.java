package ad.orm.hibernate.domain;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Producto.class)
public abstract class Producto_ {

	public static volatile SetAttribute<Producto, Producto_proovedor> producto_proovedor;
	public static volatile SingularAttribute<Producto, Integer> cod_producto;
	public static volatile SetAttribute<Producto, Trabajo_producto> producto_trabajo;
	public static volatile SingularAttribute<Producto, String> nombre;

	public static final String PRODUCTO_PROOVEDOR = "producto_proovedor";
	public static final String COD_PRODUCTO = "cod_producto";
	public static final String PRODUCTO_TRABAJO = "producto_trabajo";
	public static final String NOMBRE = "nombre";

}

