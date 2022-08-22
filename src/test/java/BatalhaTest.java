import org.junit.Assert;
import org.junit.Test;

public class BatalhaTest {

    @Test
    public void deveRetornarNinjaComJutsuMaisForteSeOsDoisGastamOMesmoChakraParaAtacar(){
        Jutsu cloneDasSombras = new Jutsu(5, 10);
        Jutsu caixãoDeAreia = new Jutsu(5, 8);

        Ninja naruto = new Ninja("Naruto", cloneDasSombras);
        Ninja gaara = new Ninja("Gaara", caixãoDeAreia);

        Batalha batalha = new Batalha();
        Ninja vencedor = batalha.lutar(naruto, gaara);

        Assert.assertSame(naruto, vencedor);
    }

    @Test
    public void deveRetornarPrimeiroNinjaComoVencedorQuandoONomeForItachi(){
        Jutsu tengaShinsei = new Jutsu(5,15);
        Jutsu amaterasu = new Jutsu(5, 15);
        Ninja madara = new Ninja("Madara",tengaShinsei);
        Ninja itachi = new Ninja("Itachi",amaterasu);

        Batalha madaraVsItachi = new Batalha();
        Ninja vencedor = madaraVsItachi.lutar(itachi,madara);

        Assert.assertEquals(itachi, vencedor);
    }

    @Test
    public void deveRetornarSegundoNinjaComoVencedorQuandoONomeForItachi(){
        Jutsu tengaShinsei = new Jutsu(5,15);
        Jutsu amaterasu = new Jutsu(5, 15);
        Ninja madara = new Ninja("Madara",tengaShinsei);
        Ninja itachi = new Ninja("Itachi",amaterasu);

        Batalha madaraVsItachi = new Batalha();
        Ninja vencedor = madaraVsItachi.lutar(madara,itachi);

        Assert.assertEquals(itachi, vencedor);
    }

    @Test
    public void deveRetornarPrimeiroNinjaComoVencedorQuandoEmpatar(){
        Jutsu rasenga = new Jutsu(5,15);
        Jutsu shinraTensei = new Jutsu(5,15);
        Ninja naruto = new Ninja("Naruto",rasenga);
        Ninja nagato =  new Ninja("Nagato",shinraTensei);

        Batalha narutoVsNagato = new Batalha();
        Ninja vencedor = narutoVsNagato.lutar(nagato, naruto);

        Assert.assertEquals(nagato, vencedor);
    }

}
