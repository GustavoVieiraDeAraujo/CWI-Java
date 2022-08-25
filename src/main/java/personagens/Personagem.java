package personagens;

import mapa.Mapa;
import tiposdeclasse.TiposDeClasse;

public abstract class Personagem {

    protected final int forca;
    protected final int agilidade;
    protected final int inteligencia;
    protected int constituicao;
    protected final boolean sociedadeDoAnel;
    protected final TiposDeClasse classe;
    protected int posicao = 0;

    public Personagem(int forca, int agilidade, int inteligencia, int constituicao ,boolean sociedadeDoAnel, TiposDeClasse classe) {
        this.forca = forca;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.sociedadeDoAnel = sociedadeDoAnel;
        this.classe = classe;
        this.constituicao = constituicao;
    }

    public TiposDeClasse getClasse() { return classe;}

    public int getConstituicao() {
        return constituicao;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public boolean isSociedadeDoAnel() {return sociedadeDoAnel;}

    public void receberDanoNaConstituicao(int dano) {
        int diferenca = this.constituicao-dano;
        if (diferenca < 0){
            diferenca=0;
        }
        this.constituicao = diferenca;
    }
    public void atacar(Mapa mapa,TiposDeClasse classe, boolean sociedadeDoAnel){
        Personagem atacante = mapa.buscarCasa(posicao);
        if(classe.equals(TiposDeClasse.GUERREIRO)){
            if (sociedadeDoAnel){
                Personagem defensor = mapa.buscarCasa(posicao+1);
                if (defensor != null){
                    if (posicao < 10 && !defensor.isSociedadeDoAnel()) {
                        defensor.receberDanoNaConstituicao(atacante.forca*2);
                        mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                        if (mapa.getMapa()[posicao+1] == null) {
                            atacante.setPosicao(posicao+1);
                        }
                    }
                }else {
                    atacante.setPosicao(posicao+1);
                }
            }else {
                Personagem defensor = mapa.buscarCasa(posicao-1);
                if (defensor != null){
                    if (posicao > 0 && defensor.isSociedadeDoAnel()) {
                        defensor.receberDanoNaConstituicao(atacante.forca*2);
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


        if (classe.equals(TiposDeClasse.MAGO)){
            if (sociedadeDoAnel) {
                if (posicao < 10) {
                    for (Personagem defensor : mapa.getMapa()) {
                        if (defensor != null && !defensor.isSociedadeDoAnel()) {
                            defensor.receberDanoNaConstituicao(atacante.inteligencia);
                        }
                    }
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    if (mapa.getQuantosPersonagensTemNoMapa() == 1) {
                        atacante.setPosicao(posicao+1);
                    }
                }
            }else {
                if ( posicao > 0) {
                    for(Personagem defensor : mapa.getMapa()){
                        if(defensor != null && defensor.isSociedadeDoAnel()){
                            defensor.receberDanoNaConstituicao(atacante.inteligencia);
                        }
                    }
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    if(mapa.getQuantosPersonagensTemNoMapa() == 1){
                        atacante.setPosicao(posicao+=1);
                    }
                }
            }

        }

        if(classe.equals(TiposDeClasse.ARQUEIRO)){
            if(sociedadeDoAnel){
                int posicaoDefensor1 = posicao+1;
                int posicaoDefensor2 = posicao+2;
                int posicaoDefensor3 = posicao+3;

                if (posicao < 10) {
                    if (posicaoDefensor1 < 10 && posicaoDefensor2 < 10 && posicaoDefensor3 < 10) {
                        Personagem defensor1 = mapa.buscarCasa(posicaoDefensor1);
                        Personagem defensor2 = mapa.buscarCasa(posicaoDefensor2);
                        Personagem defensor3 = mapa.buscarCasa(posicaoDefensor3);
                        if (defensor3 != null) {
                            defensor3.receberDanoNaConstituicao(atacante.agilidade*3);
                            mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                            defensor1 = mapa.buscarCasa(posicaoDefensor1);
                            defensor2 = mapa.buscarCasa(posicaoDefensor2);
                            if (defensor2 == null && defensor1 == null) {
                                atacante.setPosicao(posicao +2);
                            } else if (defensor2 != null && defensor1 == null) {
                                atacante.setPosicao(posicao +1);
                            }
                        } else if (defensor2 != null) {
                            defensor2.receberDanoNaConstituicao(atacante.agilidade*2);
                            mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                            defensor1 = mapa.buscarCasa(posicaoDefensor1);
                            defensor2 = mapa.buscarCasa(posicaoDefensor2);
                            if (defensor2 == null && defensor1 == null) {
                                atacante.setPosicao(posicao +2);
                            } else if (defensor2 != null && defensor1 == null) {
                                atacante.setPosicao(posicao +1);
                            }
                        } else if (defensor1 != null) {
                            defensor1.receberDanoNaConstituicao(atacante.agilidade);
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
                            defensor2.receberDanoNaConstituicao(atacante.agilidade*2);
                            mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                            defensor1 = mapa.buscarCasa(posicaoDefensor1);
                            defensor2 = mapa.buscarCasa(posicaoDefensor2);
                            if (defensor2 == null && defensor1 == null) {
                                atacante.setPosicao(posicao +2);
                            } else if (defensor2 != null && defensor1 == null) {
                                atacante.setPosicao(posicao +1);
                            }
                        } else if (defensor1 != null) {
                            defensor1.receberDanoNaConstituicao(atacante.agilidade);
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
                            defensor1.receberDanoNaConstituicao(atacante.agilidade);
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
            }else {

                int posicaoDefensor1 = posicao-1;
                int posicaoDefensor2 = posicao-2;
                int posicaoDefensor3 = posicao-3;

                if (posicao > 0){

                    if( posicaoDefensor1 > 0 && posicaoDefensor2 > 0 && posicaoDefensor3 > 0){
                        Personagem defensor1 = mapa.buscarCasa(posicaoDefensor1);
                        Personagem defensor2 = mapa.buscarCasa(posicaoDefensor2);
                        Personagem defensor3 = mapa.buscarCasa(posicaoDefensor3);
                        if (defensor3 != null && defensor3.isSociedadeDoAnel()){
                            defensor3.receberDanoNaConstituicao(atacante.agilidade*3);
                            mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                            defensor1 = mapa.buscarCasa(posicaoDefensor1);
                            defensor2 = mapa.buscarCasa(posicaoDefensor2);
                            if (defensor2 == null && defensor1 == null){
                                atacante.setPosicao(posicao -2);
                            } else if (defensor2 != null && defensor1 == null) {
                                atacante.setPosicao(posicao -1);
                            }
                        } else if (defensor2 != null && defensor2.isSociedadeDoAnel()) {
                            defensor2.receberDanoNaConstituicao(atacante.agilidade*2);
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
                            defensor2.receberDanoNaConstituicao(atacante.agilidade*2);
                            mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                            defensor1 = mapa.buscarCasa(posicaoDefensor1);
                            defensor2 = mapa.buscarCasa(posicaoDefensor2);
                            if (defensor2 == null && defensor1 == null){
                                atacante.setPosicao(posicao -2);
                            }else if (defensor2 != null && defensor1 == null) {
                                atacante.setPosicao(posicao -1);
                            }
                        }else if (defensor1 != null){
                            defensor1.receberDanoNaConstituicao(atacante.agilidade);
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
                            defensor1.receberDanoNaConstituicao(atacante.agilidade);
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
        }
    }
}
