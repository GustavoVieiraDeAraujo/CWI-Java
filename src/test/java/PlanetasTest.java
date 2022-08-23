import org.junit.Assert;
import org.junit.Test;
import planetas.Planetas;

import java.util.ArrayList;
import java.util.Arrays;

public class PlanetasTest {

    @Test
    public void deveTerValorTotalQuandoExistirRecursosNoPlaneta(){
        Planetas terra = new Planetas(3,new ArrayList<>(Arrays.asList("Agua", "Silicio", "Ouro")));
        int valorTotal = terra.valorTotal();

        Assert.assertEquals(360,valorTotal);
    }

    @Test
    public void deveTerValorPorPesoQuandoExistirRecursosNoPlaneta(){
        Planetas terra = new Planetas(3,new ArrayList<>(Arrays.asList("Agua", "Silicio", "Ouro")));
        int valorPorPeso = terra.valorPorPeso();

        Assert.assertEquals(25,valorPorPeso);
    }

    @Test
    public void  deveTerValorTotalZeradoQuandoNaoExistirNenhumRecurso() {
        Planetas terra = new Planetas(3, new ArrayList<>());
        int valorTotal = terra.valorTotal();

        Assert.assertEquals(0, valorTotal);
    }

    @Test
    public void  deveTerValorPorPesoZeradoQuandoNaoExistirNenhumRecurso() {
        Planetas terra = new Planetas(3, new ArrayList<>());
        int valorPorPeso = terra.valorPorPeso();

        Assert.assertEquals(0, valorPorPeso);
    }

}
