import nave.Nave;
import org.junit.Assert;
import org.junit.Test;
import planetas.Planetas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NaveTest {

    @Test
    public void deveFicarADerivaQuandoFaltarCombustivelParaIrAteUmPlaneta() {
        Nave milleniumFalcon = new Nave(9);
        Planetas tatooine = new Planetas(4, new ArrayList<>());

        milleniumFalcon.explorar(tatooine);
        int posicaoResultante = milleniumFalcon.getPosicao();

        Assert.assertEquals(3, posicaoResultante);
    }

    @Test
    public void deveFicarADerivaQuandoFaltarCombustivelParaIrAteVariosPlaneta() {
        Nave milleniumFalcon = new Nave(10);

        Planetas marte = new Planetas(1, new ArrayList<>(Arrays.asList("Agua", "Silicio", "Ouro")));
        Planetas venus = new Planetas(2, new ArrayList<>(Arrays.asList("Ferro", "Silicio", "Ouro")));
        Planetas mercurio = new Planetas(3, new ArrayList<>(Arrays.asList("Ouro", "Oxigenio", "Ouro")));
        Planetas plutao = new Planetas(4, new ArrayList<>(Arrays.asList("Oxigenio", "Agua", "Ferro")));


        milleniumFalcon.explorar(new ArrayList<Planetas>(Arrays.asList(marte,venus,mercurio,plutao)));
        int posicaoResultante = milleniumFalcon.getPosicao();

        Assert.assertEquals(3, posicaoResultante);
    }

    @Test
    public void deveViajarPorTodosOsPlanetasEVoltarParaOrigem() {
        Nave milleniumFalcon = new Nave(100000);

        Planetas marte = new Planetas(1, new ArrayList<>(Arrays.asList("Agua", "Silicio", "Ouro")));
        Planetas venus = new Planetas(2, new ArrayList<>(Arrays.asList("Ferro", "Silicio", "Ouro")));
        Planetas mercurio = new Planetas(3, new ArrayList<>(Arrays.asList("Ouro", "Oxigenio", "Ouro")));
        Planetas plutao = new Planetas(4, new ArrayList<>(Arrays.asList("Oxigenio", "Agua", "Ferro")));


        milleniumFalcon.explorar(new ArrayList<Planetas>(Arrays.asList(marte,venus,mercurio,plutao)));
        int posicaoResultante = milleniumFalcon.getPosicao();

        Assert.assertEquals(0, posicaoResultante);
    }

    @Test
    public void deveViajarAtéUmPlanetaEVoltarParaOrigem() {
        Nave milleniumFalcon = new Nave(30);
        Planetas tatooine = new Planetas(4, new ArrayList<>());

        milleniumFalcon.explorar(tatooine);
        int posicaoResultante = milleniumFalcon.getPosicao();

        Assert.assertEquals(0, posicaoResultante);
    }

    @Test
    public void deveExplorarTodosOsRecursosQuandoViajarAteUmPlaneta() {
        Nave milleniumFalcon = new Nave(30);
        Planetas plutao = new Planetas(4, new ArrayList<>(Arrays.asList("Oxigenio", "Agua", "Ferro")));

        List<String> recursosExplorados = milleniumFalcon.explorar(plutao);
        List<String> recursosExploradosEsperados = new ArrayList<>(Arrays.asList("Oxigenio", "Agua", "Ferro"));

        Assert.assertEquals(recursosExploradosEsperados,recursosExplorados);
    }

    @Test
    public void deveExplorarTodosOsRecursosQuandoViajarPorVariosPlanetas() {
        Nave milleniumFalcon = new Nave(100000);

        Planetas marte = new Planetas(1, new ArrayList<>(Arrays.asList("Agua", "Silicio", "Ouro")));
        Planetas venus = new Planetas(2, new ArrayList<>(Arrays.asList("Ferro", "Silicio", "Ouro")));
        Planetas mercurio = new Planetas(3, new ArrayList<>(Arrays.asList("Ouro", "Oxigenio", "Ouro")));
        Planetas plutao = new Planetas(4, new ArrayList<>(Arrays.asList("Oxigenio", "Agua", "Ferro")));


        List<String> recursosExplorados = milleniumFalcon.explorar(new ArrayList<Planetas>(Arrays.asList(marte,venus,mercurio,plutao)));
        List<String> recursosExploradosEsperados = new ArrayList<>(Arrays.asList("Agua", "Silicio", "Ouro","Ferro","Oxigenio"));

        Assert.assertEquals(recursosExploradosEsperados, recursosExplorados);
    }


}
