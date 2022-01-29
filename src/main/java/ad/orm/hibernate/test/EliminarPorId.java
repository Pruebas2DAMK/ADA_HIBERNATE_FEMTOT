package ad.orm.hibernate.test;

import ad.orm.hibernate.domain.Cliente;
import ad.orm.hibernate.service.ClienteService;

public class EliminarPorId {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();
        Cliente cliente = clienteService.getClienteById(89237);
        System.out.println(cliente.toString());
        clienteService.delete(cliente.getCod_cliente()); //it works
    }
}
