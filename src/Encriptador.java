public class Encriptador {
    /*
    Esta clase hace uso de la clase DesplazadorDeTexto y de su metodo desplazarTexto, para encriptar un texto con una
    clave que se suministra en el main de manera aleatoria.
     */

    DesplazadorDeTexto desplazadorDeTexto = new DesplazadorDeTexto();

    public String encriptarTexto(String textoSinEncriptar, int clave) {
        String textoEncriptado = desplazadorDeTexto.desplazarTexto(textoSinEncriptar, clave);
        return textoEncriptado;
    }
}
