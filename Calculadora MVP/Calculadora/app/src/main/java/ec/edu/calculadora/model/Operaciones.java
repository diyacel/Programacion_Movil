package ec.edu.calculadora.model;

public class Operaciones {
    private Numero resultado;
    private Numero numero;
    private Numero record;
    private String operacion;
    private String operaciones;

    public Operaciones() {
        operacion="";
        operaciones = "";
        record = new Numero();
        record.setNumero(0.0);
    }

    public Numero getNumero() {
        return numero;
    }

    public void setNumero(Numero numero) {
        this.numero = numero;
    }

    public Numero getResultado() {
        return resultado;
    }

    public void setResultado(Numero resultado) {
        this.resultado = resultado;
    }

    public String getOperacion() {
        return operacion;
    }

    public Numero getRecord() {
        return record;
    }

    public void setRecord(Numero record) {
        this.record = record;
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

    public void sumar()
    {
        resultado.setNumero(resultado.getNumero()+numero.getNumero());
    }

    public void restar()
    {
        resultado.setNumero(resultado.getNumero()-numero.getNumero());
    }

    public void multiplicar()
    {
        resultado.setNumero(resultado.getNumero()*numero.getNumero());
    }

    public void dividir()
    {
        resultado.setNumero(resultado.getNumero()/numero.getNumero());
    }

    public void raiz(){
        resultado.setNumero(findSquareRoot(resultado.getNumero()));
    }

    public void fact(){
        resultado.setNumero(factorial(resultado.getNumero()));
    }

    public void pow(){
        resultado.setNumero(exponencial(resultado.getNumero(),numero.getNumero()));
    }

    public void sen(){
        resultado.setNumero(seno(resultado.getNumero()));
    }

    public void cos(){
        resultado.setNumero(coseno(resultado.getNumero()));
    }

    public void mod(){
        resultado.setNumero(modulo(resultado.getNumero(),numero.getNumero()));
    }

    public Double exponencial(double a, double b)
    {
        double power = 1;
        for(double c=0;c<b;c++)
            power*=a;

        return power;
    }

    public Double seno(Double numero) {
        double angulo = Math.toRadians(numero);

        double sumando, sumatoria = 0, precision = 0.00001d;
        double parteEntera=0,parteDecimal=0;
        int n = 0;

        do {
            sumando = (exponencial(-1, n) / factorial((2.0*n)+1)) * exponencial(angulo, (2*n)+1);
            sumatoria = sumatoria + sumando;
            n +=1;
        } while (Math.abs(sumando) > precision);

        return sumatoria;
    }


    public Double coseno(Double numero) {
        Double angulo = Math.toRadians(numero);

        Double sumando, sumatoria = 0.0, precision = 0.000001d;

        int n = 0;

        do {
            sumando = exponencial(-1, n) / factorial(2.0 * n) * exponencial(angulo, 2 * n);
            sumatoria = sumatoria + sumando;
            n = n + 1;
        } while (Math.abs(sumando) > precision);

        return sumatoria;
    }

    static Double factorial(Double numero) {
        double factorial = 1.0d;

        while (numero != 0) {
            factorial *= numero--;
        }

        return factorial;
    }

    public Double findSquareRoot(Double number)
    {
        boolean isPositiveNumber = true;
        Double g1;
        if(number==0)
        {
            return 0.0;
        }

        else if(number<0)
        {
            number=-number;
            isPositiveNumber = false;
        }

        Double squareRoot = number/2;
        do
        {
            g1=squareRoot;
            squareRoot = (g1 + (number/g1))/2;
        }
        while((g1-squareRoot)!=0);

        if(isPositiveNumber)
        {
            return squareRoot;
        }
        else
        {
            return squareRoot * -1;
        }
    }

    static Double modulo(Double dividendo, Double divisor){
        Double resto;
        Double cociente = 0.0;

        if(divisor <= 0){
            return 0.0;
        }
        else{
            Double y = dividendo - divisor;
            resto = dividendo;
            while (resto >= divisor) {
                resto -= divisor;
                ++cociente;
            }
            return resto;
        }
    }
}