package personagens;

import mapa.Mapa;
import racas.Humano;

public class Boromir extends Personagem implements Humano{

    private int constituicao = 40;
    private int posicao = 0;

    @Override
    public int getConstituicao() {
        return constituicao;
    }

    @Override
    public void receberDanoNaConstituicao(int dano) {
        int diferenca = this.constituicao-dano;
        if (diferenca < 0){
            diferenca=0;
        }
        this.constituicao = diferenca;
    }

    @Override
    public boolean isSociedadeDoAnel() {
        return true;
    }

    @Override
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    @Override
    public int getPosicao() {
        return posicao;
    }

    @Override
    public void envelhecer() {
        int diferenca = this.constituicao - 2;
        if (diferenca <= 0) {
            diferenca = 0;
        }
        this.constituicao = diferenca;
    }

    @Override
    public String falar() {
        return "One does not simply walk into Mordor.";
    }

    @Override
    public String toString(){
        return "B";
    }

    @Override
    public void atacar(Mapa mapa) {
        Personagem atacante = mapa.buscarCasa(this.posicao);
        Personagem defensor = mapa.buscarCasa(this.posicao+1);
        if (defensor != null){
            if (this.posicao < 10) {
                if (!defensor.isSociedadeDoAnel()) {
                    defensor.receberDanoNaConstituicao(14);
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    if (mapa.getMapa()[this.posicao+1] == null) {
                        atacante.setPosicao(this.posicao+1);
                    }
                }
            }
        }else {
            atacante.setPosicao(this.posicao+1);
        }
    }
}
