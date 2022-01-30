package ad.orm.hibernate.util;

import ad.orm.hibernate.domain.Producto;
import ad.orm.hibernate.service.ClienteService;
import ad.orm.hibernate.service.ProductoService;

import java.util.List;
import java.util.Scanner;

public class ProductoUtil {
    private Scanner sc;
    private Producto producto;

    public ProductoUtil() {
    }

    public Producto creaProducto() {
        sc = new Scanner(System.in);
        producto = new Producto();
        System.out.print("Nombre del Producto: ");
        producto.setNombre(sc.nextLine());
        return producto;
    }

    public Producto localizaProductoById() {
        sc = new Scanner(System.in);
        ProductoService productoService = new ProductoService();
        System.out.print("Introduce el identificador del Producto: ");
        String respuesta = sc.nextLine();
        producto = productoService.read(Integer.parseInt(respuesta));
        if (producto != null){
            System.out.println("Producto Selecionado: "+producto.toString());
        }
        return producto;
    }

    public List<Producto> listaProductos() {
        ProductoService productoService = new ProductoService();
        return productoService.readAll();
    }

    public void visualizarTodo(List<Producto> productoList) {
        productoList.forEach(producto1 -> {
            System.out.println(producto1.toString());
        });
    }

    public void modificaProducto() {
        sc = new Scanner(System.in);
        ProductoService productoService = new ProductoService();
        System.out.print("Identificador del Producto: ");
       producto = productoService.read(Integer.parseInt(sc.nextLine()));
        sc = new Scanner(System.in);
        System.out.print("Nuevo nombre para el producto "+producto.getNombre()+": ");
        producto.setNombre(sc.nextLine());
        productoService.update(producto);
    }
}
