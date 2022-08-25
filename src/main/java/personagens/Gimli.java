package personagens;

import racas.Anao;
import tiposdeclasse.TiposDeClasse;

public class Gimli extends Personagem implements Anao{

    public Gimli(){super(9,2,4,60,true, TiposDeClasse.GUERREIRO);}

    @Override
    public void beber(){
        this.vezesQueBebeu +=1;
    }

    private int vezesQueBebeu = 0;

    @Override
    public String toString(){
        return "I";
    }

    @Override
    public String falar() {
       return this.vezesQueBebeu == 3 ? "What did I say? He can't hold his liquor!" : "Let them come. There is one Dwarf yet in Moria who still draws breath.";
    }

}
