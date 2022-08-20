import org.junit.Assert;
import org.junit.Test;

public class CalculadoraTest{

    @Test
    public void deveSomarCorretamenteQuandoOsValoresForemInteiros(){
        Calculadora calculadora = new Calculadora();
        Assert.assertEquals(8,calculadora.soma(6,2),0);
    }

    @Test
    public void deveSubtrairCorretamenteQuandoOsValoresForemInteiros(){
        Calculadora calculadora = new Calculadora();
        Assert.assertEquals(4,calculadora.subtracao(6,2),0);
    }

    @Test
    public void deveMultiplicarCorretamenteQuandoNumerosForemInteiros(){
        Calculadora calculadora = new Calculadora();
        Assert.assertEquals(12,calculadora.multiplicacao(6,2),0);
    }

    @Test
    public void deveDividirCorretamenteQuandoNumerosForemInteiros(){
        Calculadora calculadora = new Calculadora();
        Assert.assertEquals(3,calculadora.divisao(6,2),0);
    }

    @Test
    public void deveSomarCorretamenteQuandoOsValoresForemFlutuantes(){
        Calculadora calculadora = new Calculadora();
        Assert.assertEquals(8.5,calculadora.soma(5.35,3.15),0);
    }

    @Test
    public void deveSubtrairCorretamenteQuandoOsValoresForemFlutuantes(){
        Calculadora calculadora = new Calculadora();
        Assert.assertEquals(2.20,calculadora.subtracao(5.35,3.15),0.01);
    }

    @Test
    public void deveMultiplicarCorretamenteQuandoNumerosForemFlutuantes(){
        Calculadora calculadora = new Calculadora();
        Assert.assertEquals(16.8525,calculadora.multiplicacao(5.35,3.15),0);
    }

    @Test
    public void deveDividirCorretamenteQuandoNumerosPossuemPontosFlutuantes(){
        Calculadora calculadora = new Calculadora();
        Assert.assertEquals(1.7,calculadora.divisao(5.35,3.15),0.01);
    }

    @Test
    public void deveTirarRaizDeIndiceNDeUmNumeroInteiroNãoNegativo(){
        Calculadora calculadora = new Calculadora();
        Assert.assertEquals(9,calculadora.radiciacao(531441,6),0.1);
    }

    @Test
    public void deveElevarUmNumeroInteiroAUmExpoenteNãoNegativo(){
        Calculadora calculadora = new Calculadora();
        Assert.assertEquals(531441,calculadora.potenciacao(9,6),0);
    }

    @Test
    public void deveTirarRaizDeIndiceNDeUmNumeroFlutuanteNãoNegativo(){
        Calculadora calculadora = new Calculadora();
        Assert.assertEquals(1.25,calculadora.radiciacao(3.0517578125,5),0);
    }

    @Test
    public void deveElevarUmNumeroFlutuanteAUmExpoenteNãoNegativo(){
        Calculadora calculadora = new Calculadora();
        Assert.assertEquals(3.0517578125,calculadora.potenciacao(1.25,5),0);
    }

    @Test
    public void deveFazerASomaDasRaizesDeUmaEquacaoQuadraticaQuandoPassadoSeusCoeficientes(){
        Calculadora calculadora = new Calculadora();
        Assert.assertEquals(1.5,calculadora.bhaskara(2,-3,1),0);
    }
}
