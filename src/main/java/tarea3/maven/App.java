package tarea3.maven;

import java.util.List;
import java.util.Scanner;

import tarea3.maven.excepciones.ProductoNoEncontradoException;
import tarea3.maven.excepciones.ProveedorNoEncontradoException;

/**
 * @author Juan David Zapata López
 * @version 1.0
 * @since 2023-04-15
 */
public class App 
{
    public static void main( String[] args )
    {
        ControlRegalos control = new ControlRegalos();
        
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Actualizando proveedores...");
            System.out.println("Actualizando productos...");
            control.actualizarProveedores();
            control.actualizarProductos();

            System.out.print("Ingrese la edad: ");    
            int edad = sc.nextInt();

            System.out.print("Ingrese el precio máximo: ");
            Double precioMaximo = sc.nextDouble();

            List<String> regalos = control.mostrarProductos(edad, precioMaximo);
            
            for (String regalo : regalos) {
                System.out.println(regalo);
            }
            
            
        } catch (ProveedorNoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (ProductoNoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sc.close();
        
    }
}
