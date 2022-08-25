package personagens;

import mapa.Mapa;
import racas.Humano;

public class Aragorn extends Personagem implements Humano{
    public Aragorn(){super(10,7,6,60,true);}

    public void envelhecer() {
        if (constituicao - 1 < 0) {
            constituicao = 0;
        }
        this.constituicao -= 1;
    }
    @Override
    public String falar() {
        return "A day may come when the courage of men fails… but it is not THIS day.";
    }

    @Override
    public String toString() {
        return "A";
    }

    @Override
    public void atacar(Mapa mapa) {
        Personagem atacante = mapa.buscarCasa(posicao);
        Personagem defensor = mapa.buscarCasa(posicao+1);
        if (defensor != null){
            if (posicao < 10 && !defensor.isSociedadeDoAnel()) {
                defensor.receberDanoNaConstituicao(20);
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