package tarea3.maven.lectura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class Lector {    
   
    public String[] leerArchivo(String ruta) throws Exception{
        String nombreArchivo = ruta;
        List<String> lineas = new ArrayList<>();

        BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
        String lineaActual;

        while ((lineaActual = lector.readLine()) != null) {
            lineas.add(lineaActual);
        }

        lector.close();

        String[] arregloLineas = lineas.toArray(new String[lineas.size()]);
        return arregloLineas;
    }
        
}
