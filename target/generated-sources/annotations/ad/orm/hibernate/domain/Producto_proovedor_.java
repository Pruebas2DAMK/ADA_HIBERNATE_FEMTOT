package ad.orm.hibernate.domain;

import ad.orm.hibernate.domain.Producto_proovedor.Producto_proovedorId;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Producto_proovedor.class)
public abstract class Producto_proovedor_ {

	public static volatile SingularAttribute<Producto_proovedor, Float> precio;
	public static volatile SingularAttribute<Producto_proovedor, Proovedor> cod_proovedor;
	public static volatile SingularAttribute<Producto_proovedor, Float> descuento;
	public static volatile SingularAttribute<Producto_proovedor, Producto> cod_producto;
	public static volatile SingularAttribute<Producto_proovedor, Producto_proovedorId> id;

	public static final String PRECIO = "precio";
	public static final String COD_PROOVEDOR = "cod_proovedor";
	public static final String DESCUENTO = "descuento";
	public static final String COD_PRODUCTO = "cod_producto";
	public static final String ID = "id";

}

