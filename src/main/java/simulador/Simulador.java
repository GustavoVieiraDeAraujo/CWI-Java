package simulador;

import mapa.Mapa;
import personagens.Personagem;

public class Simulador {

    private Mapa mapa;
    private Mapa mapaAuxiliar;

    public Simulador(Mapa mapa) {
        this.mapa = mapa;
        this.mapaAuxiliar = new Mapa();
    }

    public void simular() {
        while (mapa.temAlgumMembroDaSociedadeDoAnel()) {
            if (mapa.getMapa()[9] != null && mapa.getMapa()[9].isSociedadeDoAnel()) {
                break;
            }else {
                for (Personagem personagem1 : mapa.getMapa()){
                    if(personagem1 != null){
                        personagem1.atacar(mapa, personagem1.getClasse(), personagem1.isSociedadeDoAnel());
                    }
                }
            }
            for (Personagem personagem2 : mapa.getMapa()){
                if (personagem2 != null){
                    int novaPosicao = personagem2.getPosicao();
                    mapaAuxiliar.getMapa()[novaPosicao] = personagem2;
                }
            }
            mapa.setMapa(mapaAuxiliar.getMapa());
            mapaAuxiliar = new Mapa();
        }
    }
}
