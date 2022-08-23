package clube;

import java.math.BigDecimal;

public class Clube {

    private String nome;
    private int reputacaoHistorica;
    private BigDecimal saldoDisponivelEmCaixa;

    public Clube(String nome, int reputacaoHistorica, BigDecimal saldoDisponivelEmCaixa) {
        this.nome =nome;
        this.reputacaoHistorica = reputacaoHistorica;
        this.saldoDisponivelEmCaixa = saldoDisponivelEmCaixa;
    }

    public int getReputacaoHistorica() {
        return reputacaoHistorica;
    }

    public String getNome() {return nome;}

    public double getSaldoDisponivelEmCaixa() {
        return this.saldoDisponivelEmCaixa.doubleValue();
    }

    public void setSaldoDisponivelEmCaixa(double valorDoJogador) {
        double novoSaldo = this.saldoDisponivelEmCaixa.doubleValue() - valorDoJogador;
        this.saldoDisponivelEmCaixa = BigDecimal.valueOf(novoSaldo);
    }
}
