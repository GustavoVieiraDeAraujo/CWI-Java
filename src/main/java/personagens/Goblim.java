package personagens;

import racas.Monstro;
import tiposdeclasse.TiposDeClasse;

public class Goblim extends Personagem implements Monstro{
    public Goblim(){super(3,6,1,20,false, TiposDeClasse.ARQUEIRO);}

    @Override
    public String toString(){
        return "M";
    }

    @Override
    public String grunir(){
        return "Iiisshhhh";
    }

}
