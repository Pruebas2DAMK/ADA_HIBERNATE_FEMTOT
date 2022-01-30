package ad.orm.hibernate.util;

import ad.orm.hibernate.domain.Cliente;
import ad.orm.hibernate.domain.Contacto_cliente;
import ad.orm.hibernate.service.ClienteService;
import ad.orm.hibernate.service.ProductoService;

import java.util.List;
import java.util.Scanner;

public class ClienteUtil {
    private Scanner sc;
    private Cliente cliente;
    private Contacto_cliente contacto_cliente;
    public ClienteUtil() {

    }

    public Cliente creaCliente(){
        cliente = new Cliente();
        sc = new Scanner(System.in);
        //Recoger datos del usuario//
        System.out.print("Identificador del cliente: ");
        cliente.setCod_cliente(Integer.parseInt(sc.nextLine()));
        System.out.print("Nombre del cliente: ");
        cliente.setNombre(sc.nextLine());
        System.out.print("Apellido del cliente: ");
        cliente.setApellido(sc.nextLine());
        return cliente;
    }

    public Contacto_cliente creaContacto(Cliente cliente) {
        sc = new Scanner(System.in);
        System.out.println("¿Quiere añadir el contacto del nuevo cliente? (S/N)");
        String respuesta = sc.nextLine();
        System.out.println(respuesta.substring(0,1).toUpperCase()); //prueba
        if(isSelecionado(respuesta)){
            contacto_cliente = null;
            System.out.println("Hasta la proxima!");
        }else {
            sc = new Scanner(System.in);
            contacto_cliente = new Contacto_cliente();
            contacto_cliente.setDni_cliente(cliente);
            System.out.print("Telefono: ");
            contacto_cliente.setTelefono(Integer.parseInt(sc.nextLine()));
            System.out.print("Email: ");
            contacto_cliente.setEmail(sc.nextLine());
            System.out.print("Direccion: ");
            contacto_cliente.setDireccion(sc.nextLine());
            System.out.print("Poblacion: ");
            contacto_cliente.setPoblacion(sc.nextLine());
        }
        return contacto_cliente;
    }

    public Cliente localizaClienteById() {

        sc = new Scanner(System.in);
        System.out.print("Introduce el identificador del cliente: ");
        String respuesta = sc.nextLine();
        ClienteService clienteService = new ClienteService();
        cliente = clienteService.getClienteById(Integer.parseInt(respuesta));
        if (cliente != null){
            System.out.println("Cliente Selecionado: "+cliente.getCod_cliente()+" - "+cliente.getNombre());
        }
        return cliente;
    }

    //Comprueba un si o un no
    private boolean isSelecionado(String respuesta) {
        return  respuesta.substring(0,1).toUpperCase()=="S"?true:false;
    }
    //***********POR SI LO NECESITO, LISTA CON LOS CLIENTES Y VOID VISUALIZAR***************//
    public List<Cliente>listaClientes(){
        ClienteService clienteService = new ClienteService();
        return clienteService.readAll();
    }
    public void visualizarTodo(List<Cliente>clienteList) {
        clienteList.forEach(cliente1 -> {
            System.out.println(cliente1.toString());
        });
    }

    public void modificaCliente() {
        ClienteService clienteService = new ClienteService();
        cliente = localizaClienteById();
        boolean loop = true;
        sc = new Scanner(System.in);
        do{
            System.out.println("¿Que quieres cambiar en el Cliente "+cliente.getCod_cliente()+"?\n" +
                    "(A) Nombre\n" +
                    "(B) Apellido\n" +
                    "(C) Contacto\n"+
                    "(Z) Salir" );
            //Recoger datos del usuario//
            Scanner sc = new Scanner(System.in);
            System.out.print("Tu Selección: ");
            String respuesta = sc.nextLine();
            if (respuesta.isEmpty()){
                respuesta = "Z";
            }else{
                respuesta = respuesta.toUpperCase().substring(0,1);
            }

            //Que hace cada respuesta//
            switch (respuesta){
                case "A":
                    sc = new Scanner(System.in);
                    System.out.print("Nuevo nombre para el Cliente "+cliente.getNombre()+": ");
                    cliente.setNombre(sc.nextLine());
                    clienteService.update(cliente);
                    System.out.println("Datos nuevos: "+clienteService.getClienteById(cliente.getCod_cliente()));
                    break;
                case "B":
                    sc = new Scanner(System.in);
                    System.out.print("Nuevo apellido para el Cliente "+cliente.getApellido()+": ");
                    cliente.setApellido(sc.nextLine());
                    clienteService.update(cliente);
                    System.out.println("Datos nuevos: "+clienteService.getClienteById(cliente.getCod_cliente()));
                    break;
                case "C":
                    System.out.println("Working Progress...");
                    //Opcion sin hacer, me falta tiempo y es una practica de ejemplo para ver que sabemos implementar esto, ToDo
                    break;
                case "Z":
                    loop = false;
                    break;
                default:
                    System.out.println("Opción no reconocida");

            }
        }while(loop);
    }
}
