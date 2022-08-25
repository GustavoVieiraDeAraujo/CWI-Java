package mapa;

import exceptions.*;
import personagens.*;

public class Mapa {
    private Personagem[] mapa = new Personagem[10];
    private int quantosPersonagensTemNoMapa;

    public void setMapa(Personagem[] mapa) {
        this.mapa = mapa;
    }

    public Personagem[] getMapa() {
        return mapa;
    }

    public int getQuantosPersonagensTemNoMapa() {
        return quantosPersonagensTemNoMapa;
    }

    public String exibir(){
        this.verificaSeTemAlgumPersonagemMortoEDeletaEle();
        String retorno = "";
        for (Personagem personagem: mapa){
            if (personagem == null){
                retorno += "| ";
            }else {
                retorno += "|" + personagem.toString();
            }
        }
        return retorno+"|";
    }

    public void inserir(int posicao, Personagem personagem){
        this.verificaSeTemAlgumPersonagemMortoEDeletaEle();
        if (this.mapa[posicao] != null){
            throw new PosicaoOcupadaException();
        }else if(personagemEstaNoMapa(personagem)){
            throw new PersonagemJaEstaNoMapaException();
        }
        this.quantosPersonagensTemNoMapa +=1;
        personagem.setPosicao(posicao);
        this.mapa[posicao] = personagem;
    }

    public int buscarPosicao(Personagem personagem){
        this.verificaSeTemAlgumPersonagemMortoEDeletaEle();

        int posicao;
        boolean teveErro = true;

        for (posicao = 0; posicao < this.mapa.length; posicao++){
            if (this.mapa[posicao] == personagem){
                teveErro = false;
                break;
            }
        }
        if(teveErro){
            throw new PersonagemNaoEncontradoNoMapaException();
        }
        return posicao;
    }

    public Personagem buscarCasa(int posicao){
        return this.mapa[posicao];
    }

    public boolean personagemEstaNoMapa(Personagem personagem){
        for(Personagem temp: this.mapa) {
            if (temp == personagem) {
                return true;
            }
        }
        return false;
    }

    public boolean TemAlgumMembroDaSociedadeDoAnel(){
        this.verificaSeTemAlgumPersonagemMortoEDeletaEle();
        boolean teveErro = true;
        for(Personagem temp: this.mapa) {
            if (temp != null && temp.isSociedadeDoAnel()) {
                teveErro = false;
                break;
            }
        }
        if(teveErro){
            throw new SauronDominaOMundoException();
        }
        return true;
    }

    public void verificaSeTemAlgumPersonagemMortoEDeletaEle(){
        for (int posicao = 0; posicao < 10; posicao++){
            if(this.mapa[posicao] != null && this.mapa[posicao].getConstituicao() == 0){
                this.mapa[posicao] = null;
                this.quantosPersonagensTemNoMapa -= 1;
            }
        }

    }

}
