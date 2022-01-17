package ad.orm.hibernate.domain;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile SingularAttribute<Cliente, String> apellido;
	public static volatile ListAttribute<Cliente, Trabajo> trabajos;
	public static volatile SingularAttribute<Cliente, Integer> cod_cliente;
	public static volatile SingularAttribute<Cliente, String> nombre;

	public static final String APELLIDO = "apellido";
	public static final String TRABAJOS = "trabajos";
	public static final String COD_CLIENTE = "cod_cliente";
	public static final String NOMBRE = "nombre";

}

