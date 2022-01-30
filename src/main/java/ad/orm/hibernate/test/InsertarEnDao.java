package ad.orm.hibernate.test;

import ad.orm.hibernate.domain.Cliente;
import ad.orm.hibernate.domain.Contacto_cliente;
import ad.orm.hibernate.service.ClienteService;
import ad.orm.hibernate.service.DatabaseService;

import java.sql.SQLIntegrityConstraintViolationException;

public class InsertarEnDao {
    public static void main(String[] args) {

        ClienteService clienteService = new ClienteService();
        /*
        clienteService.save(new Cliente(89237,"pepe","nuñez")); //it works
         */

        Cliente cliente = clienteService.getClienteById(74442729);
        DatabaseService databaseService = new DatabaseService();
        databaseService.save(new Contacto_cliente(cliente,96669045,"joelsempere96@gmail.com","Santa Pola","Avenida Canalejas"));
    }
}
