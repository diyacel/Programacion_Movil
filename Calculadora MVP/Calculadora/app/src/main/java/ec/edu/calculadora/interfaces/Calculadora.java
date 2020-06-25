package ec.edu.calculadora.interfaces;

/**
 * @author Eduardo Vera
 * @author Diego Yacelga
 */

/**
 * Interfaces que contienen las funciones que permite la comunicacion de la vista con el modelo
 */
public interface Calculadora {

    /**
     * Contiene las funciones que van a ser implementadas en la vista
     */
    interface View{
        void showResult(String result);
        void showDeleteChar(String result);
        void showOperations(String result);
        void validar(String data);
    }

    /**
     * Contiene las funciones que van a ser implementadas en el presentador
     */
    interface Presenter{
        void showResult(String result);
        void calculadora(String data);
        void operacion(android.view.View operacion,String data);
        void setNumber(android.view.View number,String data);
        void showOperations(String result);
        void showDeleteChar(String result);
        void clearResults();
        void clearOperations();
        void validar(String data);
    }

    /**
     * Contiene las funciones que van a ser implementadas en el modelo
     */
    interface Model{
        void calculadora(String data);
        void operacion(android.view.View operacion, String data);
        void setNumber(android.view.View number,String data);
        void clearResults();
        void clearOperations();
    }

}
