package jogador;

import apetitefinanceiro.ApetiteFinanceiro;
import clube.Clube;

import java.math.BigDecimal;

public class Zagueiro extends Jogador{

    private final double TAXA_ZAGUEIRO_IDADE = 0.8;

    public Zagueiro(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
    }

    @Override
    public double valorMinimoDeCompraDoJogador(){
        double precoComApetite =  this.preco.doubleValue() * this.apetiteFinanceiro.getTaxa();
        if (this.idade > 30){
            return precoComApetite*TAXA_ZAGUEIRO_IDADE;
        }else{
            return precoComApetite;
        }

    }
}
