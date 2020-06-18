package ec.edu.calculadora.model;

import android.util.Log;
import android.view.View;

import java.math.BigDecimal;
import java.math.RoundingMode;

import ec.edu.calculadora.R;
import ec.edu.calculadora.interfaces.Calculadora;

/**
 * @author Enso Vera
 * @author Diego Yacelga
 */

public class CalculadoraModel implements Calculadora.Model {

    private Operaciones operaciones;
    private Calculadora.Presenter presenter;
    private String clickOpe;
    private Numero numero;
    private Boolean rec;

    public CalculadoraModel(Calculadora.Presenter presenter){
        this.presenter=presenter;
        this.operaciones = new Operaciones();
        this.clickOpe = "N";
        this.numero = new Numero();
        this.rec = false;
    }

    @Override
    public void calculadora(String data) {
        this.numero = new Numero();
        numero.setNumero(Double.parseDouble(data));
        operaciones.setNumero(numero);
        if(operaciones.getOperacion()!=""){
            calcular();
        }
    }
    /**
     * @param view la vista con la que se va a interactuar
     * @param data Un dato tipo string con el que se identifica el tipo de operacion
     */
    @Override
    public void operacion(View view, String data) {
        switch (view.getId()){
            case R.id.btnSumar:
                operaciones.setOperacion("+");
                break;
            case R.id.btnRestar:
                operaciones.setOperacion("-");
                break;
            case R.id.btnMultiplicar:
                operaciones.setOperacion("*");
                break;
            case R.id.btnDividir:
                operaciones.setOperacion("/");
                break;
            case R.id.btnExponencial:
                operaciones.setOperacion("^");
                break;
            case R.id.btnFactorial:
                operaciones.setOperacion("fact");
                break;
            case R.id.btnMod:
                operaciones.setOperacion("%");
                break;
            case R.id.btnSeno:
                operaciones.setOperacion("sen");
                break;
            case R.id.btnRaiz:
                operaciones.setOperacion("sqrt");
                break;
            case R.id.btnCos:
                operaciones.setOperacion("cos");
                break;
            case R.id.btnBinario:
                operaciones.setOperacion("bin");
                break;
            case R.id.btnOctal:
                operaciones.setOperacion("oct");
                break;
            case R.id.btnHexadecimal:
                operaciones.setOperacion("hex");
                break;

        }

        OperacionesShow(data);
    }

    public void OperacionesShow(String data){
        if(operaciones.getResultado()==null){
            if(!operaciones.getOperacion().equals("sen")&&!operaciones.getOperacion().equals("sqrt")&&!operaciones.getOperacion().equals("fact")&&!operaciones.getOperacion().equals("cos")) {
                operaciones.setOperaciones(operaciones.getOperaciones() + " " + Double.parseDouble(data) + " " + operaciones.getOperacion());
            }else{
                operaciones.setOperaciones(operaciones.getOperaciones() + " " + operaciones.getOperacion());
            }
            clickOpe = "S";
            numero.setNumero(Double.parseDouble(data));
            operaciones.setResultado(numero);
        }else{
            if(rec){
                clickOpe = "S";
                rec = false;
            }
            if(!operaciones.getOperacion().equals("sen")&&!operaciones.getOperacion().equals("sqrt")&&!operaciones.getOperacion().equals("fact")&&!operaciones.getOperacion().equals("cos")) {
                String operaciones = this.operaciones.getOperaciones();
                operaciones = operaciones.substring(0,operaciones.length()-1);
                this.operaciones.setOperaciones(operaciones+ this.operaciones.getOperacion());
            }else{
                this.operaciones.setOperaciones(this.operaciones.getOperacion());
            }
        }

        presenter.showOperations(operaciones.getOperaciones());
    }

    @Override
        public void setNumber(View number, String data) {

        switch (number.getId()) {
            case R.id.btnMC:
                numero=new Numero();
                numero.setNumero(0.0);
                operaciones.setRecord(numero);
                this.clickOpe = "S";
                rec = true;
                break;
            case R.id.btnMR:
                presenter.showDeleteChar(operaciones.getRecord().getNumero().toString());
                this.clickOpe = "S";
                rec = true;
                break;
            case R.id.btnMPlus:
                if(!data.equals("")) {
                    numero = new Numero();
                    numero.setNumero(operaciones.getRecord().getNumero()+Double.parseDouble(data));
                    operaciones.setRecord(numero);
                    this.clickOpe = "S";
                    rec = true;
                }
                break;
            case R.id.btnMLess:
                if(!data.equals("")) {
                    numero = new Numero();
                    numero.setNumero(operaciones.getRecord().getNumero()-Double.parseDouble(data));
                    operaciones.setRecord(numero);
                    this.clickOpe = "S";
                    rec = true;
                }
                break;
            case R.id.btnBinario:
                presenter.showResult(operaciones.decimalABinario(Integer.parseInt(data)));
                System.out.println("resultado: "+operaciones.decimalABinario((Integer.parseInt(data))));
                break;
            case R.id.btnOctal:
                presenter.showResult(operaciones.decimalAOctal(Integer.parseInt(data)));
                break;
            case R.id.btnHexadecimal:
                presenter.showResult(operaciones.decimalAHexadecimal(Integer.parseInt(data)));
                break;
        }

        if(clickOpe.equals("S")){
            data="";
            clickOpe ="N";
        }

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
            case R.id.btnNeg:
                if(!data.equals(""))
                    presenter.showDeleteChar(String.valueOf(Double.parseDouble(data)*-1));
                break;


        }
    }

    @Override
    public void clearResults() {
        operaciones.setResultado(null);
        operaciones.setNumero(null);
        presenter.showResult("");
    }

    @Override
    public void clearOperations() {
        operaciones.setNumero(null);
        operaciones.setOperaciones("");
        operaciones.setResultado(null);
        presenter.showOperations("");
        presenter.showResult("");
    }

    private void calcular(){
        if(operaciones.getResultado().getNumero()!=null) {
            switch (this.operaciones.getOperacion()) {
                case "+":
                    operaciones.sumar();
                    break;
                case "-":
                    operaciones.restar();
                    break;
                case "*":
                    operaciones.multiplicar();
                    break;
                case "/":
                    operaciones.dividir();
                    break;
                case "^":
                    operaciones.pow();
                    break;
                case "fact":
                    operaciones.fact();
                    break;
                case "%":
                    operaciones.mod();
                    break;
                case "sen":
                    operaciones.sen();
                    break;
                case "sqrt":
                    operaciones.raiz();
                    break;
                case "cos":
                    operaciones.cos();
                    break;

            }
            BigDecimal formatNumber = new BigDecimal(operaciones.getResultado().getNumero());
            formatNumber = formatNumber.setScale(2, RoundingMode.DOWN);
            presenter.showResult(operaciones.getResultado().getNumero().toString());

            clickOpe = "S";
            if (operaciones.getOperaciones().substring(operaciones.getOperaciones().length() - 1, operaciones.getOperaciones().length()).equals("=") && operaciones.getNumero().getNumero()!=0) {
                operaciones.setOperaciones(operaciones.getOperaciones().substring(0, operaciones.getOperaciones().length() - 1) + operaciones.getOperacion());
            }
            if(operaciones.getNumero().getNumero()!=0){
                operaciones.setOperaciones(operaciones.getOperaciones() + " " + operaciones.getNumero().getNumero() + " =");
            }
            presenter.showOperations(operaciones.getOperaciones());
        }
    }
}
