package personagens;

import racas.Maia;
import tiposdeclasse.TiposDeClasse;

public class Saruman extends Personagem implements Maia {

    public Saruman() {
        super(2, 2, 9, 70, false, TiposDeClasse.MAGO);
    }

    private boolean reviveu = false;

    @Override
    public Object ressucitar() {
        if (!reviveu) {
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
    public String toString() {return "S";}

}