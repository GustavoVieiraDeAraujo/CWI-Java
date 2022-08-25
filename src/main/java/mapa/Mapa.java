package mapa;

import exceptions.*;
import personagens.*;

public class Mapa {

    private Personagem[] Mapa = new Personagem[10];
    private int quantosPersonagensTemNoMapa;

    public void setMapa(Personagem[] mapa) {
        this.Mapa = mapa;
    }

    public Personagem[] getMapa() {
        return Mapa;
    }

    public int getQuantosPersonagensTemNoMapa() {
        return quantosPersonagensTemNoMapa;
    }

    public String exibir(){
        StringBuilder bld = new StringBuilder();
        this.verificaSeTemAlgumPersonagemMortoEDeletaEle();
        for (Personagem personagem: Mapa){
            if (personagem == null){
                bld.append("| ");
            }else {
                bld.append("|").append(personagem.toString());
            }
        }
        bld.append("|");
        return bld.toString();
    }

    public void inserir(int posicao, Personagem personagem){
        this.verificaSeTemAlgumPersonagemMortoEDeletaEle();
        if (this.Mapa[posicao] != null){
            throw new PosicaoOcupadaException();
        }else if(personagemEstaNoMapa(personagem)){
            throw new PersonagemJaEstaNoMapaException();
        }
        this.quantosPersonagensTemNoMapa +=1;
        personagem.setPosicao(posicao);
        this.Mapa[posicao] = personagem;
    }

    public int buscarPosicao(Personagem personagem){
        this.verificaSeTemAlgumPersonagemMortoEDeletaEle();
        int posicao;
        boolean teveErro = true;

        for (posicao = 0; posicao < this.Mapa.length; posicao++){
            if (this.Mapa[posicao] == personagem){
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
        return this.Mapa[posicao];
    }

    public boolean personagemEstaNoMapa(Personagem personagem){
        for(Personagem temp: this.Mapa) {
            if (temp == personagem) {
                return true;
            }
        }
        return false;
    }

    public boolean temAlgumMembroDaSociedadeDoAnel(){
        this.verificaSeTemAlgumPersonagemMortoEDeletaEle();
        boolean teveErro = true;
        for(Personagem temp: this.Mapa) {
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
            if(this.Mapa[posicao] != null && this.Mapa[posicao].getConstituicao() == 0){
                this.Mapa[posicao] = null;
                this.quantosPersonagensTemNoMapa -= 1;
            }
        }

    }

}
