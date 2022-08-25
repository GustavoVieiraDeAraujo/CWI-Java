package personagens;

import mapa.Mapa;
import racas.Elfo;

public class Legolas extends Personagem implements Elfo {

    private int posicao = 0;
    private int constituicao = 80;

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
        return true;
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
    public String falaEmElfico(){
        return "I amar prestar aen, han mathon ne nem, han mathon ne chae, a han noston ned.";
    }
    @Override
    public String falar() {
        return "They're taking the Hobbits to Isengard!";
    }

    @Override
    public String toString(){
        return "L";
    }

    @Override
    public void atacar(Mapa mapa) {
        Personagem atacante = mapa.buscarCasa(this.posicao);

        int posicaoDefensor1 = this.posicao+1;
        int posicaoDefensor2 = this.posicao+2;
        int posicaoDefensor3 = this.posicao+3;

        if (this.posicao < 10) {
            if (posicaoDefensor1 < 10 && posicaoDefensor2 < 10 && posicaoDefensor3 < 10) {
                Personagem defensor1 = mapa.buscarCasa(posicaoDefensor1);
                Personagem defensor2 = mapa.buscarCasa(posicaoDefensor2);
                Personagem defensor3 = mapa.buscarCasa(posicaoDefensor3);
                if (defensor3 != null) {
                    defensor3.receberDanoNaConstituicao(30);
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    defensor1 = mapa.buscarCasa(posicaoDefensor1);
                    defensor2 = mapa.buscarCasa(posicaoDefensor2);
                    if (defensor2 == null && defensor1 == null) {
                        atacante.setPosicao(this.posicao +2);
                    } else if (defensor2 != null && defensor1 == null) {
                        atacante.setPosicao(this.posicao +1);
                    }
                } else if (defensor2 != null) {
                    defensor2.receberDanoNaConstituicao(20);
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    defensor1 = mapa.buscarCasa(posicaoDefensor1);
                    defensor2 = mapa.buscarCasa(posicaoDefensor2);
                    if (defensor2 == null && defensor1 == null) {
                        atacante.setPosicao(this.posicao +2);
                    } else if (defensor2 != null && defensor1 == null) {
                        atacante.setPosicao(this.posicao +1);
                    }
                } else if (defensor1 != null) {
                    defensor1.receberDanoNaConstituicao(10);
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    defensor1 = mapa.buscarCasa(posicaoDefensor1);
                    defensor2 = mapa.buscarCasa(posicaoDefensor2);
                    if (defensor2 == null && defensor1 == null) {
                        atacante.setPosicao(this.posicao +2);
                    } else if (defensor2 != null && defensor1 == null) {
                        atacante.setPosicao(this.posicao +1);
                    }
                } else {
                    atacante.setPosicao(this.posicao +2);
                }

            } else if (posicaoDefensor1 < 10 && posicaoDefensor2 < 10 && posicaoDefensor3 == 10) {
                Personagem defensor1 = mapa.buscarCasa(posicaoDefensor1);
                Personagem defensor2 = mapa.buscarCasa(posicaoDefensor2);
                if (defensor2 != null) {
                    defensor2.receberDanoNaConstituicao(20);
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    defensor1 = mapa.buscarCasa(posicaoDefensor1);
                    defensor2 = mapa.buscarCasa(posicaoDefensor2);
                    if (defensor2 == null && defensor1 == null) {
                        atacante.setPosicao(this.posicao +2);
                    } else if (defensor2 != null && defensor1 == null) {
                        atacante.setPosicao(this.posicao +1);
                    }
                } else if (defensor1 != null) {
                    defensor1.receberDanoNaConstituicao(10);
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    defensor1 = mapa.buscarCasa(posicaoDefensor1);
                    defensor2 = mapa.buscarCasa(posicaoDefensor2);
                    if (defensor2 == null && defensor1 == null) {
                        atacante.setPosicao(this.posicao +2);
                    } else if (defensor2 != null && defensor1 == null) {
                        atacante.setPosicao(this.posicao +1);
                    }
                } else {
                    atacante.setPosicao(this.posicao +2);
                }

            } else if (posicaoDefensor1 < 10 && posicaoDefensor2 == 10 && posicaoDefensor3 > 10) {
                Personagem defensor1 = mapa.buscarCasa(posicaoDefensor1);
                if (defensor1 != null) {
                    defensor1.receberDanoNaConstituicao(10);
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    defensor1 = mapa.buscarCasa(posicaoDefensor1);
                    if (defensor1 != null) {
                        atacante.setPosicao(this.posicao +2);
                    }
                } else {
                    atacante.setPosicao(this.posicao +2);
                }
            }
        }
    }
}
