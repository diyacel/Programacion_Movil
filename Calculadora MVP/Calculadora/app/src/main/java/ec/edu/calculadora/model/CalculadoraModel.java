package ec.edu.calculadora.model;

import android.util.Log;
import android.widget.Toast;

import ec.edu.calculadora.R;
import ec.edu.calculadora.interfaces.Calculadora;

/**
 * Created by albertopalomarrobledo on 7/7/17.
 */

public class CalculadoraModel implements Calculadora.Model {

    private CalculadoraDTO calculadoraDTO;
    private Calculadora.Presenter presenter;
    private Boolean notClickIgual;

    public CalculadoraModel(Calculadora.Presenter presenter){
        this.presenter=presenter;
        this.calculadoraDTO = new CalculadoraDTO();
        this.notClickIgual = true;
    }

    @Override
    public void calculadora(String data) {
        calculadoraDTO.setNumero(Double.parseDouble(data));
        calcular();
        //calculadoraDTO.setOperacion("");
        notClickIgual = false;
        //resultado= Double.valueOf(data)* Double.valueOf(data);
    }

    @Override
    public void operacion(android.view.View view, String data) {

        switch (view.getId()){
            case R.id.btnSumar:
                calculadoraDTO.setOperacion("+");
                Log.d("sumar","+");
                break;
            case R.id.btnRestar:
                calculadoraDTO.setOperacion("-");
                Log.d("restar","-");
                break;
            case R.id.btnMultiplicar:
                calculadoraDTO.setOperacion("*");
                Log.d("multiplicar","*");
                break;
            case R.id.btnDividir:
                calculadoraDTO.setOperacion("/");
                Log.d("dividir","/");
                break;
        }

        if(calculadoraDTO.getResultado()==null){
            calculadoraDTO.setOperaciones(calculadoraDTO.getOperaciones()+" "+Double.parseDouble(data)+" "+calculadoraDTO.getOperacion());
            calculadoraDTO.setResultado(Double.parseDouble(data));
        }else{
            String operaciones = calculadoraDTO.getOperaciones();
            operaciones = operaciones.substring(0,operaciones.length()-1);
            Log.d("operaciones",operaciones);
            calculadoraDTO.setOperaciones(operaciones+calculadoraDTO.getOperacion());
        }

        presenter.showOperations(calculadoraDTO.getOperaciones());
        /*if(!notClickIgual){
            if(!calculadoraDTO.getNumero().equals(Double.parseDouble(data))){
                notClickIgual = true;
            }
        }

        if(calculadoraDTO.getResultado()==null){
            calculadoraDTO.setResultado(Double.parseDouble(data));
            calculadoraDTO.setOperaciones(calculadoraDTO.getOperaciones()+" "+Double.parseDouble(data)+" "+calculadoraDTO.getOperacion());
            presenter.showOperations(calculadoraDTO.getOperaciones());
        }else{
            calculadoraDTO.setNumero(Double.parseDouble(data));
            if(notClickIgual){
                calcular();
            }
        }*/

        //Log.d("resultado",calculadoraDTO.getResultado().toString());
    }

    @Override
    public void clearResults() {
        Log.d("clearResults","clearResults");
        calculadoraDTO.setResultado(0.0);
        calculadoraDTO.setNumero(0.0);
        presenter.showResult("");
    }

    @Override
    public void clearOperations() {
        Log.d("clearResults","clearResults");
        calculadoraDTO.setNumero(0.0);
        calculadoraDTO.setOperaciones("");
        calculadoraDTO.setResultado(null);
        presenter.showOperations("");
        presenter.showResult("");
    }

    private void calcular(){
        switch (this.calculadoraDTO.getOperacion()){
            case "+":
                calculadoraDTO.setResultado(calculadoraDTO.getResultado() + calculadoraDTO.getNumero());
                Log.d("resultado suma",calculadoraDTO.getResultado().toString());
                break;
            case "-":
                calculadoraDTO.setResultado(calculadoraDTO.getResultado() - calculadoraDTO.getNumero());
                Log.d("resultado resta",calculadoraDTO.getResultado().toString());
                break;
            case "*":
                calculadoraDTO.setResultado(calculadoraDTO.getResultado() * calculadoraDTO.getNumero());
                Log.d("resultado multiplicar",calculadoraDTO.getResultado().toString());
                break;
            case "/":
                calculadoraDTO.setResultado(calculadoraDTO.getResultado() / calculadoraDTO.getNumero());
                Log.d("resultado dividir",calculadoraDTO.getResultado().toString());
                break;
        }
        presenter.showResult(calculadoraDTO.getResultado().toString());
        calculadoraDTO.setOperacion("=");
        calculadoraDTO.setOperaciones(calculadoraDTO.getOperaciones()+" "+calculadoraDTO.getNumero()+" "+calculadoraDTO.getOperacion());
        presenter.showOperations(calculadoraDTO.getOperaciones());
    }
}
