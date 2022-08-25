package personagens;

import racas.Humano;
import tiposdeclasse.TiposDeClasse;

public class Boromir extends Personagem implements Humano{

    public Boromir(){super(7,6,3,40,true, TiposDeClasse.GUERREIRO);}

    @Override
    public String falar() {
        return "One does not simply walk into Mordor.";
    }

    @Override
    public String toString(){
        return "B";
    }


    @Override
    public void envelhecer() {
        int diferenca = this.constituicao - 2;
        if (diferenca <= 0) {
            diferenca = 0;
        }
        this.constituicao = diferenca;
    }
}
