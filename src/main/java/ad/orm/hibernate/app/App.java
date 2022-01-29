package ad.orm.hibernate.app;

import ad.orm.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Scanner;

public class App {
    //*****************INICIO DE LA APLICACION*****************//
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        System.out.println("Bienvenido a la practica 3 de Hibernate By Joel Sempere\n----------------------------------------------------------");
    try(session){ //Intenta iniciar sesion con el servidor
        mostrarOpciones(); //Muestra las opciones del programa

    }catch (Exception e){
        e.getCause();
    }
    }



    //**********Muestra las opciones que ofrece la app**********//
    private static void mostrarOpciones(){
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
                    System.out.println("pendienteA");
                    break;
                case "B":
                    System.out.println("pendienteB");
                    break;
                case "C":
                    System.out.println("pendienteC");
                    break;
                case "D":
                    System.out.println("D");
                    break;
                case "E":
                    System.out.println("E");
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
}
