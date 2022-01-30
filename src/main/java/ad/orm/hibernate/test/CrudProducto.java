package ad.orm.hibernate.test;

import ad.orm.hibernate.domain.Producto;
import ad.orm.hibernate.domain.Trabajo;
import ad.orm.hibernate.domain.Trabajo_producto;
import ad.orm.hibernate.service.ProductoService;
import ad.orm.hibernate.service.TrabajoService;

public class CrudProducto {
    public static void main(String[] args) {
        ProductoService productoService = new ProductoService();
        TrabajoService trabajoService = new TrabajoService();

        Producto producto = productoService.read(1);
        Trabajo trabajo = trabajoService.read(8);
       // productoService.save(producto);
        Trabajo_producto trabajo_producto = new Trabajo_producto();

        trabajo_producto.setProductoToTrabajo(producto);
        trabajo_producto.setTrabajoToProducto(trabajo);


        /*Producto productoLoad = productoService.read(1);
        productoLoad.setNombre("Pintura Blanca Antimoho");

        productoService.update(productoLoad);
        productoService.delete(6);
         */

        productoService.readAll().forEach(producto1 -> {
            System.out.println(producto1.toString());
        });

       /* trabajo.getProductosToTrabajos().add(trabajo_producto);
        trabajoService.update(trabajo);

        */
    }
}
