package personagens;

import mapa.Mapa;
import racas.Maia;

public class Saruman extends Personagem implements Maia{

    private int constituicao = 70;

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
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    @Override
    public int getPosicao() {
        return posicao;
    }

    private boolean reviveu = false;

    @Override
    public boolean isSociedadeDoAnel() {
        return false;
    }

    @Override
    public Object ressucitar() {
        if (!this.reviveu){
            this.reviveu = true;
            return null;
        }
        return null;
    }

    @Override
    public String falar() {
        return "Against the power of Mordor there can be no victory.";
    }

    @Override
    public String toString(){
        return "S";
    }

    @Override
    public void atacar(Mapa mapa) {
        Personagem atacante = mapa.buscarCasa(this.posicao);
        if ( this.posicao > 0) {
            for(Personagem defensor : mapa.getMapa()){
                if(defensor != null && defensor.isSociedadeDoAnel()){
                    defensor.receberDanoNaConstituicao(9);
                }
            }
            mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
            if(mapa.getQuantosPersonagensTemNoMapa() == 1){
                atacante.setPosicao(this.posicao+=1);
            }
        }
    }
}
