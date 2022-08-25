package personagens;

import mapa.Mapa;
import racas.Maia;

public class Gandalf extends Personagem implements Maia{

    private int constituicao = 80;

    private int posicao = 0;

    private boolean reviveu = false;

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
    public Gandalf ressucitar() {
        if (!this.reviveu){
            this.reviveu = true;
            return new Gandalf();
        }
        return null;
    }

    @Override
    public String falar(){
        return "A Wizard is never late, nor is he early. He arrives precisely when he means to.";
    }

    @Override
    public String toString(){
        return "G";
    }

    @Override
    public void atacar(Mapa mapa) {
        Personagem atacante = mapa.buscarCasa(this.posicao);
        if (this.posicao < 10) {
            for (Personagem defensor : mapa.getMapa()) {
                if (defensor != null && !defensor.isSociedadeDoAnel()) {
                    defensor.receberDanoNaConstituicao(10);
                }
            }
            mapa.verificaSeTemAlgumPersonagemMortoEDeletaEle();
            if (mapa.getQuantosPersonagensTemNoMapa() == 1) {
                atacante.setPosicao(this.posicao+1);
            }
        }
    }

}
