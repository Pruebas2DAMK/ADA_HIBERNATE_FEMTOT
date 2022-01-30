package ad.orm.hibernate.app;

import ad.orm.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Scanner;

import static ad.orm.hibernate.util.UserOptions.mostrarOpciones;

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
}
