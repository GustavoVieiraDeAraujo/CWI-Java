package jogador;

import apetitefinanceiro.ApetiteFinanceiro;
import clube.Clube;

import java.math.BigDecimal;

public class Atacante extends Jogador{

    private static int quantidadeDeGolsFeitosNoAno;
    private static final double TAXA_ATACANTE_POR_GOL = 0.01;
    private static final double TAXA_ATACANTE_IDADE = 0.75;

    public Atacante(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco, int quantidadeDeGolsFeitosNoAno) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this. quantidadeDeGolsFeitosNoAno= quantidadeDeGolsFeitosNoAno;
    }

    public double valorMinimoDeCompraDoJogador(){
        double precoComApetite =  this.preco.doubleValue() * this.apetiteFinanceiro.getTaxa();
        double valorComTaxasDePosicao = precoComApetite + (precoComApetite * TAXA_ATACANTE_POR_GOL * quantidadeDeGolsFeitosNoAno);
        if (this.idade > 30){
            return valorComTaxasDePosicao * TAXA_ATACANTE_IDADE;
        }else{
            return valorComTaxasDePosicao;
        }
    }

    public boolean temInteresseEmTrocarDeClube(Clube clube){
        return (clube.getReputacaoHistorica() > this.reputacaoHistorica) ? true : false;
    }
}
