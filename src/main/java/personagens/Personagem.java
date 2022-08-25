package personagens;

import mapa.Mapa;

public abstract class Personagem {

    private int constituicao;
    private int posicao;

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
