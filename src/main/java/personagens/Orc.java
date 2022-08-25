package personagens;

import mapa.Mapa;
import racas.Monstro;

public class Orc extends Personagem implements Monstro{

    public Orc(){super(7,4,1,30,false);}

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

    @Override
    public String toString(){
        return "O";
    }

    @Override
    public String grunir(){
        return "Arrrggghhh";
    }


}
