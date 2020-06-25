package ec.edu.calculadora.model;

/**
 * @author Eduardo Vera
 * @author Diego Yacelga
 */

/**
 * Clase que permite la creacion de objeto tipo Numero
 */
public class Numero
{
    private Double numero;

    /**
     * Método constructor vacio
     */
    public Numero() {}

    /**
     * Método constructor de Numero
     * @param numero    Contiene el numero ingresado en la vista
     */
    public Numero(Double numero) {
        this.numero = numero;
    }

    /**
     * Método que devuelve el número ingresado en la vista
     * @return      Contiene el número ingresado en la vista
     */
    public Double getNumero() {
        return numero;
    }

    /**
     * Método que setea el numero ingresado en la vista
     * @param numero    Contiene el numero ingresado
     */
    public void setNumero(Double numero) {
        this.numero = numero;
    }

}
