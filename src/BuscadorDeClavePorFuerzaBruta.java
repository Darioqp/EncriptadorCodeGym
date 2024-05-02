public class BuscadorDeClavePorFuerzaBruta {
    /*
    Esta clase contiene un metodo que nos retorna la clave que se utilizo para la encriptacion, dicho metodo es
    utilizado en la clase Desencriptador.
    El metodo de esta clase define un array de String que contiene palabras en espanol de dos letras y contiene un ciclo
    for anidado, el primero evaluando posibles claves entre 1 y 26 y el segundo para comprobar si el texto desplazado
    negativamente, contiene alguna palabra en espanol.
     */

    DesplazadorDeTexto desplazadorDeTexto = new DesplazadorDeTexto();
    public int buscarClavePorFuerzaBruta(String textoEncriptado) {
        int clave = 0;
        String[] palabrasEnEspanol = new String[] {" el ", " lo ", " al ", " no ", " si ", " es ", " un ", " de ", " la "};

        for (int i = 1; i < 27; i++) {
            String posibleTextoDesencriptado = desplazadorDeTexto.desplazarTexto(textoEncriptado, -i);
            for (int j = 0; j < palabrasEnEspanol.length; j++) {
                if (posibleTextoDesencriptado.contains(palabrasEnEspanol[j])) {
                    clave = i;
                    break;
                }
            }
        }
        return clave;
    } 
}
