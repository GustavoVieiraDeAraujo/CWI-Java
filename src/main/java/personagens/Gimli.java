package personagens;

import mapa.Mapa;
import racas.Anao;

public class Gimli extends Personagem implements Anao{

    public Gimli(){super(9,2,4,60,true);}

    @Override
    public void beber(){
        this.vezesQueBebeu +=1;
    }

    private int vezesQueBebeu = 0;

    @Override
    public String toString(){
        return "I";
    }

    @Override
    public String falar() {
       return this.vezesQueBebeu == 3 ? "What did I say? He can't hold his liquor!" : "Let them come. There is one Dwarf yet in Moria who still draws breath.";
    }

    @Override
    public void atacar(Mapa mapa) {
        Personagem atacante = mapa.buscarCasa(posicao);
        Personagem defensor = mapa.buscarCasa(posicao+1);
        if (defensor != null){
            if (posicao < 10 &&!defensor.isSociedadeDoAnel()) {
                defensor.receberDanoNaConstituicao(18);
                mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                if (mapa.getMapa()[posicao+1] == null) {
                    atacante.setPosicao(posicao+1);
                }
            }
        }else {
            atacante.setPosicao(posicao+1);
        }
    }
}
