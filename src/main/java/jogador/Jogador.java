package jogador;

import java.math.BigDecimal;

import apetitefinanceiro.ApetiteFinanceiro;

import clube.Clube;

public class Jogador {

    protected int idade;
    protected String nome;
    protected BigDecimal preco;
    protected Clube clubeAtual;
    protected int reputacaoHistorica;
    protected ApetiteFinanceiro apetiteFinanceiro;

    public Jogador (String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco){
        if (reputacaoHistorica >=0 && reputacaoHistorica <= 10 ){this.reputacaoHistorica = reputacaoHistorica;}
        this.nome = nome;
        this.idade = idade;
        this.preco = preco;
        this.clubeAtual = clubeAtual;
        this.apetiteFinanceiro = apetiteFinanceiro;
    }
    public boolean temInteresseEmTrocarDeClube(Clube clube) {
        return clube.getReputacaoHistorica() >= 1;
    }
    public double valorMinimoDeCompraDoJogador() {
        return this.preco.doubleValue() * this.apetiteFinanceiro.getTaxa();
    }
    public String getClubeAtual() {return this.clubeAtual != null ? this.clubeAtual.getNome() : "Sem Clube";}
    public void setClubeAtual(Clube clubeQueDesejaFazerTransferencia) {this.clubeAtual = clubeQueDesejaFazerTransferencia;}
}
