package ad.orm.hibernate.test;

import ad.orm.hibernate.service.ClienteService;

public class LocalizarEnDao {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();
        System.out.println(clienteService.getClienteById(74442729).toString()); // it works
    }
}
