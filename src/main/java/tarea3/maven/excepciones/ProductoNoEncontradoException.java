package tarea3.maven.excepciones;
public class ProductoNoEncontradoException extends Exception {
    
    public ProductoNoEncontradoException() {
        super("No hay productos que cumplan con los requisitos");
    }
 
}
