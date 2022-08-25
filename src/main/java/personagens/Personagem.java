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
            int diferencaMaisLonge = 3;
            if(sociedadeDoAnel) {
                while (diferencaMaisLonge > 0){
                    if(posicao+diferencaMaisLonge <= 9){
                        Personagem defensor = mapa.buscarCasa(posicao+diferencaMaisLonge);
                        if (defensor != null && !defensor.isSociedadeDoAnel()) {
                            defensor.receberDanoNaConstituicao(atacante.agilidade * diferencaMaisLonge);
                            break;
                        }
                    }
                    diferencaMaisLonge-=1;
                }
                mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                Personagem posicaoMaisUmEstaOcupada = mapa.buscarCasa(posicao+1) ;
                Personagem posicaoMaisDoisEstaOcupada = mapa.buscarCasa(posicao+2);
                if (posicaoMaisDoisEstaOcupada == null && posicaoMaisUmEstaOcupada == null){
                    atacante.setPosicao(posicao +2);
                } else if (posicaoMaisDoisEstaOcupada != null && posicaoMaisUmEstaOcupada == null) {
                    atacante.setPosicao(posicao +1);
                }
            }else {
                while (diferencaMaisLonge > 0){
                    if(posicao-diferencaMaisLonge >= 0){
                        Personagem defensor = mapa.buscarCasa(posicao-diferencaMaisLonge);
                        if (defensor != null && defensor.isSociedadeDoAnel()) {
                            defensor.receberDanoNaConstituicao(atacante.agilidade * diferencaMaisLonge);
                            break;
                        }
                    }
                    diferencaMaisLonge-=1;
                }
                mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                Personagem posicaoMaisUmEstaOcupada = mapa.buscarCasa(posicao-1) ;
                Personagem posicaoMaisDoisEstaOcupada = mapa.buscarCasa(posicao-2);
                if (posicaoMaisDoisEstaOcupada == null && posicaoMaisUmEstaOcupada == null){
                    atacante.setPosicao(posicao -2);
                } else if (posicaoMaisDoisEstaOcupada != null && posicaoMaisUmEstaOcupada == null) {
                    atacante.setPosicao(posicao -1);
                }
            }
        }
    }
}
