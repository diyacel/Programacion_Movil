package ec.edu.calculadora.model;

/**
 * @author Eduardo Vera
 * @author Diego Yacelga
 */

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * Clase que contiene los metodos para realizar las operaciones de la calculadora
 */
public class Operaciones {
    private Numero resultado;
    private Numero numero;
    private Numero record;
    private String operacion;
    private String operaciones;
    public static String mensaje="";

    /**
     * Método constructor de Operaciones
     */
    public Operaciones() {
        operacion="";
        operaciones = "";
        record = new Numero();
        record.setNumero(0.0);
    }

    /**
     * Método que recupera el numero ingresado en pantalla
     * @return      Devuelve el valor ingresado en pantalla
     */
    public Numero getNumero() {
        return numero;
    }

    /**
     * Método que setea el numero ingresado en pantalla
     * @param numero       Contiene el valor ingresado en pantalla
     */
    public void setNumero(Numero numero) {
        this.numero = numero;
    }

    /**
     * Método que devuelve el resultado obtenido en las operaciones
     * @return      Devuelve resultado obtenido en las operaciones
     */
    public Numero getResultado() {
        return resultado;
    }

    /**
     * Método que setea el resultado obtenido de las operaciones
     * @param resultado     Contiene el resultado obtenido en las operaciones
     */
    public void setResultado(Numero resultado) {
        this.resultado = resultado;
    }

    /**
     * Método que devuelve la operacion selecciona en la vista
     * @return     Devuelve la operacion seleccionada
     */
    public String getOperacion() {
        return operacion;
    }

    /**
     * Método que setea la operacion selecciona en la vista
     * @param operacion     Contiene la operacion selecciona en la vista
     */
    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    /**
     * Método que devuelve el valor de la memoria
     * @return      Devuelve el valor de la memoria
     */
    public Numero getRecord() {
        return record;
    }

    /**
     * Método que setea el valor de la memoria
     * @param record      Contiene el valor a guardar en la memoria
     */
    public void setRecord(Numero record) {
        this.record = record;
    }

    /**
     * Método que devuelve el historial de operaciones
     * @return      Devuelve el historial de operaciones
     */
    public String getOperaciones() {
        return operaciones;
    }

    /**
     * Método que devuelve el historial de operaciones
     * @param operaciones       ontiene el historial de operaciones
     */
    public void setOperaciones(String operaciones) {
        this.operaciones = operaciones;
    }

    /**
     * Método llamada por el modelo que invoca al metodo que calcula la suma
     */
    public void sumar()
    {
        resultado.setNumero(resultado.getNumero()+numero.getNumero());
    }

    /**
     * Método llamada por el modelo que invoca al metodo que calcula la resta
     */
    public void restar()
    {
        resultado.setNumero(resultado.getNumero()-numero.getNumero());
    }

    /**
     * Método llamada por el modelo que invoca al metodo que calcula la multiplicacion
     */
    public void multiplicar()
    {
        resultado.setNumero(resultado.getNumero()*numero.getNumero());
    }

    /**
     * Método llamada por el modelo que invoca al metodo que calcula la division
     */
    public void dividir()
    {
        resultado.setNumero(division(resultado.getNumero(),numero.getNumero()));
    }

    /**
     * Método llamada por el modelo que invoca al metodo que calcula la raiz
     */
    public void raiz(){
       resultado.setNumero(findSquareRoot(resultado.getNumero())) ;
    }

    /**
     * Método llamada por el modelo que invoca al metodo que calcula el factorial
     */
    public void fact(){
        resultado.setNumero(factorial(resultado.getNumero()));
    }

    /**
     * Método llamada por el modelo que invoca al metodo que calcula el exponencial
     */
    public void pow(){
        resultado.setNumero(exponencial(resultado.getNumero(),numero.getNumero()));
    }

    /**
     * Método llamada por el modelo que invoca al metodo que calcula el seno
     */
    public void sen(){
        resultado.setNumero(seno(Math.toRadians(resultado.getNumero())));
    }

    /**
     * Método llamada por el modelo que invoca al metodo que calcula el coseno
     */
    public void cos(){
        resultado.setNumero(coseno(Math.toRadians(resultado.getNumero())));
    }

    /**
     * Método llamada por el modelo que invoca al metodo que calcula el modulo
     */
    public void mod(){
        resultado.setNumero(modulo(resultado.getNumero(),numero.getNumero()));
    }

    /**
     * Método llamada por el modelo que invoca al metodo que calcula el logaritmo
     */
    public void logaritmo(){
        resultado.setNumero(log(numero.getNumero()));
    }

    /**
     * Método que calcula el exponencial
     * @param a     Valor que contiene el numero ingresado base
     * @param b     Valor que contiene el numero ingresado exponente
     * @return
     */
    public Double exponencial(double a, double b)
    {
        double power = 1;
        for(double c=0;c<b;c++)
            power*=a;

        return power;
    }

    /**
     * Método que calcula el seno
     * @param angulo    Valor que contiene el numero ingresado
     * @return
     */
    public Double seno(Double angulo) {
        //double angulo = Math.toRadians(numero);

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

    /**
     * Método que obtiene la division de dos numeros
     * @param n1    Valor que contiene el numero ingresado del dividendo
     * @param n2    Valor que contiene el numero ingresado del divisor
     * @return
     */
    public Double division(Double n1,Double n2)
    {
        if(n2==0)
        {
            mensaje="No existe division para 0";
            return 0.00;
        }
        else
        {
            return n1/n2;
        }
    }

    /**
     * Método que calcula el coseno
     * @param angulo      Valor que contiene el numero ingresado
     * @return
     */
    public Double coseno(Double angulo) {
       // Double angulo = Math.toRadians(numero);

        Double sumando, sumatoria = 0.0, precision = 0.000001d;

        int n = 0;

        do {
            sumando = exponencial(-1, n) / factorial2(2.0 * n) * exponencial(angulo, 2 * n);
            sumatoria = sumatoria + sumando;
            n = n + 1;
        } while (Math.abs(sumando) > precision);

        return sumatoria;
    }

    /**
     * Método que calcula el factorial de un numero
     * @param numero    Valor que contiene el numero ingresado
     * @return
     */
    static Double factorial(Double numero) {
        double factorial = 1.0d;
        //numero=-6.00;
        if(numero<0)
        {
            mensaje="No existe factorial de numeros negativos";
            return 0.00;
        }
        else{
            System.out.println("positivo");
            while (numero != 0) {
                factorial *= numero--;
            }
        }

        return factorial;
    }

    /**
     * Método que calcula el factorial de un numero
     * @param numero    Valor que contiene el numero ingresado
     * @return
     */
    static double factorial2(double numero) {
        double factorial = 1.0d;

        while (numero != 0) {
            factorial *= numero--;
        }

        return factorial;
    }

    /**
     * Método que calcula la raiz cuadrada de un numero
     * @param number    Valor que contiene el numero ingresado
     * @return
     */
    public Double findSquareRoot(Double number)
    {
        boolean isPositiveNumber = true;
        Double g1;
        //number=-25.00;
        if(number==0)
        {
            return 0.0;
        }

        else if(number<0)
        {
            number=-number;
            isPositiveNumber = false;
            mensaje="No existe raiz real de números negativos";
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
            return 0.00;

        }
    }

    /**
     * Método que obtiene el modulo de una division
     * @param num1      Valor que contiene el numero del dividendo
     * @param num2      Valor que contiene el numero del divisor
     * @return
     */
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

    /**
     * Método que convierte un decimal a Hexadecimal
     * @param decimal       Valor que contiene el numero ingresado
     * @return
     */
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

    /**
     * Método que convierte un decimal a octal
     * @param decimal       Valor que contiene el numero ingresado
     * @return
     */
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

    /**
     * Método que convierte un numero decimal a binario
     * @param numero      Valor que contiene el numero ingresado
     * @return
     */
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

    /**
     * Método que calcula el logaritmo natural
     * @param n1      Valor que contiene el numero ingresado
     * @return
     */
    public Double log(double n1)
    {
        //n1=-30;
        if(n1<=0)
        {
            mensaje="No se puede calcular el logaritmo de numeros negativos, ni de cero";
            return 0.00;
        }
        else{
            return Math.log10(n1);
        }

    }

    /**
     * Método que calcula los puntos que x,y que van a ser graficados
     * @param function      Componente que dibuja en pantalla el grafico
     * @param grados        Valor que contiene los grados ingresados
     * @param ope           Contiene la operacion selecciona
     * @return
     */
    public LineGraphSeries<DataPoint> graficar(GraphView function, String grados, String ope)
    {
        double x, y,number;
        x = 0;
        y = 0;
        number=Math.toRadians(Double.parseDouble(grados));
        LineGraphSeries<DataPoint> series;

        function.getViewport().setScrollable(true);
        function.getViewport().setScrollableY(true);

        function.getViewport().setScalable(false);
        function.getViewport().setScalableY(true);

        function.getViewport().setXAxisBoundsManual(true);
        function.getViewport().setMinX(-1);
        function.getViewport().setMaxX(Math.abs(number)+2);
        function.getViewport().setMaxY(2);
        function.getViewport().setMaxY(-2);
        series = new LineGraphSeries<DataPoint>();

        for(double i=0.01; i<number;i+=0.01){
            if(ope.equals("sen")) {
                y = seno(x);
            }
            if(ope.equals("cos")) {
                y = coseno(x);
            }
            x+=0.01;
            series.appendData(new DataPoint(x,y),true,5000);
        }
        return series;
    }
}
