package ad.orm.hibernate.domain;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Contacto_cliente.class)
public abstract class Contacto_cliente_ {

	public static volatile SingularAttribute<Contacto_cliente, String> direccion;
	public static volatile SingularAttribute<Contacto_cliente, Cliente> dni_cliente;
	public static volatile SingularAttribute<Contacto_cliente, String> poblacion;
	public static volatile SingularAttribute<Contacto_cliente, Integer> telefono;
	public static volatile SingularAttribute<Contacto_cliente, String> email;

	public static final String DIRECCION = "direccion";
	public static final String DNI_CLIENTE = "dni_cliente";
	public static final String POBLACION = "poblacion";
	public static final String TELEFONO = "telefono";
	public static final String EMAIL = "email";

}

