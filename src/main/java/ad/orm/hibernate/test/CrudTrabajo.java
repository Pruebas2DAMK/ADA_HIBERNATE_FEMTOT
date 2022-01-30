package ad.orm.hibernate.test;

import ad.orm.hibernate.domain.Cliente;
import ad.orm.hibernate.domain.Estado;
import ad.orm.hibernate.domain.Tipo;
import ad.orm.hibernate.domain.Trabajo;
import ad.orm.hibernate.service.ClienteService;
import ad.orm.hibernate.service.TrabajoService;

public class CrudTrabajo {
    public static void main(String[] args) {
        TrabajoService trabajoService = new TrabajoService();
        ClienteService clienteService = new ClienteService();
        /* CREA USER PARA AÑADIRLE UN TRABAJO
        Cliente cliente =new Cliente(967,"Manuel","Sanchez");
        clienteService.save(cliente);
         */

        Cliente cliente = clienteService.getClienteById(74442729);

        // CREA NUEVO TRABAJO
        Trabajo trabajo = new Trabajo(cliente,"Esto es un trabajo de prueba 7", Tipo.PINTURA, Estado.ABIERTO,true,true);
        trabajo.setFecha_inicio(Trabajo.tiempoActual());
        trabajoService.save(trabajo);

        /*ACTUALIZA UN TRABAJO
        Trabajo trabajo = trabajoService.read(8);
        trabajo.setFecha_inicio(Trabajo.tiempoActual()); //añadimos inicio del trabajo
        trabajoService.update(trabajo);
         */

        // ELIMINA TRABAJO trabajoService.delete(9);

        trabajoService.readAll().forEach(e->{
            System.out.println(e.toString()); //ver cada trabajo existente
        });

        System.out.println("AHORA FILTRADO POR CLIENTE\n--------------------------------------------------------");
        trabajoService.getTrabajosByCliente(cliente).forEach(e->{
            System.out.println(e.toString());
        });
    }
}
