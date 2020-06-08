package ec.edu.calculadora.model;

public class CalculadoraDTO {
    private Double resultado = null;
    private Double numero = 0.0;
    private String operacion;
    private String operaciones = "";

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
