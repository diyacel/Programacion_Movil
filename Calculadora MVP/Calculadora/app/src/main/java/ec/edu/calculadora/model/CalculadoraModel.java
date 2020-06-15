package ec.edu.calculadora.model;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import ec.edu.calculadora.R;
import ec.edu.calculadora.interfaces.Calculadora;

/**
 * @author Enso Vera
 * @author Diego Yacelga
 */

public class CalculadoraModel implements Calculadora.Model {

    private CalculadoraDTO calculadoraDTO;
    private Calculadora.Presenter presenter;
    private Boolean notClickIgual;
    private String clickOpe;

    public CalculadoraModel(Calculadora.Presenter presenter){
        this.presenter=presenter;
        this.calculadoraDTO = new CalculadoraDTO();
        this.notClickIgual = true;
        this.clickOpe = "N";
        this.calculadoraDTO=new CalculadoraDTO() ;
    }

    @Override
    public void calculadora(String data) {
        calculadoraDTO.setNumero(Double.parseDouble(data));
        calcular();
        notClickIgual = false;
    }
    /**
     * @param view la vista con la que se va a interactuar
     * @param data Un dato tipo string con el que se identifica el tipo de operacion
     */
    @Override
    public void operacion(View view, String data) {
        switch (view.getId()){
            case R.id.btnSumar:
                calculadoraDTO.setOperacion("+");
                break;
            case R.id.btnRestar:
                calculadoraDTO.setOperacion("-");
                break;
            case R.id.btnMultiplicar:
                calculadoraDTO.setOperacion("*");
                break;
            case R.id.btnDividir:
                calculadoraDTO.setOperacion("/");
                break;
            case R.id.btnExponencial:
                calculadoraDTO.setOperacion("^");
                break;
            case R.id.btnFactorial:
                calculadoraDTO.setOperacion("!");
                break;
            case R.id.btnMod:
                calculadoraDTO.setOperacion("%");
                break;
            case R.id.btnSeno:
                calculadoraDTO.setOperacion("sen");
                break;
            case R.id.btnRaiz:
                calculadoraDTO.setOperacion("sqrt");
                break;
        }

        if(calculadoraDTO.getResultado()==null){
            if(!calculadoraDTO.getOperacion().equals("sen")||!calculadoraDTO.getOperacion().equals("sqrt")) {
                calculadoraDTO.setOperaciones(calculadoraDTO.getOperaciones() + " " + Double.parseDouble(data) + " " + calculadoraDTO.getOperacion());
            }else{
                calculadoraDTO.setOperaciones(calculadoraDTO.getOperaciones() + " " +calculadoraDTO.getOperacion());
            }
            clickOpe = "S";
            Log.d("Resetear",clickOpe);
            calculadoraDTO.setResultado(Double.parseDouble(data));
        }else{
            String operaciones = calculadoraDTO.getOperaciones();
            operaciones = operaciones.substring(0,operaciones.length()-1);
            Log.d("operaciones",operaciones);
            calculadoraDTO.setOperaciones(operaciones+calculadoraDTO.getOperacion());
            Log.d("Resetear",clickOpe);
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
        public void setNumber(View number, String data) {

        if(clickOpe.equals("S")){
            data="";
            clickOpe ="N";
        }
        Log.d("Resetear",clickOpe);

        switch (number.getId()) {
            case R.id._1:
                presenter.showDeleteChar(data+1);
                break;
            case R.id._2:
                presenter.showDeleteChar(data+2);
                break;
            case R.id._3:
                presenter.showDeleteChar(data+3);
                break;
            case R.id._4:
                presenter.showDeleteChar(data+4);
                break;
            case R.id._5:
                presenter.showDeleteChar(data+5);
                break;
            case R.id._6:
                presenter.showDeleteChar(data+6);
                break;
            case R.id._7:
                presenter.showDeleteChar(data+7);
                break;
            case R.id._8:
                presenter.showDeleteChar(data+8);
                break;
            case R.id._9:
                presenter.showDeleteChar(data+9);
                break;
            case R.id._0:
                presenter.showDeleteChar(data+0);
                break;
            case R.id.delChar:
                if(!data.equals(""))
                    presenter.showDeleteChar(data.substring(0,data.length()-1));
                break;
            case R.id.dot:
                if(data.indexOf(".")==-1)
                    presenter.showDeleteChar(data+".");
                break;

        }
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
        if(calculadoraDTO.getResultado()!=null) {
            switch (this.calculadoraDTO.getOperacion()) {
                case "+":
                    calculadoraDTO.setResultado(calculadoraDTO.sumar(calculadoraDTO.getResultado(), calculadoraDTO.getNumero()));
                    Log.d("resultado suma", calculadoraDTO.getResultado().toString());
                    break;
                case "-":
                    calculadoraDTO.setResultado(calculadoraDTO.restar(calculadoraDTO.getResultado(), calculadoraDTO.getNumero()));
                    Log.d("resultado resta", calculadoraDTO.getResultado().toString());
                    break;
                case "*":
                    calculadoraDTO.setResultado(calculadoraDTO.multiplicar(calculadoraDTO.getResultado(), calculadoraDTO.getNumero()));
                    Log.d("resultado multiplicar", calculadoraDTO.getResultado().toString());
                    break;
                case "/":
                    calculadoraDTO.setResultado(calculadoraDTO.dividir(calculadoraDTO.getResultado(), calculadoraDTO.getNumero()));
                    Log.d("resultado dividir", calculadoraDTO.getResultado().toString());
                    break;
                case "^":
                    calculadoraDTO.setResultado(calculadoraDTO.exponenciar(calculadoraDTO.getResultado(), calculadoraDTO.getNumero()));
                    Log.d("resultado exponencial", calculadoraDTO.getResultado().toString());
                    break;
                case "!":
                    calculadoraDTO.setResultado(calculadoraDTO.factorial(calculadoraDTO.getNumero()));
                    Log.d("resultado Factorial", calculadoraDTO.getResultado().toString());
                    break;
                case "%":
                    //calculadoraDTO.setResultado(calculadoraDTO.factorial(calculadoraDTO.getNumero()));
                    //Log.d("resultado Factorial",calculadoraDTO.getResultado().toString());
                    break;
                case "sen":
                    calculadoraDTO.setResultado(calculadoraDTO.seno(calculadoraDTO.getNumero()));
                    Log.d("seno", calculadoraDTO.getResultado().toString());
                    break;
                case "sqrt":
                    calculadoraDTO.setResultado(calculadoraDTO.findSquareRoot(calculadoraDTO.getNumero()));
                    Log.d("sqrt", calculadoraDTO.getResultado().toString());
                    break;
            }
            presenter.showResult(calculadoraDTO.getResultado().toString());
            //calculadoraDTO.setOperacion("=");
            clickOpe = "S";
            if (calculadoraDTO.getOperaciones().substring(calculadoraDTO.getOperaciones().length() - 1, calculadoraDTO.getOperaciones().length()).equals("=") && calculadoraDTO.getNumero()!=0) {
                calculadoraDTO.setOperaciones(calculadoraDTO.getOperaciones().substring(0, calculadoraDTO.getOperaciones().length() - 1) + calculadoraDTO.getOperacion());
            }

            if(calculadoraDTO.getNumero()!=0){
                calculadoraDTO.setOperaciones(calculadoraDTO.getOperaciones() + " " + calculadoraDTO.getNumero() + " =");
            }

            presenter.showOperations(calculadoraDTO.getOperaciones());
        }
    }
}
