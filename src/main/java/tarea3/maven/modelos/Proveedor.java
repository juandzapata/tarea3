package tarea3.maven.modelos;
public class Proveedor {
    private String nombre;
    private Double precioEnvio;

    public Proveedor(String nombre, Double precioEnvio) {
        this.nombre = nombre;
        this.precioEnvio = precioEnvio;
    }

    public Double getPrecioEnvio() {
        return precioEnvio;
    }

    public String getNombre() {
        return nombre;
    }
}
