package model;

import android.widget.Toast;

import interfaces.Calculadora;
import presenter.CalculadoraPresenter;

public class CalculadoraModel implements Calculadora.Model {

    private  CalculadoraPresenter presenter;
    private double resultado;

    public CalculadoraModel(CalculadoraPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void calcular(String data) {
        if(data==""){
            presenter.showError("Campo vacio");
        }else {
            resultado = Double.valueOf(data);
            presenter.showResult(String.valueOf(resultado));
        }
    }
}
