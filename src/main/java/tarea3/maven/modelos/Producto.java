package tarea3.maven.modelos;

public class Producto {
    private String nombre;
    private int edadRecomendada;
    private Double precioBase;
    private Proveedor proveedor;

    public Producto(String nombre, int edadRecomendada, Double precioBase, Proveedor proveedor) {
        this.nombre = nombre;
        this.edadRecomendada = edadRecomendada;
        this.precioBase = precioBase;
        this.proveedor = proveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public int getEdad() {
        return this.edadRecomendada;
    }

    public String toString() {
        return nombre + " - Precio base: $" + precioBase + " - Precio envío: $" + proveedor.getPrecioEnvio()
                + " - Precio total: $" + (precioBase + proveedor.getPrecioEnvio());
    }

}
