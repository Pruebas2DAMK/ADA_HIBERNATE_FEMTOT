package ad.orm.hibernate.test;

import ad.orm.hibernate.domain.Cliente;
import ad.orm.hibernate.service.ClienteService;

import java.util.List;

public class LeerTodosClientes {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();
        List<Cliente> clienteList = clienteService.readAll();

        for (Cliente c:clienteList) {
            System.out.println("Cliente: "+c.toString()+" Contacto: "+c.getContacto_cliente());
        }
    }
}
