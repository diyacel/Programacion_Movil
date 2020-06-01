package presenter;

import interfaces.Calculadora;
import model.CalculadoraModel;

public class CalculadoraPresenter implements Calculadora.Presenter {

    private Calculadora.View view;
    private CalculadoraModel model;

    public CalculadoraPresenter(Calculadora.View view){
        this.view = view;
        model = new CalculadoraModel(this);
    }

    @Override
    public void showResult(String result) {
        if(view==null){
            view.showResult(result);
        }
    }

    @Override
    public void calcular(String data) {
        if(view==null){
            model.calcular(data);
        }
    }

    @Override
    public void showError(String error) {
        if(view==null){
            model.calcular(error);
        }
    }
}
