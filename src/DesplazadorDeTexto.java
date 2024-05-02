public class DesplazadorDeTexto {
    /*
    Esta clase contiene dos metodos, el primero es para desplazar un caracter, dada la letra y una clave, el segundo
    metodo hace uso de un ciclo for para desplazar cada uno de los caracteres de un String. Dichos caracteres se van
    almacenando en un StringBuilder que al final se convierte a String mediante el metodo toString(). EL primer
    metodo me devuelve una letra desplazada y el segundo un texto desplazado.
     */

    public char desplazarCaracter(char letra, int clave) {
        char letraDesplazada = (char) (letra + clave);
        return letraDesplazada;
    }

    public String desplazarTexto(String textoSinDesplazar, int clave) {
        String textoDesplazado;
        StringBuilder formadorTextoDesplazado = new StringBuilder();
        for (int i = 0; i < textoSinDesplazar.length(); i++) {
            char caracterSinDesplazar = textoSinDesplazar.charAt(i);
            char caracterDesplazado = desplazarCaracter(caracterSinDesplazar, clave);
            formadorTextoDesplazado.append(caracterDesplazado);
        }
        textoDesplazado = formadorTextoDesplazado.toString();
        return textoDesplazado;
    }
}
