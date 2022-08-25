package personagens;

import mapa.Mapa;
import racas.Humano;
import racas.Monstro;

public class Urukhai extends Personagem implements Humano, Monstro{
    public Urukhai(){super(8,6,3,45,false);}

    @Override
    public void envelhecer() {
        int diferenca = constituicao - 2;
        if (diferenca < 0) {
            diferenca = 0;
        }
        constituicao = diferenca;
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
    public void atacar(Mapa mapa) {
        Personagem atacante = mapa.buscarCasa(posicao);
        Personagem defensor = mapa.buscarCasa(posicao-1);
        if (defensor != null){
            if (posicao > 0 && defensor.isSociedadeDoAnel()) {
                defensor.receberDanoNaConstituicao(14);
            }
            mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
            if (mapa.getMapa()[posicao-1] == null) {
                atacante.setPosicao(posicao-1);
            }
        }else {
            atacante.setPosicao(posicao-1);
        }
    }
}
