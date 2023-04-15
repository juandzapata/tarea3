package tarea3.maven;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import tarea3.maven.excepciones.ProductoNoEncontradoException;
import tarea3.maven.excepciones.ProveedorNoEncontradoException;
import tarea3.maven.lectura.Lector;
import tarea3.maven.modelos.Producto;
import tarea3.maven.modelos.Proveedor;

public class ControlRegalos {
    List<Proveedor> proveedores = new ArrayList<>();
    List<Producto> productos = new ArrayList<>();

    /**
     * Actualiza la lista de proveedores con los datos del archivo proveedores.json
     * @throws Exception si no encuentra el archivo o si el archivo no tiene el formato correcto.
     */
    public void actualizarProveedores() throws Exception {
        Lector lector = new Lector();
        String[] lineas = lector.leerArchivo("src/main/java/tarea3/maven/lectura/proveedores.json");
            
        JSONArray jsonArray = new JSONArray(String.join("", lineas));
        
    
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject proveedorJson = jsonArray.getJSONObject(i);
            String nombre = proveedorJson.getString("nombre");
            Double precioEnvio = proveedorJson.getDouble("precioEnvio");

            Proveedor proveedor = new Proveedor(nombre, precioEnvio);
            proveedores.add(proveedor);
        }

    }


    /**
     * Actualiza la lista de productos con los datos del archivo productos.json           
     * @throws Exception si no encuentra el archivo o si el archivo no tiene el formato correcto.
     * @throws ProveedorNoEncontradoException si el proveedor del producto no se encuentra en la lista de proveedores.
     */
    public void actualizarProductos() throws Exception, ProveedorNoEncontradoException {
        
        Lector lector = new Lector();
        String[] lineas = lector.leerArchivo("src/main/java/tarea3/maven/lectura/productos.json");
    
        JSONArray productosArray = new JSONArray(String.join("", lineas));
    
        for (int i = 0; i < productosArray.length(); i++) {
            JSONObject productoJson = productosArray.getJSONObject(i);
    
            String nombre = productoJson.getString("nombre");
            int edadRecomendada = productoJson.getInt("edad");
            Double precioProducto = productoJson.getDouble("precio");
            String proveedorNombre = productoJson.getString("proveedor");
    
            // Buscamos el proveedor y lo asignamos al producto
            Proveedor proveedorProducto = buscarProveedor(proveedorNombre);
    
            Producto producto = new Producto(nombre, edadRecomendada, precioProducto, proveedorProducto);
            productos.add(producto);
            
        }

    }

    /**
     * Muestra la información de los productos que cumplan con la edad y el precio máximo.
     * @param edad
     * @param precioMaximo
     * @return la lista con la información de los productos que cumplen con la edad y el precio máximo
     * @throws ProductoNoEncontradoException si no encuentra ningún producto que cumpla con la edad y el precio máximo.
     */
    public List<String> mostrarProductos(int edad, Double precioMaximo) throws ProductoNoEncontradoException {
        List<String> regalos = new ArrayList<>();

        for (Producto producto : productos) {
            Double total = producto.getPrecioBase() + producto.getProveedor().getPrecioEnvio();
            if( producto.getEdad() == edad && total <= precioMaximo){
                String regalo = producto.toString();
                regalos.add(regalo);
            }
        }

        if(regalos.size() == 0){
            throw new ProductoNoEncontradoException();
        }else{
            return regalos;
        }
    }

    /**
     * Busca un proveedor por su nombre.     
     * @param nombreProveedor
     * @return el proveedor encontrado
     * @throws ProveedorNoEncontradoException si el proveedor del producto no se encuentra en la lista de proveedores.
     */
    private Proveedor buscarProveedor(String nombreProveedor) throws ProveedorNoEncontradoException {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getNombre().equals(nombreProveedor)) {
                return proveedor;
            }
        }
        throw new ProveedorNoEncontradoException("Proveedor no encontrado: " + nombreProveedor);
    }
}
