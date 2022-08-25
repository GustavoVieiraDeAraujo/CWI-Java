package personagens;

import mapa.Mapa;
import racas.Anao;

public class Gimli extends Personagem implements Anao {

    private int constituicao = 60;
    private int vezesQueBebeu = 0;
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
    public boolean isSociedadeDoAnel() {
        return true;
    }

    @Override
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    @Override
    public int getPosicao() {
        return posicao;
    }

    @Override
    public void beber(){
        this.vezesQueBebeu +=1;
    }

    @Override
    public String falar() {
       return this.vezesQueBebeu == 3 ? "What did I say? He can't hold his liquor!" : "Let them come. There is one Dwarf yet in Moria who still draws breath.";
    }

    @Override
    public String toString(){
        return "I";
    }

    @Override
    public void atacar(Mapa mapa) {
        Personagem atacante = mapa.buscarCasa(this.posicao);
        Personagem defensor = mapa.buscarCasa(this.posicao+1);
        if (defensor != null){
            if (this.posicao < 10) {
                if (!defensor.isSociedadeDoAnel()) {
                    defensor.receberDanoNaConstituicao(18);
                    mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
                    if (mapa.getMapa()[this.posicao+1] == null) {
                        atacante.setPosicao(this.posicao+1);
                    }
                }
            }
        }else {
            atacante.setPosicao(this.posicao+1);
        }
    }
}
