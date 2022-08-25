package personagens;

import mapa.Mapa;
import racas.Humano;

public class Boromir extends Personagem implements Humano{

    public Boromir(){super(7,6,3,40,true);}

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
        Personagem atacante = mapa.buscarCasa(posicao);
        Personagem defensor = mapa.buscarCasa(posicao+1);
        if (defensor != null){
            if (posicao < 10 && !defensor.isSociedadeDoAnel()) {
                defensor.receberDanoNaConstituicao(14);
                mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                if (mapa.getMapa()[posicao+1] == null) {
                    atacante.setPosicao(posicao+1);
                }
            }
        }else {
            atacante.setPosicao(posicao+1);
        }
    }
}
