package personagens;

import racas.Humano;
import racas.Monstro;
import tiposdeclasse.TiposDeClasse;

public class Urukhai extends Personagem implements Humano, Monstro{
    public Urukhai(){super(8,6,3,45,false, TiposDeClasse.GUERREIRO);}

    @Override
    public String grunir() {
        return "Uuurrrrrr";
    }

    @Override
    public String falar() {
        return  "Looks like meat's back on the menu boys!";
    }

    @Override
    public void envelhecer() {
        int diferenca = constituicao - 2;
        if (diferenca < 0) {
            diferenca = 0;
        }
        constituicao = diferenca;
    }

    @Override
    public String toString(){
        return "U";
    }


}
