package personagens;

import racas.Humano;
import tiposdeclasse.TiposDeClasse;

public class Aragorn extends Personagem implements Humano{
    public Aragorn(){super(10,7,6,60,true, TiposDeClasse.GUERREIRO);}

    @Override
    public String falar() {
        return "A day may come when the courage of men fails… but it is not THIS day.";
    }

    public void envelhecer() {
        if (constituicao - 1 < 0) {
            constituicao = 0;
        }
        this.constituicao -= 1;
    }

    @Override
    public String toString() {
        return "A";
    }

}