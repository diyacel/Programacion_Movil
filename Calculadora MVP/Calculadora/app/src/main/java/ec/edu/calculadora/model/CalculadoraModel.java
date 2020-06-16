package ec.edu.calculadora.model;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.util.jar.JarOutputStream;

import ec.edu.calculadora.R;
import ec.edu.calculadora.interfaces.Calculadora;

/**
 * @author Enso Vera
 * @author Diego Yacelga
 */

public class CalculadoraModel implements Calculadora.Model {

    private Calculadora.Presenter presenter;
    private Boolean notClickIgual;
    private String clickOpe;
    private Numero numero;
    private Numero resultado;
    private Operacion operacion;

    public CalculadoraModel(Calculadora.Presenter presenter){
        this.presenter=presenter;
        this.notClickIgual = true;
        this.clickOpe = "N";
        operacion=new Operacion();
        numero=new Numero();
        resultado=new Numero();
    }

    @Override
    public void calculadora(String data) {
        numero.setNumero(Double.parseDouble(data));
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
                operacion.setOperacion("+");
                break;
            case R.id.btnRestar:
                operacion.setOperacion("-");
                break;
            case R.id.btnMultiplicar:
                operacion.setOperacion("*");
                break;
            case R.id.btnDividir:
                operacion.setOperacion("/");
                break;
            case R.id.btnExponencial:
                operacion.setOperacion("^");
                break;
            case R.id.btnFactorial:
                operacion.setOperacion("!");
                break;
            case R.id.btnMod:
                operacion.setOperacion("%");
                break;
            case R.id.btnSeno:
                operacion.setOperacion("sen");
                break;
            case R.id.btnRaiz:
                operacion.setOperacion("sqrt");
                break;
            case R.id.btnCos:
                operacion.setOperacion("cos");
                break;
            case R.id.btnLogaritmo:
                operacion.setOperacion("ln");
                break;
        }

        if(resultado.getNumero()==null){
            if(!operacion.getOperacion().equals("sen")||!operacion.getOperacion().equals("sqrt") ||!operacion.getOperacion().equals("cos")) {
                operacion.setOperaciones(operacion.getOperaciones() + " " + Double.parseDouble(data) + " " + operacion.getOperacion());
            }else{
                operacion.setOperaciones(operacion.getOperaciones() + " " +operacion.getOperacion());
            }
            clickOpe = "S";
            Log.d("Resetear",clickOpe);
            resultado.setNumero(Double.parseDouble(data));
        }else{
            String operaciones = operacion.getOperaciones();
            operaciones = operaciones.substring(0,operaciones.length()-1);
            Log.d("operaciones",operaciones);
            operacion.setOperaciones(operaciones+operacion.getOperacion());
            Log.d("Resetear",clickOpe);
        }

        presenter.showOperations(operacion.getOperaciones());
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
            case R.id.btnLogaritmo:
                System.out.println("holaaaaaa");
                break;

        }

    }

    @Override
    public void clearResults() {
        Log.d("clearResults","clearResults");
        resultado.setNumero(0.00);
        numero.setNumero(0.00);
        presenter.showResult("");
    }

    @Override
    public void clearOperations() {
        Log.d("clearResults","clearResults");
        numero.setNumero(0.00);
        operacion.setOperaciones("");
        resultado.setNumero(0.00);
        presenter.showOperations("");
        presenter.showResult("");
    }

    private void calcular(){
        if(resultado.getNumero()!=null) {
            switch (this.operacion.getOperacion()) {
                case "+":
                    resultado.setNumero(operacion.sumar(resultado.getNumero(),numero.getNumero()));
                    Log.d("resultado suma",resultado.getNumero().toString());
                    break;
                case "-":
                    resultado.setNumero(operacion.restar(resultado.getNumero(), numero.getNumero()));
                    Log.d("resultado resta",resultado.getNumero().toString());
                    break;
                case "*":
                    resultado.setNumero(operacion.multiplicar(resultado.getNumero(), numero.getNumero()));
                    Log.d("resultado multiplicar", resultado.getNumero().toString());
                    break;
                case "/":
                    resultado.setNumero(operacion.dividir(resultado.getNumero(), numero.getNumero()));
                    Log.d("resultado dividir", resultado.getNumero().toString());
                    break;
                case "^":
                    resultado.setNumero(operacion.exponenciar(resultado.getNumero(),numero.getNumero()));
                    Log.d("resultado exponencial", resultado.getNumero().toString());
                    break;
                case "!":
                    resultado.setNumero(operacion.factorial(numero.getNumero()));
                    Log.d("resultado Factorial", resultado.getNumero().toString());
                    break;
                case "%":
                    //calculadoraDTO.setResultado(calculadoraDTO.factorial(calculadoraDTO.getNumero()));
                    //Log.d("resultado Factorial",calculadoraDTO.getResultado().toString());
                    break;
                case "sen":
                    resultado.setNumero(operacion.seno(numero.getNumero()));
                    Log.d("seno", resultado.getNumero().toString());
                    break;
                case "sqrt":
                    resultado.setNumero(operacion.findSquareRoot(numero.getNumero()));
                    Log.d("sqrt", resultado.getNumero().toString());
                    break;
                case "cos":
                    resultado.setNumero(operacion.coseno(numero.getNumero()));
                    Log.d("coseno", resultado.getNumero().toString());
                    break;
                case "ln":
                    System.out.println("logaritmo");
                    break;

            }
            presenter.showResult(resultado.getNumero().toString());
            clickOpe = "S";
            if (operacion.getOperaciones().substring(operacion.getOperaciones().length() - 1, operacion.getOperaciones().length()).equals("=")) {
                operacion.setOperaciones(operacion.getOperaciones().substring(0, operacion.getOperaciones().length() - 1) + operacion.getOperacion());
            }
            operacion.setOperaciones(operacion.getOperaciones() + " " + numero.getNumero() + " =");

            presenter.showOperations(operacion.getOperaciones());
        }
    }
}
