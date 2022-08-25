package personagens;

import mapa.Mapa;
import racas.Elfo;

public class Legolas extends Personagem implements Elfo{

    public Legolas(){super(5,10,6,80,true);}

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
        Personagem atacante = mapa.buscarCasa(posicao);

        int posicaoDefensor1 = posicao+1;
        int posicaoDefensor2 = posicao+2;
        int posicaoDefensor3 = posicao+3;

        if (posicao < 10) {
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
                        atacante.setPosicao(posicao +2);
                    } else if (defensor2 != null && defensor1 == null) {
                        atacante.setPosicao(posicao +1);
                    }
                } else if (defensor2 != null) {
                    defensor2.receberDanoNaConstituicao(20);
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    defensor1 = mapa.buscarCasa(posicaoDefensor1);
                    defensor2 = mapa.buscarCasa(posicaoDefensor2);
                    if (defensor2 == null && defensor1 == null) {
                        atacante.setPosicao(posicao +2);
                    } else if (defensor2 != null && defensor1 == null) {
                        atacante.setPosicao(posicao +1);
                    }
                } else if (defensor1 != null) {
                    defensor1.receberDanoNaConstituicao(10);
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    defensor1 = mapa.buscarCasa(posicaoDefensor1);
                    defensor2 = mapa.buscarCasa(posicaoDefensor2);
                    if (defensor2 == null && defensor1 == null) {
                        atacante.setPosicao(posicao +2);
                    } else if (defensor2 != null && defensor1 == null) {
                        atacante.setPosicao(posicao +1);
                    }
                } else {
                    atacante.setPosicao(posicao +2);
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
                        atacante.setPosicao(posicao +2);
                    } else if (defensor2 != null && defensor1 == null) {
                        atacante.setPosicao(posicao +1);
                    }
                } else if (defensor1 != null) {
                    defensor1.receberDanoNaConstituicao(10);
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    defensor1 = mapa.buscarCasa(posicaoDefensor1);
                    defensor2 = mapa.buscarCasa(posicaoDefensor2);
                    if (defensor2 == null && defensor1 == null) {
                        atacante.setPosicao(posicao +2);
                    } else if (defensor2 != null && defensor1 == null) {
                        atacante.setPosicao(posicao +1);
                    }
                } else {
                    atacante.setPosicao(posicao +2);
                }

            } else if (posicaoDefensor1 < 10 && posicaoDefensor2 == 10 && posicaoDefensor3 > 10) {
                Personagem defensor1 = mapa.buscarCasa(posicaoDefensor1);
                if (defensor1 != null) {
                    defensor1.receberDanoNaConstituicao(10);
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    defensor1 = mapa.buscarCasa(posicaoDefensor1);
                    if (defensor1 != null) {
                        atacante.setPosicao(posicao +2);
                    }
                } else {
                    atacante.setPosicao(posicao +2);
                }
            }
        }

    }
}
