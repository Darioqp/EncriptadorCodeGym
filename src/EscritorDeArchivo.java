import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscritorDeArchivo {
    /*
    En esta clase se hace uso de la clase FileWriter, BufferedWriter y del metodo write para escribir el texto
    encriptado en el archivo de salida. El BufferedWriter se usa como un flujo de salida.
    Se usa el try-with-resources para asegurarnos de cerrar el archivo.
     */

    public void escribirArchivo(String textoEncriptado, String archivoConTextoEncriptado) {
        try(FileWriter flujoDeSalida = new FileWriter(archivoConTextoEncriptado);
            BufferedWriter bufferedWriter = new BufferedWriter(flujoDeSalida)) {
            bufferedWriter.write(textoEncriptado);
        } catch (IOException e) {
            System.out.println("Problemas al escribir el archivo: " + e.getMessage());
        }
    }
}
