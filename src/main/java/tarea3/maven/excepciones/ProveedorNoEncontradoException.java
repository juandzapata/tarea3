package tarea3.maven.excepciones;
public class ProveedorNoEncontradoException extends Exception {

    public ProveedorNoEncontradoException(String mensaje) {
        super(mensaje);
    }

    public ProveedorNoEncontradoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}