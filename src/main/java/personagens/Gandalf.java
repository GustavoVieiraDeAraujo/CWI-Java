package personagens;

import mapa.Mapa;
import racas.Maia;

public class Gandalf extends Personagem implements Maia{
    public Gandalf(){super(2,3,10,80,true);}
    private boolean reviveu = false;

    @Override
    public String falar(){
        return "A Wizard is never late, nor is he early. He arrives precisely when he means to.";
    }

    @Override
    public Gandalf ressucitar() {
        if (!reviveu){
            reviveu = true;
            return new Gandalf();
        }
        return null;
    }

    @Override
    public void atacar(Mapa mapa) {
        Personagem atacante = mapa.buscarCasa(this.posicao);
        if (posicao < 10) {
            for (Personagem defensor : mapa.getMapa()) {
                if (defensor != null && !defensor.isSociedadeDoAnel()) {
                    defensor.receberDanoNaConstituicao(10);
                }
            }
            mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
            if (mapa.getQuantosPersonagensTemNoMapa() == 1) {
                atacante.setPosicao(posicao+1);
            }
        }
    }

    @Override
    public String toString(){
        return "G";
    }


}
