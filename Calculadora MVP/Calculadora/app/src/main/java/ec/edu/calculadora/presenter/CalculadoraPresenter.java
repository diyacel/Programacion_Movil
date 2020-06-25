package ec.edu.calculadora.presenter;

/**
 * @author Eduardo Vera
 * @author Diego Yacelga
 */


import android.view.View;
import ec.edu.calculadora.interfaces.Calculadora;
import ec.edu.calculadora.model.CalculadoraModel;

/**
 * Clase que implementa las funciones que permiten la comunicacion entre la vista y el modelo
 */
public class CalculadoraPresenter implements Calculadora.Presenter{

    private Calculadora.View view;
    private Calculadora.Model model;

    /**
     * Método constructor del presentador
     * @param view      Contiene la vista con los componentes de la calculadora
     */
    public CalculadoraPresenter(Calculadora.View view){
        this.view = view;
        model = new CalculadoraModel(this);

    }

    /**
     * Llama al método de la vista que muestra el resultado de las operaciones
     * @param result    Resultado de una de las operaciones
     */
    @Override
    public void showResult(String result) {
        if(view!=null){
            view.showResult(result);
        }
    }

    /**
     * LLama al método del modelo que realiza el calculo de las operaciones
     * @param data     Número ingresado en pantalla para realizar el calculo
     */
    @Override
    public void calculadora(String data) {
        if(view!=null && !data.equals("")){
            model.calculadora(data);
        }
    }

    /**
     * Llama al método del modelo que setea la operacion a realizar
     * @param view     Vista que contiene los componentes de la calculadora
     * @param data     Número ingresado en pantalla para realizar el calculo
     */
    @Override
    public void operacion(android.view.View view, String data) {
        if(view!=null && !data.equals("")){
            model.operacion(view, data);
        }
    }

    /**
     * Llama al método del modelo que concatena los numeros ingresados en la calculadora
     * @param number    Vista que contiene los componentes de la calculadora
     * @param data      Número ingresado en pantalla para realizar el calculo
     */
    @Override
    public void setNumber(View number, String data) {
        if(view!=null){
            model.setNumber(number, data);
        }
    }

    /**
     * Llama al método de la vista que muestra el historial de operaciones
     * @param operations    Valor que almacena las operaciones realizadas
     */
    @Override
    public void showOperations(String operations) {
        if(view!=null){
            view.showOperations(operations);
        }
    }

    /**
     * Llama al método de la vista que muestra el borrado caracter por caracter de numeros ingresados
     * @param result     Valor que almacena los numeros ingresados
     */
    @Override
    public void showDeleteChar(String result) {
        if(view!=null) {
            view.showDeleteChar(result);
        }
    }

    /**
     * Llama al método del modelo que borra los resultados en pantalla
     */
    @Override
    public void clearResults() {
        if(view!=null){
            model.clearResults();
        }
    }

    /**
     * Llama al métododel modelo que borra el hitorial de operaciones y los resultados en pantalla
     */
    @Override
    public void clearOperations() {
        if(view!=null){
            model.clearOperations();
        }
    }

    /**
     * Llama al método de la vista que muestra las validaciones realizadas en la calculadora
     * @param data     Valor que contiene los mensajes a mostrar
     */
    @Override
    public void validar(String data) {
        if(view!=null) {
            view.validar(data);
        }
    }
}
