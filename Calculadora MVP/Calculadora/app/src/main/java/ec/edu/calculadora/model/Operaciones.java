package ec.edu.calculadora.model;

import android.widget.Toast;

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

    public void raiz(String mensaje){
       resultado.setNumero(findSquareRoot(resultado.getNumero(),mensaje)) ;   }

    public String fact(String mensaje){
        resultado.setNumero(factorial(resultado.getNumero(),mensaje));
        return mensaje;
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
            sumando = (exponencial(-1, n) / factorial2((2.0*n)+1)) * exponencial(angulo, (2*n)+1);
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
            sumando = exponencial(-1, n) / factorial2(2.0 * n) * exponencial(angulo, 2 * n);
            sumatoria = sumatoria + sumando;
            n = n + 1;
        } while (Math.abs(sumando) > precision);

        return sumatoria;
    }

    static Double factorial(Double numero,String estado) {
        double factorial = 1.0d;
        estado="factorial";
        estado="No se debe ingresar numeros negativos";
        if(numero<0)
            //estado="No se debe ingresar numeros negativos";
            System.out.println("negativo");
        else
            //estado="es positivo";
        System.out.println("positivo");
        while (numero != 0) {
            factorial *= numero--;
        }

        return factorial;
    }
    static Double factorial2(Double numero) {
        double factorial = 1.0d;
        if(numero<0)
        while (numero != 0) {
            factorial *= numero--;
        }

        return factorial;
    }

    public Double findSquareRoot(Double number,String estado)
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
            System.out.println("si es positivo");
            return squareRoot;
        }
        else
        {
            estado="solo debe ingresar numero positivos";
            System.out.println("numero negativo");
            return squareRoot * -1;

        }
    }

    public double modulo(double num1,double num2) {
        double residuo = num1%num2;
        if (residuo > 0 && num1 < 0) {
            residuo -= num2;
        }
        if (residuo > 0 && num2 < 0) {
            residuo+=num2;
        }
        if (residuo < 0 && num1 < 0) {
            residuo+=num2;
        }
        if (residuo < 0 && num2 < 0 && num1 < 0) {
            residuo-=num2;
        }
        return residuo;
    }

    public String decimalAHexadecimal(int decimal) {
        String hexadecimal = "";
        String caracteresHexadecimales = "0123456789ABCDEF";
        while (decimal > 0) {
            int residuo = decimal % 16;
            hexadecimal = caracteresHexadecimales.charAt(residuo) + hexadecimal; // Agregar a la izquierda
            decimal /= 16;
        }
        return hexadecimal;
    }

    public String decimalAOctal(int decimal) {
        String octal = "";// Almacenamos el número octal que será el resultado
        String caracteresOctales = "01234567";
        while (decimal > 0) {
            int residuo = decimal % 8;
            // El residuo es lo que se suma, y podemos usarlo como índice
            // Recordemos que el carácter se pone "a la izquierda", por eso
            // concatenamos el carácter y luego lo que ya lleva sumado el octal
            octal = (caracteresOctales.charAt(residuo) + octal);
            // Lo vamos dividiendo entre 8 para que en algún momento llegue a 0
            decimal /= 8;
        }
        return octal;
    }

    public String decimalABinario(int numero)
    {
        String binario="";
        if(numero>0)
        {
            while(numero>0)
            {
                if(numero%2==0)
                {
                    binario="0"+binario;
                }
                else{
                    binario="1"+binario;
                }
                numero=(int)numero/2;
            }
        }else if(numero==0)
        {
            binario="0";
        }
        return binario;

    }

}
