package ad.orm.hibernate.util;

import ad.orm.hibernate.domain.Cliente;
import ad.orm.hibernate.domain.Estado;
import ad.orm.hibernate.domain.Tipo;
import ad.orm.hibernate.domain.Trabajo;
import ad.orm.hibernate.service.ClienteService;
import ad.orm.hibernate.service.TrabajoService;

import java.util.List;
import java.util.Scanner;

public class TrabajoUtil {
    private Scanner sc;
    private Trabajo trabajo;
    private Cliente cliente;
    ClienteService clienteService;

    public TrabajoUtil() {
    }

    public Trabajo creaTrabajo(Cliente cliente) {
        sc = new Scanner(System.in);
        trabajo = new Trabajo();
        trabajo.setFecha_creacion(Trabajo.tiempoActual());
        trabajo.setCod_clienteFK(cliente);
        System.out.print("Descripcion del trabajo: ");
        trabajo.setDescripcion(sc.nextLine());
        System.out.print("Tipo: Pintura, Obra Jardineria o Otro");
        trabajo.setTipo(Tipo.valueOf(sc.nextLine().toUpperCase()));
        System.out.print("Estado: Abierto, En_Curso, Finalizado ");
        trabajo.setEstado(Estado.valueOf(sc.nextLine().toUpperCase()));
        System.out.print("¿Presupuestado?: (S/N) ");
        trabajo.setPagado(!isSelecionado(sc.nextLine()));
        System.out.print("¿Pagado?: (S/N) ");
        trabajo.setPagado(!isSelecionado(sc.nextLine()));

        return trabajo;
    }

    public Trabajo localizaTrabajoById() {
        sc = new Scanner(System.in);
        TrabajoService trabajoService = new TrabajoService();
        System.out.print("Introduce el identificador del trabajo: ");
        String respuesta = sc.nextLine();
        trabajo = trabajoService.read(Integer.parseInt(respuesta));
        if (trabajo != null){
            System.out.println("Trabajo Selecionado: "+trabajo.getCod_trabajo()+" - "+trabajo.getDescripcion());
        }
        return trabajo;
    }

    //Comprueba un si o un no
    private boolean isSelecionado(String respuesta) {
        return  respuesta.substring(0,1).toUpperCase()=="S";
    }


    public List<Trabajo> listaTrabajos() {
        TrabajoService trabajoService = new TrabajoService();
        return trabajoService.readAll();
    }

    public void visualizarTodo(List<Trabajo>trabajoList) {
        trabajoList.forEach(trabajo1 -> {
            System.out.println(trabajo1.toString());
        });
    }

    public void submenuLocalizaTrabajo() {
        boolean loop = true;
        do{
            System.out.println("¿Que Desea Visualizar?\n" +
                    "(A) Trabajo\n" +
                    "(B) Trabajos de Cliente\n" +
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
                    this.localizaTrabajoById();
                    break;
                case "B":
                    visualizarTodo(trabajosClienteList());
                    break;
                case "Z":
                    loop = false;
                    break;
                default:
                    System.out.println("Opción no reconocida");

            }
        }while(loop);
    }


    private List<Trabajo> trabajosClienteList() {
        TrabajoService trabajoService = new TrabajoService();
        ClienteService clienteService = new ClienteService();
        sc = new Scanner(System.in);
        System.out.print("Introduce Identificador del cliente: ");
        return trabajoService.getTrabajosByCliente(clienteService.getClienteById(Integer.parseInt(sc.nextLine())));
    }


    public void modificaTrabajo() {
        TrabajoService trabajoService = new TrabajoService();
        trabajo = localizaTrabajoById();
        boolean loop = true;
        sc = new Scanner(System.in);
        do{
            System.out.println("¿Que quieres cambiar en el Trabajo "+trabajo.getCod_trabajo()+"?\n" +
                    "(A) Descripcion\n" +
                    "(B) Estado\n" +
                    "(C) Ha sido Presupuestado\n"+
                    "(D) Ha sido Cobrado\n"+
                    "(E) Empezado\n"+
                    "(F) Terminado\n"+
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
                    System.out.print("Añade una nueva Descripcion: ");
                    trabajo.setDescripcion(sc.nextLine());
                    trabajoService.update(trabajo);
                    System.out.println("Nueva Descripcion: "+trabajo.getDescripcion());
                    break;
                case "B":
                    sc = new Scanner(System.in);
                    System.out.print("Cambia el estado del trabajo: (Abierto,En_Curso,Finalizado) ");
                    trabajo.setEstado(Estado.valueOf(sc.nextLine().toUpperCase()));
                    trabajoService.update(trabajo);
                    System.out.println("Nuevo Estado: "+trabajo.getEstado());
                    break;
                case "C":
                    trabajo.setPresupuestado(true);
                    System.out.println(trabajo.isPresupuestado());
                    trabajoService.update(trabajo);
                    System.out.println("Presupuestado Correctamente");
                    break;
                case "D":
                    trabajo.setPagado(true);
                    System.out.println(trabajo.isPagado());
                    trabajoService.update(trabajo);
                    System.out.println("Cobrado Correctamente");
                    break;
                case "E":
                    trabajo.setFecha_inicio(Trabajo.tiempoActual());
                    trabajoService.update(trabajo);
                    System.out.println("Hora de inicio establecida");
                    System.out.println(trabajoService.read(trabajo.getCod_trabajo()).toString());
                    break;
                case "F":
                    trabajo.setFecha_fin(Trabajo.tiempoActual());
                    trabajoService.update(trabajo);
                    System.out.println("Trabajo terminado a la hora establecida");
                    System.out.println(trabajoService.read(trabajo.getCod_trabajo()).toString());
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
