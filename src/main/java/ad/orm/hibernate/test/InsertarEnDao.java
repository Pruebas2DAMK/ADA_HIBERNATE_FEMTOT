package ad.orm.hibernate.test;

import ad.orm.hibernate.domain.Cliente;
import ad.orm.hibernate.service.ClienteService;

import java.sql.SQLIntegrityConstraintViolationException;

public class InsertarEnDao {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();

        clienteService.save(new Cliente(89237,"pepe","nuñez")); //it works
    }
}
