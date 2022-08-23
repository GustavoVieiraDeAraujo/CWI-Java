import apetitefinanceiro.*;
import clube.Clube;
import jogador.*;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class JogadorTest {

    @Test
    public void deveCalcularOPreçoDoAtacanteQuandoEleFizer50GolsETemMenosDe30Anos(){
        Clube clubeteste = new Clube("Teste", 10, BigDecimal.valueOf(100));
        Jogador jogadorteste = new Atacante("Teste",27, clubeteste, 9, new Mercenario(), BigDecimal.valueOf(100), 50 );

        Assert.assertEquals(270 , jogadorteste.valorMinimoDeCompraDoJogador(),0);
    }

    @Test
    public void deveCalcularOPreçoDoAtacanteQuandoEleFizer50GolsETemMaisDe30Anos(){
        Clube clubeteste = new Clube("Teste", 10, BigDecimal.valueOf(100));
        Jogador jogadorteste = new Atacante("Teste",35, clubeteste, 9, new Mercenario(), BigDecimal.valueOf(100), 50 );

        Assert.assertEquals(202.5 , jogadorteste.valorMinimoDeCompraDoJogador(),0);
    }

    @Test
    public void deveCalcularOPreçoDoGoleiroQuandoEleDefende50Gols(){
        Clube clubeteste = new Clube("Teste", 10, BigDecimal.valueOf(100));
        Jogador jogadorteste = new Goleiro("Teste",35, clubeteste, 9, new Conservador(), BigDecimal.valueOf(100), 50 );

        Assert.assertEquals(420 , jogadorteste.valorMinimoDeCompraDoJogador(),0);
    }

    @Test
    public void deveCalcularOPreçoDoLateralQuandoEleFizer50CruzamentosETemMenosDe28Anos(){
        Clube clubeteste = new Clube("Teste", 10, BigDecimal.valueOf(100));
        Jogador jogadorteste = new Lateral("Teste",27, clubeteste, 9, new Indiferente(), BigDecimal.valueOf(100), 50 );

        Assert.assertEquals(200 , jogadorteste.valorMinimoDeCompraDoJogador(),0);
    }

    @Test
    public void deveCalcularOPreçoDoLateralQuandoEleFizer50CruzamentosETemMaisDe28Anos(){
        Clube clubeteste = new Clube("Teste", 10, BigDecimal.valueOf(100));
        Jogador jogadorteste = new Lateral("Teste",35, clubeteste, 9, new Indiferente(), BigDecimal.valueOf(100), 50);

        Assert.assertEquals(140 , jogadorteste.valorMinimoDeCompraDoJogador(),0);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMenosDeTrintaAnos(){
        Clube clubeteste = new Clube("Teste", 10, BigDecimal.valueOf(100));
        Jogador jogadorteste = new MeioDeCampo("Teste",27, clubeteste, 9, new Mercenario(), BigDecimal.valueOf(100));

        Assert.assertEquals(180 , jogadorteste.valorMinimoDeCompraDoJogador(),0);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMaisDeTrintaAnos(){
        Clube clubeteste = new Clube("Teste", 10, BigDecimal.valueOf(100));
        Jogador jogadorteste = new MeioDeCampo("Teste",35, clubeteste, 9, new Mercenario(), BigDecimal.valueOf(100));

        Assert.assertEquals(126 , jogadorteste.valorMinimoDeCompraDoJogador(),0.1);
    }

    @Test
    public void deveCalcularOPreçoDoZagueiroQuandoELeTemMenosDe30Anos(){
        Clube clubeteste = new Clube("Teste", 10, BigDecimal.valueOf(100));
        Jogador jogadorteste = new Zagueiro("Teste",27, clubeteste, 9, new Conservador(), BigDecimal.valueOf(100));

        Assert.assertEquals(140 , jogadorteste.valorMinimoDeCompraDoJogador(),0);
    }

    @Test
    public void deveCalcularOPreçoDoZagueiroQuandoELeTemMaisDe30Anos(){
        Clube clubeteste = new Clube("Teste", 10, BigDecimal.valueOf(100));
        Jogador jogadorteste = new Zagueiro("Teste",35, clubeteste, 9, new Conservador(), BigDecimal.valueOf(100));

        Assert.assertEquals(112 , jogadorteste.valorMinimoDeCompraDoJogador(),0);
    }
}
