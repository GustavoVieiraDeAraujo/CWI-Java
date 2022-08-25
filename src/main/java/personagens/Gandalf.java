package personagens;

import racas.Maia;
import tiposdeclasse.TiposDeClasse;

public class Gandalf extends Personagem implements Maia{
    public Gandalf(){super(2,3,10,80,true, TiposDeClasse.MAGO);}
    private boolean reviveu = false;

    @Override
    public String falar(){
        return "A Wizard is never late, nor is he early. He arrives precisely when he means to.";
    }

    @Override
    public Gandalf ressucitar() {
        if (!reviveu){
            reviveu = true;
            return new Gandalf();
        }
        return null;
    }

    @Override
    public String toString(){
        return "G";
    }

}
