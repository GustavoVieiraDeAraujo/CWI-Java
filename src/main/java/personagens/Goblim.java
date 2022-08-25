package personagens;

import mapa.Mapa;
import racas.Monstro;

public class Goblim extends Personagem implements Monstro{
    public Goblim(){super(3,6,1,20,false);}

    @Override
    public String toString(){
        return "M";
    }

    @Override
    public void atacar(Mapa mapa) {
        Personagem atacante = mapa.buscarCasa(posicao);

        int posicaoDefensor1 = posicao-1;
        int posicaoDefensor2 = posicao-2;
        int posicaoDefensor3 = posicao-3;

        if (posicao > 0){

            if( posicaoDefensor1 > 0 && posicaoDefensor2 > 0 && posicaoDefensor3 > 0){
                Personagem defensor1 = mapa.buscarCasa(posicaoDefensor1);
                Personagem defensor2 = mapa.buscarCasa(posicaoDefensor2);
                Personagem defensor3 = mapa.buscarCasa(posicaoDefensor3);
                if (defensor3 != null && defensor3.isSociedadeDoAnel()){
                    defensor3.receberDanoNaConstituicao(18);
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    defensor1 = mapa.buscarCasa(posicaoDefensor1);
                    defensor2 = mapa.buscarCasa(posicaoDefensor2);
                    if (defensor2 == null && defensor1 == null){
                        atacante.setPosicao(posicao -2);
                    } else if (defensor2 != null && defensor1 == null) {
                        atacante.setPosicao(posicao -1);
                    }
                } else if (defensor2 != null && defensor2.isSociedadeDoAnel()) {
                    defensor2.receberDanoNaConstituicao(12);
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    defensor1 = mapa.buscarCasa(posicaoDefensor1);
                    defensor2 = mapa.buscarCasa(posicaoDefensor2);
                    if (defensor2 == null && defensor1 == null){
                        atacante.setPosicao(posicao -2);
                    }else if (defensor2 != null && defensor1 == null) {
                        atacante.setPosicao(posicao -1);
                    }
                } else if (defensor1 != null && defensor1.isSociedadeDoAnel()){
                    defensor1.receberDanoNaConstituicao(6);
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    defensor1 = mapa.buscarCasa(posicaoDefensor1);
                    defensor2 = mapa.buscarCasa(posicaoDefensor2);
                    if (defensor2 == null && defensor1 == null){
                        atacante.setPosicao(posicao -2);
                    }else if (defensor2 != null && defensor1 == null) {
                        atacante.setPosicao(posicao -1);
                    }
                } else {
                    if (defensor1 == null && defensor2 == null){
                        atacante.setPosicao(posicao -2);
                    }else if (defensor2 != null && defensor1 == null) {
                        atacante.setPosicao(posicao -1);
                    }
                }

            } else if (posicaoDefensor1 < 0 && posicaoDefensor2 < 0 && posicaoDefensor3 == -1) {
                Personagem defensor1 = mapa.buscarCasa(posicaoDefensor1);
                Personagem defensor2 = mapa.buscarCasa(posicaoDefensor2);
                if (defensor2 != null) {
                    defensor2.receberDanoNaConstituicao(12);
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    defensor1 = mapa.buscarCasa(posicaoDefensor1);
                    defensor2 = mapa.buscarCasa(posicaoDefensor2);
                    if (defensor2 == null && defensor1 == null){
                        atacante.setPosicao(posicao -2);
                    }else if (defensor2 != null && defensor1 == null) {
                        atacante.setPosicao(posicao -1);
                    }
                }else if (defensor1 != null){
                    defensor1.receberDanoNaConstituicao(6);
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    defensor1 = mapa.buscarCasa(posicaoDefensor1);
                    defensor2 = mapa.buscarCasa(posicaoDefensor2);
                    if (defensor2 == null && defensor1 == null){
                        atacante.setPosicao(posicao -2);
                    }else if (defensor2 != null && defensor1 == null) {
                        atacante.setPosicao(posicao -1);
                    }
                } else {
                    atacante.setPosicao(posicao - 2);
                }

            } else if (posicaoDefensor1 > 0 && posicaoDefensor2 == -1 && posicaoDefensor3 < 0) {
                Personagem defensor1 = mapa.buscarCasa(posicaoDefensor1);
                if (defensor1 != null){
                    defensor1.receberDanoNaConstituicao(6);
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    defensor1 = mapa.buscarCasa(posicaoDefensor1);
                    if (defensor1 != null) {
                        atacante.setPosicao(posicao -1);
                    }
                } else {
                    atacante.setPosicao(posicao - 2);
                }
            }
        }
    }

    @Override
    public String grunir(){
        return "Iiisshhhh";
    }


}
