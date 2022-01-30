package ad.orm.hibernate.test;

import ad.orm.hibernate.domain.Cliente;
import ad.orm.hibernate.domain.Contacto_cliente;
import ad.orm.hibernate.service.ClienteService;

public class InsertarClienteYContacto {
    public static void main(String[] args) {
        //Relacion 1 a 1
        ClienteService clienteService = new ClienteService();
        Cliente nuevoCliente = new Cliente(9889998,"Dani","Probando");
        clienteService.save(nuevoCliente);
        clienteService.saveContacto(new Contacto_cliente(nuevoCliente,9666950,"probajndo@probando.com","Santa Pola","Calle Elche"));
    }
}
