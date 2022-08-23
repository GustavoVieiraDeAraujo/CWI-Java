package jogador;

import apetitefinanceiro.ApetiteFinanceiro;
import clube.Clube;

import java.math.BigDecimal;

public class Lateral extends Jogador{
    private static int quantidadeDeCruzamentosCerteirosNoAno;
    private static final double TAXA_LATERAL_POR_CRUZAMENTO = 0.02;
    private static final double TAXA_LATERAL_IDADE = 0.7;

    public Lateral(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco, int quantidadeDeCruzamentosCerteirosNoAno) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.quantidadeDeCruzamentosCerteirosNoAno = quantidadeDeCruzamentosCerteirosNoAno;
    }

    public double valorMinimoDeCompraDoJogador(){
        double precoComApetite =  this.preco.doubleValue() * this.apetiteFinanceiro.getTaxa();
        double valorComTaxasDePosicao = precoComApetite + (precoComApetite * TAXA_LATERAL_POR_CRUZAMENTO * quantidadeDeCruzamentosCerteirosNoAno);
        if (this.idade > 28){
            return valorComTaxasDePosicao * TAXA_LATERAL_IDADE;
        }else{
            return valorComTaxasDePosicao;
        }
    }
}


