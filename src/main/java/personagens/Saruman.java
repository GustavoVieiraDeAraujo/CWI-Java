package personagens;

import mapa.Mapa;
import racas.Maia;

public class Saruman extends Personagem implements Maia{

    public Saruman(){super(2,2,9,70,false);}
    private boolean reviveu = false;

    @Override
    public Object ressucitar() {
        if (!reviveu){
            reviveu = true;
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
        Personagem atacante = mapa.buscarCasa(posicao);
        if ( posicao > 0) {
            for(Personagem defensor : mapa.getMapa()){
                if(defensor != null && defensor.isSociedadeDoAnel()){
                    defensor.receberDanoNaConstituicao(9);
                }
            }
            mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
            if(mapa.getQuantosPersonagensTemNoMapa() == 1){
                atacante.setPosicao(posicao+=1);
            }
        }
    }
}
