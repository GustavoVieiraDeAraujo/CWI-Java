package negociacao;

import clube.Clube;
import jogador.Jogador;

public class Negociacao {

    public boolean negociar(Clube clubeQueDesejaComprarOJogador, Jogador jogadorQueEstaSendoNegociado){
        boolean jogadorTemInteresse = jogadorQueEstaSendoNegociado.temInteresseEmTrocarDeClube(clubeQueDesejaComprarOJogador);
        boolean clubePodeComprarJogador =  clubeQueDesejaComprarOJogador.getSaldoDisponivelEmCaixa() >= jogadorQueEstaSendoNegociado.valorMinimoDeCompraDoJogador();

        if (jogadorTemInteresse && clubePodeComprarJogador){
            jogadorQueEstaSendoNegociado.setClubeAtual(clubeQueDesejaComprarOJogador);
            clubeQueDesejaComprarOJogador.setSaldoDisponivelEmCaixa(jogadorQueEstaSendoNegociado.valorMinimoDeCompraDoJogador());
            return true;
        } else {
            return false;
        }
    }

}
