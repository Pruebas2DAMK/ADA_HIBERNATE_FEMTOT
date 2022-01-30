package ad.orm.hibernate.test;

import ad.orm.hibernate.service.ClienteService;

public class VerOneToOne {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();
        System.out.println(clienteService.getContactoClienteById(74442729));
    }
}
