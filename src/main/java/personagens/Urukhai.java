package personagens;

import mapa.Mapa;
import racas.Humano;
import racas.Monstro;

public class Urukhai extends Personagem implements Humano, Monstro {

    private int constituicao = 45;
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
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    @Override
    public int getPosicao() {
        return posicao;
    }

    @Override
    public boolean isSociedadeDoAnel() {
        return false;
    }

    @Override
    public void envelhecer() {
        int diferenca = this.constituicao - 2;
        if (diferenca < 0) {
            diferenca = 0;
        }
        this.constituicao = diferenca;
    }

    @Override
    public String falar() {
        return  "Looks like meat's back on the menu boys!";
    }

    @Override
    public String grunir() {
        return "Uuurrrrrr";
    }

    @Override
    public String toString(){
        return "U";
    }

    @Override
    public void atacar(Mapa mapa){
        Personagem atacante = mapa.buscarCasa(this.posicao);
        Personagem defensor = mapa.buscarCasa(this.posicao-1);
        if (defensor != null){
            if (this.posicao > 0 && defensor.isSociedadeDoAnel()) {
                defensor.receberDanoNaConstituicao(14);
            }
            mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
            if (mapa.getMapa()[this.posicao-1] == null) {
                atacante.setPosicao(this.posicao-1);
            }
        }else {
            atacante.setPosicao(this.posicao-1);
        }
    }

}
