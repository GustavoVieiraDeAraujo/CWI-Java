package jogador;

import apetitefinanceiro.ApetiteFinanceiro;
import clube.Clube;

import java.math.BigDecimal;

public class MeioDeCampo extends Jogador{

    private static final double TAXA_MEIO_DE_CAMPO_IDADE = 0.7;

    public MeioDeCampo(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
    }

    public double valorMinimoDeCompraDoJogador(){
        double precoComApetite =  this.preco.doubleValue() * this.apetiteFinanceiro.getTaxa();
        if (this.idade > 30){
            return precoComApetite * TAXA_MEIO_DE_CAMPO_IDADE;
        }else{
            return precoComApetite;
        }
    }

    public boolean temInteresseEmTrocarDeClube(Clube clube){
        return (clube.getReputacaoHistorica() <= this.reputacaoHistorica-2) ? true : false;
    }
}
