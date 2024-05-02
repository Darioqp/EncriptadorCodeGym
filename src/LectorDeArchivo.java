import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorDeArchivo {
    /*
    Este metodo nos retorna un String con el contenido del archivo.
    En el metodo leerArchivo tenemos un StringBuilder que almacena lo que se lee del archivo y que posteriormente se
    convierte a un String.
    Tenemos un bloque try catch, donde la class BufferedReader almacena momentaneamente lo que recibe del FileReader.
    Un bloque while verifica si hay una nueva linea y en caso de ser asi la agrega al StringBuilder junto con un salto
    de linea.
     */

    public String leerArchivo(String archivo) {
        StringBuilder contenidoDelArchivo = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                contenidoDelArchivo.append(linea).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Hubo un problema: " + e.getMessage());
        }
        return contenidoDelArchivo.toString();
    }
}
