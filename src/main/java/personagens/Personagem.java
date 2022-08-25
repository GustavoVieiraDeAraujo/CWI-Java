package personagens;

import mapa.Mapa;

public abstract class Personagem {

    private int constituicao = 0;
    private int posicao = 0;

    public int getConstituicao() {
        return constituicao;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public boolean isSociedadeDoAnel() {
        return false;
    }

    public void receberDanoNaConstituicao(int dano) {}

    public void atacar(Mapa mapa){};
}
