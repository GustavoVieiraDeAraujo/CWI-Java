import org.junit.Assert;
import org.junit.Test;

public class NinjaTest {

    @Test
    public void deveAtualizarOChakraDoOponenteDeAcordoComODanoDoJutsoQuandoAtacar() {
        Jutsu cloneDasSombras = new Jutsu(5, 10);
        Jutsu caixãoDeAreia = new Jutsu(5, 8);

        Ninja naruto = new Ninja("Naruto", cloneDasSombras);
        Ninja gaara = new Ninja("Gaara", caixãoDeAreia);

        naruto.atacar(gaara);

        Assert.assertEquals(90, gaara.getChakra());
    }

    @Test
    public void deveAtualizarOChakraDoAtacanteDeAcordoComOCustoDoJutsoQuandoAtacar() {
        Jutsu cloneDasSombras = new Jutsu(5, 10);
        Jutsu caixãoDeAreia = new Jutsu(5, 8);

        Ninja naruto = new Ninja("Naruto", cloneDasSombras);
        Ninja gaara = new Ninja("Gaara", caixãoDeAreia);

        naruto.atacar(gaara);

        Assert.assertEquals(95, naruto.getChakra());
    }

}
