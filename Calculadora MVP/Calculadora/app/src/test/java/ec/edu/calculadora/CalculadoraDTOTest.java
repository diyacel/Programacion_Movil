package ec.edu.calculadora;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ec.edu.calculadora.model.CalculadoraDTO;

public class CalculadoraDTOTest extends TestCase{
    CalculadoraDTO calculadora;
    @Before
    public void inicializar()
    {
        calculadora = new CalculadoraDTO();
    }
    @Test
    public void testSuma()
    {
        inicializar();
       Assert.assertEquals(calculadora.sumar(2, 2), (2 + 2), 4);
        //assertSame("la suma fue correcta",calculadora.sumar(2,2),4);
    }
    @Test
    public void testRestaTest()
    {
        inicializar();
        Assert.assertEquals(calculadora.restar(80, 43), (80-43), 37);
    }
    @Test
    public void testMultiplicacionTest()
    {
        inicializar();
        Assert.assertEquals(calculadora.multiplicar(21, 3), (21*3), 63);
    }
    @Test
    public void testDivisionTest()
    {
        inicializar();
        Assert.assertEquals(calculadora.multiplicar(21, 3), (21/3), 7);
    }
    @Test
    public void ElevarTest()
    {
        inicializar();
        Assert.assertEquals(calculadora.multiplicar(4,2), (Math.pow(4,2)), 8);
    }
    @Test
    public void factorialTest()
    {
        inicializar();
        Assert.assertEquals(calculadora.factorial(5), 120,120);
    }

}
