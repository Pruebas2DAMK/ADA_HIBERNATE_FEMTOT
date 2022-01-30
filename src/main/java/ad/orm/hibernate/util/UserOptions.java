package ad.orm.hibernate.util;

import ad.orm.hibernate.domain.Cliente;
import ad.orm.hibernate.domain.Contacto_cliente;
import ad.orm.hibernate.domain.Producto;
import ad.orm.hibernate.domain.Trabajo;
import ad.orm.hibernate.service.ClienteService;
import ad.orm.hibernate.service.ProductoService;
import ad.orm.hibernate.service.TrabajoService;
import com.sun.java.accessibility.util.AccessibilityListenerList;

import java.util.Scanner;

public class UserOptions {
    private boolean loop;
    private ClienteService clienteService;
    private TrabajoService trabajoService;
    private ProductoService productoService;
    private Contacto_cliente contacto_cliente;
    private Cliente cliente;
    private Trabajo trabajo;
    private Producto producto;
    UserOptions(){
        loop = true;
        clienteService = new ClienteService();
        trabajoService = new TrabajoService();
        productoService = new ProductoService();
    }

    public boolean isLoop() { return loop; }

    public void setLoop(boolean loop) { this.loop = loop; }

    //**********Muestra las opciones que ofrece la app**********//
    public static void mostrarOpciones(){
        UserOptions userOptions = new UserOptions();
        boolean loop = true;
        do{ //TODO : Preparar para 2 puntos y luego ya vemos
            System.out.println("¿Que Operación desea hacer?\n" +
                    "(A) Crear\n" +
                    "(B) Modificar\n" +
                    "(C) Eliminar\n" +
                    "(D) Visualizar todo\n"+
                    "(E) Buscar por id\n"+
                    "(Z) Salir");

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
                    userOptions.opcionCrear(userOptions.isLoop());
                    break;
                case "B":
                    userOptions.opcionModificar(userOptions.isLoop());
                    break;
                case "C":
                    userOptions.opcionEliminar(userOptions.isLoop());
                    break;
                case "D":
                    userOptions.opcionVisualizarTodo(userOptions.isLoop());
                    break;
                case "E":
                    userOptions.opcionVisualizarById(userOptions.isLoop());
                    break;

                case "Z":
                    System.out.println("Gracias por utilizarme (¬‿¬)\n"
                            + "Saliendo");
                    loop = false;
                    break;
                default:
                    System.out.println("Opción no reconocida");

            }

        }while(loop);
    }

    private void opcionModificar(boolean loop) {
        do{
            System.out.println("¿Que Desea Modificar?\n" +
                    "(A) Cliente\n" +
                    "(B) Trabajo\n" +
                    "(C) Producto\n" +
                    "(Z) Salir");
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
                    ClienteUtil clienteUtil = new ClienteUtil();
                    clienteUtil.modificaCliente();
                    break;
                case "B":
                    TrabajoUtil trabajoUtil = new TrabajoUtil();
                    trabajoUtil.modificaTrabajo();
                    break;
                case "C":
                    ProductoUtil productoUtil = new ProductoUtil();
                    productoUtil.modificaProducto();

                    break;
                case "Z":
                    loop = false;
                    break;
                default:
                    System.out.println("Opción no reconocida");

            }

        }while(loop);
    }

    private void opcionVisualizarById(boolean loop) {
        do{
            System.out.println("¿Que Desea Visualizar?\n" +
                    "(A) Cliente\n" +
                    "(B) Trabajo\n" +
                    "(C) Producto\n" +
                    "(Z) Salir");

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
                    ClienteUtil clienteUtil = new ClienteUtil();
                    clienteUtil.localizaClienteById();
                    break;
                case "B":
                    TrabajoUtil trabajoUtil = new TrabajoUtil();
                    trabajoUtil.submenuLocalizaTrabajo();
                    break;
                case "C":
                    ProductoUtil productoUtil = new ProductoUtil();
                    productoUtil.localizaProductoById();
                    break;
                case "Z":
                    loop = false;
                    break;
                default:
                    System.out.println("Opción no reconocida");

            }

        }while(loop);
    }


    //**********Muestra las opciones de la visualizar to.do**********//
    private void opcionVisualizarTodo(boolean loop) {
        do{
            System.out.println("¿Que Tabla Desea Visualizar?\n" +
                    "(A) Clientes\n" +
                    "(B) Trabajos\n" +
                    "(C) Productos\n" +
                    "(Z) Salir");
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
                    ClienteUtil clienteUtil = new ClienteUtil();
                    clienteUtil.visualizarTodo(clienteUtil.listaClientes());
                    break;
                case "B":
                    TrabajoUtil trabajoUtil = new TrabajoUtil();
                    trabajoUtil.visualizarTodo(trabajoUtil.listaTrabajos());
                    break;
                case "C":
                    ProductoUtil productoUtil = new ProductoUtil();
                    productoUtil.visualizarTodo(productoUtil.listaProductos());
                    break;
                case "Z":
                    loop = false;
                    break;
                default:
                    System.out.println("Opción no reconocida");

            }
        }while(loop);
    }



    //**********Muestra las opciones de la opcion crear**********//
    private void opcionCrear(boolean loop) {
        do{
            System.out.println("¿Que Desea Crear?\n" +
                    "(A) Cliente\n" +
                    "(B) Trabajo\n" +
                    "(C) Producto\n" +
                    "(Z) Salir");

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
                    ClienteUtil clienteUtil = new ClienteUtil();
                    cliente = clienteUtil.creaCliente();
                    if (cliente != null){
                        clienteService.save(cliente);
                        System.out.println(clienteService.getClienteById(cliente.getCod_cliente()));
                       Contacto_cliente contacto_cliente = clienteUtil.creaContacto(cliente);
                       clienteService.saveContacto(contacto_cliente);
                        System.out.println(clienteService.getContactoClienteById(contacto_cliente.getDni_cliente().getCod_cliente()));
                    }

                    break;
                case "B":
                    TrabajoUtil trabajoUtil = new TrabajoUtil();
                    sc = new Scanner(System.in);
                    System.out.println("Id del Cliente asociado al trabajo");
                    trabajo = trabajoUtil.creaTrabajo(clienteService.getClienteById(Integer.parseInt(sc.nextLine())));
                    if (trabajo != null){
                        trabajoService.save(trabajo);
                        System.out.println(trabajoService.read(trabajo.getCod_trabajo()));
                    }
                    break;
                case "C":
                    ProductoUtil productoUtil = new ProductoUtil();
                    producto = productoUtil.creaProducto();
                    if (producto != null){
                        productoService.save(producto);
                        System.out.println(productoService.read(producto.getCod_producto()).toString());
                    }

                    break;
                case "Z":
                    loop = false;
                    break;
                default:
                    System.out.println("Opción no reconocida");

            }

        }while(loop);
    }
    //**********Muestra las opciones de la opcion crear**********//
    private void opcionEliminar(boolean loop) {
        do{
            System.out.println("¿Que Desea Eliminar?\n" +
                    "(A) Cliente\n" +
                    "(B) Trabajo\n" +
                    "(C) Producto\n" +
                    "(Z) Salir");

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
                    ClienteUtil clienteUtil = new ClienteUtil();
                    cliente = clienteUtil.localizaClienteById();
                    if (cliente != null){
                        System.out.println("El Cliente con Id "+cliente.getCod_cliente()+" sera eliminado.");
                        clienteService.delete(cliente.getCod_cliente());
                        System.out.println("Cliente Eliminado");
                    }
                    break;
                case "B":
                    TrabajoUtil trabajoUtil = new TrabajoUtil();
                    sc = new Scanner(System.in);
                    trabajo = trabajoUtil.localizaTrabajoById();
                    if (trabajo != null){
                        System.out.println("El Trabajo con Id "+trabajo.getCod_trabajo()+" del Cliente "+clienteService.getClienteById(trabajo.getCod_clienteFK().getCod_cliente())+" sera eliminado.");
                        trabajoService.delete(trabajo.getCod_trabajo());
                        System.out.println("Trabajo Eliminado");
                    }
                    break;
                case "C":
                    ProductoUtil productoUtil = new ProductoUtil();
                    sc = new Scanner(System.in);
                    producto = productoUtil.localizaProductoById();
                    if (producto != null){
                        System.out.println("El Producto "+producto.toString()+ " sera eliminado.");
                        productoService.delete(producto.getCod_producto());
                        System.out.println("Producto Eliminado");
                    }
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
