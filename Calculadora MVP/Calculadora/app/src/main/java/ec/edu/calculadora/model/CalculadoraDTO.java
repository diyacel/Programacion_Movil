package ec.edu.calculadora.model;

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
