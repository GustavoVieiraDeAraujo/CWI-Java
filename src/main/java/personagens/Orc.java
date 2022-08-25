package personagens;

import racas.Monstro;
import tiposdeclasse.TiposDeClasse;

public class Orc extends Personagem implements Monstro{

    public Orc(){super(7,4,1,30,false, TiposDeClasse.GUERREIRO);}

    @Override
    public String toString(){
        return "O";
    }

    @Override
    public String grunir(){
        return "Arrrggghhh";
    }


}
