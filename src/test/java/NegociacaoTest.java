// Importando os ApetitesFinanceiros
import apetitefinanceiro.Conservador;
import apetitefinanceiro.Indiferente;
import apetitefinanceiro.Mercenario;

// Importando Clube
import clube.Clube;

// Importando Jogadores
import jogador.*;

// Importando Negociacao
import negociacao.Negociacao;

// Importando Biblioteca de Teste
import org.junit.Assert;
import org.junit.Test;

// Importando Biblioteca Auxiliar
import java.math.BigDecimal;

public class NegociacaoTest {

    @Test
    public void deveSerPossivelNegociarUmGoleiroComUmClubeQueTemSaldoEmCaixa() {
        Negociacao negociacao = new Negociacao();
        Clube clubeteste = new Clube("Teste", 10, BigDecimal.valueOf(100000000));
        Goleiro jogadorteste = new Goleiro("Teste", 33, null, 8, new Indiferente(), BigDecimal.valueOf(800500), 12);

        boolean foiPossivelNegociar = negociacao.negociar(clubeteste, jogadorteste);

        Assert.assertTrue(foiPossivelNegociar);
    }

    @Test
    public void naoDeveSerPossivelNegociarUmAtacanteComUmClubeQueTemReputacaoHistoricaMenorQueASua() {

        Negociacao negociacao = new Negociacao();
        Clube clubeteste = new Clube("Teste", 3, BigDecimal.valueOf(100000000));
        Atacante jogadorteste = new Atacante("Teste", 35, null, 10, new Conservador(), BigDecimal.valueOf(800500), 20);

        boolean foiPossivelNegociar = negociacao.negociar(clubeteste, jogadorteste);

        Assert.assertFalse(foiPossivelNegociar);
    }

    @Test
    public void naoDeveSerPossivelNegociarPorFaltaDeCaixaDisponivel(){
        Negociacao negociacao = new Negociacao();
        Clube clubeteste = new Clube("Teste", 10, BigDecimal.valueOf(100));
        Jogador jogadorteste = new Zagueiro("Teste",27, clubeteste, 9, new Conservador(), BigDecimal.valueOf(100));

        boolean foiPossivelNegociar = negociacao.negociar(clubeteste , jogadorteste);

        Assert.assertFalse(foiPossivelNegociar);
    }

    @Test
    public void deveAtualizarSaldoDisponivelAoComprarUmJogador(){
        Negociacao negociacao = new Negociacao();
        Clube clubeteste = new Clube("Teste", 10, BigDecimal.valueOf(1000));
        Jogador jogadorteste = new Zagueiro("Teste",27, clubeteste, 9, new Conservador(), BigDecimal.valueOf(100));

        boolean foiPossivelNegociar = negociacao.negociar(clubeteste , jogadorteste);
        double saldoRestante = clubeteste.getSaldoDisponivelEmCaixa();

        Assert.assertEquals(860, saldoRestante,0);
    }

    @Test
    public void deveAtualizarOClubeDoJogadorQuandoEleForComprado(){
        Negociacao negociacao = new Negociacao();
        Clube clubeteste = new Clube("Teste", 10, BigDecimal.valueOf(1000));
        Jogador jogadorteste = new Zagueiro("Teste",27, null, 9, new Conservador(), BigDecimal.valueOf(100));

        boolean foiPossivelNegociar = negociacao.negociar(clubeteste , jogadorteste);
        String novoClube = jogadorteste.getClubeAtual();

        Assert.assertEquals("Teste", novoClube);
    }

    @Test
    public void deveMostarSemClubeQuandoJogadorNãoTiverClube(){
        Jogador jogadorteste = new Zagueiro("Teste",27, null, 9, new Conservador(), BigDecimal.valueOf(100));

        String clubeAtual = jogadorteste.getClubeAtual();

        Assert.assertEquals("Sem Clube", clubeAtual);
    }

}
