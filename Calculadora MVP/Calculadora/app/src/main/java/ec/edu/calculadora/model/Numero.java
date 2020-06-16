package ec.edu.calculadora.model;

public class Numero
{
    private Double numero;

    public Numero() {
        numero=null;
    }
    public Numero(String dato)
    {
        this.numero=Double.parseDouble(dato);
    }

    public Double getNumero() {
        return numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Numero{" +
                "numero=" + numero +
                '}';
    }
}
