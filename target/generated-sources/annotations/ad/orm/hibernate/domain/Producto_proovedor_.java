package ad.orm.hibernate.domain;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Producto_proovedor.class)
public abstract class Producto_proovedor_ {

	public static volatile SingularAttribute<Producto_proovedor, Proovedor> proovedorToProducto;
	public static volatile SingularAttribute<Producto_proovedor, Float> precio;
	public static volatile SingularAttribute<Producto_proovedor, Float> descuento;
	public static volatile SingularAttribute<Producto_proovedor, Producto> productoToProovedor;

	public static final String PROOVEDOR_TO_PRODUCTO = "proovedorToProducto";
	public static final String PRECIO = "precio";
	public static final String DESCUENTO = "descuento";
	public static final String PRODUCTO_TO_PROOVEDOR = "productoToProovedor";

}

