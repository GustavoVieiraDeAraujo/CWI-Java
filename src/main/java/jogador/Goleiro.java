package jogador;

import apetitefinanceiro.ApetiteFinanceiro;
import clube.Clube;

import java.math.BigDecimal;

public class Goleiro extends Jogador{

    private int quantidadeDePenaltisDefendidosNoAno;
    private final double TAXA_GOLEIRO_POR_DEFESA = 0.04;

    public Goleiro(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco, int quantidadeDePenaltisDefendidosNoAno) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.quantidadeDePenaltisDefendidosNoAno = quantidadeDePenaltisDefendidosNoAno;
    }

    @Override
    public double valorMinimoDeCompraDoJogador(){
        double precoComApetite =  this.preco.doubleValue() * this.apetiteFinanceiro.getTaxa();
        return precoComApetite + (precoComApetite * TAXA_GOLEIRO_POR_DEFESA * quantidadeDePenaltisDefendidosNoAno);
    }
}
