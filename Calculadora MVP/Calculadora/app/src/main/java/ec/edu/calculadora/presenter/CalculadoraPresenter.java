package ec.edu.calculadora.presenter;

import android.view.View;

import ec.edu.calculadora.interfaces.Calculadora;
import ec.edu.calculadora.model.CalculadoraModel;



public class CalculadoraPresenter implements Calculadora.Presenter{

    private Calculadora.View view;
    private Calculadora.Model model;

    public CalculadoraPresenter(Calculadora.View view){
        this.view = view;
        model = new CalculadoraModel(this);
    }

    @Override
    public void showResult(String result) {
        if(view!=null){
            view.showResult(result);
        }
    }

    @Override
    public void calculadora(String data) {
        if(view!=null && !data.equals("")){
            model.calculadora(data);
        }
    }

    @Override
    public void operacion(android.view.View view, String data) {
        if(view!=null && !data.equals("")){
            model.operacion(view, data);
        }
    }

    @Override
    public void setNumber(View number, String data) {
        if(view!=null){
            model.setNumber(number, data);
        }
    }

    @Override
    public void showOperations(String operations) {
        if(view!=null){
            view.showOperations(operations);
        }
    }

    @Override
    public void showDeleteChar(String result) {
        if(view!=null) {
            view.showDeleteChar(result);
        }
    }

    @Override
    public void clearResults() {
        if(view!=null){
            model.clearResults();
        }
    }

    @Override
    public void clearOperations() {
        if(view!=null){
            model.clearOperations();
        }
    }
}
