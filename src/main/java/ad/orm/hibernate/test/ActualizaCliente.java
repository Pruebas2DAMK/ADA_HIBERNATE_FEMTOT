package ad.orm.hibernate.test;

import ad.orm.hibernate.domain.Cliente;
import ad.orm.hibernate.service.ClienteService;

public class ActualizaCliente {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();
        clienteService.update(new Cliente(74442729,"Joel","Sempere"));
    }

}
