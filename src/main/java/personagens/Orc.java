package personagens;

import mapa.Mapa;
import racas.Monstro;

public class Orc extends Personagem implements Monstro{

    private int constituicao = 30;

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
        return false;
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
    public String grunir(){
        return "Arrrggghhh";
    }

    @Override
    public String toString(){
        return "O";
    }

    @Override
    public void atacar(Mapa mapa) {
        Personagem atacante = mapa.buscarCasa(this.posicao);
        Personagem defensor = mapa.buscarCasa(this.posicao-1);
        if (defensor != null){
            if (this.posicao > 0) {
                if (defensor.isSociedadeDoAnel()) {
                    defensor.receberDanoNaConstituicao(14);
                }
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
