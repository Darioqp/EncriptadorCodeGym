import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //nombre del archivo donde se guardara el codigo encriptado
        String archivoDeSalida = "texto_encriptado.txt";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            //menu de opciones dentro de un ciclo infinito que tiene un break en el caso de que el usuario elija la
            // opcion 0
            System.out.println("Menu:");
            System.out.println("1. Encriptar");
            System.out.println("2. Desencriptar");
            System.out.println("0. Salir");

            int opcionElegida = scanner.nextInt();

            //En el switch manejamos la creacion de los diferentes objetos y las llamadas a sus respectivos metodos
            switch (opcionElegida) {

                case 1:
                    /*
                    Se crea un objeto de tipo scanner y una variable de tipo String para almacenar el nombre del archivo
                    que contiene el texto a desencriptar.
                    Luego se crea un objeto de tipo LectorDeArchivo para para usar el metodo leerArchivo y almacenar su
                    contenido en una variable de tipo String llamada textoSinEncriptar.
                    Se crea un objeto de tipo Encriptador y se genera una clave aleatoria entre 1 y 26 para ser utilizada
                    en el metodo encriptarTexto(), el cual recibe como argumento un textoSinEncriptar y una clave de
                    encriptacion.
                    Se crea un objeto de tipo EscritorDeArchivo y se usa el metodo escribirArchivo para guardar en el
                    archivo de
                    salida el texto encriptado.
                     */
                    System.out.println("Introduce el nombre del archivo con el texto a encriptar:");
                    Scanner scanner1 = new Scanner(System.in);
                    String archivoConTextoSinEncriptar = scanner1.nextLine();
                    LectorDeArchivo lectorDeArchivoSinEncriptar = new LectorDeArchivo();
                    String textoSinEncriptar = lectorDeArchivoSinEncriptar.leerArchivo(archivoConTextoSinEncriptar);
                    Encriptador encriptador = new Encriptador();
                    int claveAleatoria = (int) (Math.random() * 26) + 1;
                    String textoEncriptado = encriptador.encriptarTexto(textoSinEncriptar, claveAleatoria);
                    EscritorDeArchivo escritorDeArchivo = new EscritorDeArchivo();
                    escritorDeArchivo.escribirArchivo(textoEncriptado, archivoDeSalida);
                    System.out.println("El archivo se encripto en: " + archivoDeSalida);
                    break;
                case 2:
                    /*
                    se comienza leyendo el archivo de salida para comprobar si no esta vacio, en el caso de que se
                    encuentre vacio, se le informa al usuario que primero debe encriptar un archivo.
                    Dentro del if se crea un objeto de tipo Desencriptador y de tipo LectorDeArchivo para poder usar los
                    metodos de dichas clases, que permiten leer el archivo con el texto encriptado, guardarlo en una
                    variable y llamar al metodo desencriptarTexto. En este caso se opto por mostrar el texto
                    desencriptado en la consola.
                     */
                    try (FileReader lecturaArchivoEncriptado = new FileReader(archivoDeSalida)) {
                        if (lecturaArchivoEncriptado.read() != -1) {
                            Desencriptador desencriptador = new Desencriptador();
                            LectorDeArchivo lectorDeArchivo = new LectorDeArchivo();
                            String textoParaDesencriptar = lectorDeArchivo.leerArchivo(archivoDeSalida);
                            String textoDesencriptado = desencriptador.desencriptarTexto(textoParaDesencriptar);
                            System.out.println("Texto desencriptado:".toUpperCase());
                            System.out.println(textoDesencriptado);
                        } else {
                            System.out.println("Primero debes encriptar el archivo");
                        }
                    } catch (IOException e) {
                        System.out.println("Hubo un problema con la lectura del archivo: " + archivoDeSalida);
                    }

                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    //se opto por colocar un default para el caso en el que el usuario se equivoque al colocar el valor
                    System.out.println("Opcion invalida: ingrese una opcion entre 0 y 2");
            }
            if (opcionElegida == 0) {
                break;
            }

        }
    }
}

