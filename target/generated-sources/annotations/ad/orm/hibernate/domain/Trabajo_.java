package ad.orm.hibernate.domain;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Trabajo.class)
public abstract class Trabajo_ {

	public static volatile SingularAttribute<Trabajo, String> descripcion;
	public static volatile SingularAttribute<Trabajo, Cliente> cod_clienteFK;
	public static volatile SingularAttribute<Trabajo, Tipo> tipo;
	public static volatile SingularAttribute<Trabajo, Estado> estado;
	public static volatile SingularAttribute<Trabajo, Boolean> pagado;
	public static volatile SingularAttribute<Trabajo, Date> fecha_inicio;
	public static volatile ListAttribute<Trabajo, Trabajo_producto> productosToTrabajos;
	public static volatile SingularAttribute<Trabajo, Integer> cod_trabajo;
	public static volatile SingularAttribute<Trabajo, Date> fecha_fin;
	public static volatile SingularAttribute<Trabajo, Date> fecha_creacion;
	public static volatile SingularAttribute<Trabajo, Boolean> presupuestado;

	public static final String DESCRIPCION = "descripcion";
	public static final String COD_CLIENTE_FK = "cod_clienteFK";
	public static final String TIPO = "tipo";
	public static final String ESTADO = "estado";
	public static final String PAGADO = "pagado";
	public static final String FECHA_INICIO = "fecha_inicio";
	public static final String PRODUCTOS_TO_TRABAJOS = "productosToTrabajos";
	public static final String COD_TRABAJO = "cod_trabajo";
	public static final String FECHA_FIN = "fecha_fin";
	public static final String FECHA_CREACION = "fecha_creacion";
	public static final String PRESUPUESTADO = "presupuestado";

}

