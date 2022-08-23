package clube;

import java.math.BigDecimal;

public class Clube {

    private static String nome;
    private static int reputacaoHistorica;
    private static BigDecimal saldoDisponivelEmCaixa;

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
        this.saldoDisponivelEmCaixa.subtract(BigDecimal.valueOf(valorDoJogador));
    }
}
