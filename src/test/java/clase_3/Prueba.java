package clase_3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Prueba {

    @Test
    public void primerTest(){
        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.suma(1, 2);
        //System.out.println("El resultado de la suma es: " + resultado);

        Assert.assertEquals(resultado, 3, "La suma de 1 + 2 es la incorrecta.");
        Assert.assertNotEquals(resultado, 1, "Assert Not Equals");

        Assert.assertTrue(resultado == 3, "Assert True");
        Assert.assertFalse(resultado == 1, "Assert False");

        Calculadora calculadoraNull = null;
        Assert.assertNull(calculadoraNull, "Assert Not Null");
    }

    @Test
    public void segundoTest(){
        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.suma(1, 2);
        //System.out.println("El resultado de la suma es: " + resultado);

        Assert.assertEquals(resultado, 3, "La suma de 1 + 2 es la incorrecta.");
        Assert.assertNotEquals(resultado, 1, "Assert Not Equals");

        Assert.assertTrue(resultado == 3, "Assert True");
        Assert.assertFalse(resultado == 1, "Assert False");

        Calculadora calculadoraNull = null;
        Assert.assertNull(calculadoraNull, "Assert Not Null");
    }
}
