package personagens;

import mapa.Mapa;

public abstract class Personagem {

    protected final int forca;
    protected final int agilidade;
    protected final int inteligencia;
    protected int constituicao;
    protected final boolean sociedadeDoAnel;
    protected int posicao = 0;

    public Personagem(int forca, int agilidade, int inteligencia, int constituicao ,boolean sociedadeDoAnel) {
        this.forca = forca;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.sociedadeDoAnel = sociedadeDoAnel;
        this.constituicao = constituicao;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public boolean isSociedadeDoAnel() {return sociedadeDoAnel;}

    public void receberDanoNaConstituicao(int dano) {
        int diferenca = this.constituicao-dano;
        if (diferenca < 0){
            diferenca=0;
        }
        this.constituicao = diferenca;
    }
    public void atacar(Mapa mapa){}
}
