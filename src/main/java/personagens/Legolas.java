package personagens;

import racas.Elfo;
import tiposdeclasse.TiposDeClasse;

public class Legolas extends Personagem implements Elfo{

    public Legolas(){super(5,10,6,80,true, TiposDeClasse.ARQUEIRO);}

    @Override
    public String falar() {
        return "They're taking the Hobbits to Isengard!";
    }

    @Override
    public String falaEmElfico(){
        return "I amar prestar aen, han mathon ne nem, han mathon ne chae, a han noston ned.";
    }

    @Override
    public String toString(){
        return "L";
    }

}
