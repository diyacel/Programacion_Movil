package ec.edu.calculadora.model;

import android.util.Log;

import java.util.HashMap;
import java.util.List;

public class CalculadoraDTO {
    private Double resultado;
    private Double numero;
    private String operacion;
    private String operaciones;

    public CalculadoraDTO() {
        resultado = null;
        numero = 0.0;
        operacion="";
        operaciones = "";
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(String operaciones) {
        this.operaciones = operaciones;
    }

    public Double getNumero() {
        return numero;
    }

    public void setNumero(Double numero) {
        this.numero = numero;
    }

    public double sumar(double a,double b)
    {
        return a+b;
    }
    public double restar(double a,double b)
    {
        return a-b;
    }
    public double multiplicar(double a,double b)
    {
        return a*b;
    }
    public double dividir(double a, double b)
    {
        return a/b;
    }
    public double exponenciar(double a, double b)
    {
        return Math.pow(a,b);
    }
    public double factorial (double numero) {
        if (numero==0)
            return 1;
        else
            return numero * factorial(numero-1);
    }

    public double seno (double numero) {
        double angulo = Math.toRadians(numero);

        double sumando, sumatoria = 0, precision = 0.0001d;

        // limite superior, iteracion de la sumatoria
        int n = 0;

        do {
            sumando = Math.pow(-1, n) / factorial2(2 * n) * Math.pow(angulo, 2 * n);
            sumatoria = sumatoria + sumando;
            n = n + 1;
        } while (Math.abs(sumando) > precision);

        return sumatoria;
    }

    static double factorial2(int numero) {
        double factorial = 1.0d;

        while (numero != 0) {
            factorial *= numero--;
        }

        return factorial;
    }

    public static double findSquareRoot(double number)
    {
        boolean isPositiveNumber = true;
        double g1;
        if(number==0)
        {
            Log.d("raiz","Square root of "+number+" = "+0);
            return 0;
        }

        //If the number given is a -ve number
        else if(number<0)
        {
            number=-number;
            isPositiveNumber = false;
        }

        //Proceeding to find out square root of the number
        double squareRoot = number/2;
        do
        {
            g1=squareRoot;
            squareRoot = (g1 + (number/g1))/2;
        }
        while((g1-squareRoot)!=0);

        //Displays square root in the case of a positive number
        if(isPositiveNumber)
        {
            return squareRoot;
        }
        //Displays square root in the case of a -ve number
        else
        {
            return squareRoot * -1;
        }

    }


    @Override
    public String toString() {
        return "CalculadoraDTO{" +
                "resultado=" + resultado +
                ", numero=" + numero +
                ", operacion='" + operacion + '\'' +
                ", operaciones='" + operaciones + '\'' +
                '}';
    }

}
