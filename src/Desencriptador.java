public class Desencriptador {

    /*
    Se crean los objetos de tipo BuscadorDeClavePorFuerzaBruta y DesplazadorDeTexto para poder llamar a sus respectivos
    metodos, el primero me devuelve la clave, que se utiliza de forma negativa para desplazar el texto en la direccion
    contraria.
     */
    DesplazadorDeTexto desplazadorDeTexto = new DesplazadorDeTexto();
    BuscadorDeClavePorFuerzaBruta buscadorDeClavePorFuerzaBruta = new BuscadorDeClavePorFuerzaBruta();

    public String desencriptarTexto(String textoEncriptado) {
        int clave = buscadorDeClavePorFuerzaBruta.buscarClavePorFuerzaBruta(textoEncriptado);
        int claveNegativa = - clave;
        String textoDesencriptado = desplazadorDeTexto.desplazarTexto(textoEncriptado, claveNegativa);

        return textoDesencriptado;
    }
}
