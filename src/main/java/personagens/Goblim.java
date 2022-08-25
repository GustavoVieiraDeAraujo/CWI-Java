package personagens;

import mapa.Mapa;
import racas.Monstro;

public class Goblim extends Personagem implements Monstro {
    private int constituicao = 20;
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
        return "Iiisshhhh";
    }

    @Override
    public String toString(){
        return "M";
    }

    @Override
    public void atacar(Mapa mapa){

        Personagem atacante = mapa.buscarCasa(this.posicao);

        int posicaoDefensor1 = this.posicao-1;
        int posicaoDefensor2 = this.posicao-2;
        int posicaoDefensor3 = this.posicao-3;

        if (this.posicao > 0){

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
                        atacante.setPosicao(this.posicao -2);
                    } else if (defensor2 != null && defensor1 == null) {
                        atacante.setPosicao(this.posicao -1);
                    }
                } else if (defensor2 != null && defensor2.isSociedadeDoAnel()) {
                    defensor2.receberDanoNaConstituicao(12);
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    defensor1 = mapa.buscarCasa(posicaoDefensor1);
                    defensor2 = mapa.buscarCasa(posicaoDefensor2);
                    if (defensor2 == null && defensor1 == null){
                        atacante.setPosicao(this.posicao -2);
                    }else if (defensor2 != null && defensor1 == null) {
                        atacante.setPosicao(this.posicao -1);
                    }
                } else if (defensor1 != null && defensor1.isSociedadeDoAnel()){
                    defensor1.receberDanoNaConstituicao(6);
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    defensor1 = mapa.buscarCasa(posicaoDefensor1);
                    defensor2 = mapa.buscarCasa(posicaoDefensor2);
                    if (defensor2 == null && defensor1 == null){
                        atacante.setPosicao(this.posicao -2);
                    }else if (defensor2 != null && defensor1 == null) {
                        atacante.setPosicao(this.posicao -1);
                    }
                } else {
                    if (defensor1 == null && defensor2 == null){
                        atacante.setPosicao(this.posicao -2);
                    }else if (defensor2 != null && defensor1 == null) {
                        atacante.setPosicao(this.posicao -1);
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
                        atacante.setPosicao(this.posicao -2);
                    }else if (defensor2 != null && defensor1 == null) {
                        atacante.setPosicao(this.posicao -1);
                    }
                }else if (defensor1 != null){
                    defensor1.receberDanoNaConstituicao(6);
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    defensor1 = mapa.buscarCasa(posicaoDefensor1);
                    defensor2 = mapa.buscarCasa(posicaoDefensor2);
                    if (defensor2 == null && defensor1 == null){
                        atacante.setPosicao(this.posicao -2);
                    }else if (defensor2 != null && defensor1 == null) {
                        atacante.setPosicao(this.posicao -1);
                    }
                } else {
                    atacante.setPosicao(this.posicao - 2);
                }

            } else if (posicaoDefensor1 > 0 && posicaoDefensor2 == -1 && posicaoDefensor3 < 0) {
                Personagem defensor1 = mapa.buscarCasa(posicaoDefensor1);
                if (defensor1 != null){
                    defensor1.receberDanoNaConstituicao(6);
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    defensor1 = mapa.buscarCasa(posicaoDefensor1);
                    if (defensor1 != null) {
                        atacante.setPosicao(this.posicao -1);
                    }
                } else {
                    atacante.setPosicao(this.posicao - 2);
                }
            }
        }
    }
}
