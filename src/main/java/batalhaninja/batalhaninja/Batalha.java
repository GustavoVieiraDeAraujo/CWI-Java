package batalhaninja.batalhaninja;

public class Batalha {

    public Ninja lutar(Ninja primeiroNinja, Ninja segundoNinja){
        if (primeiroNinja != null && primeiroNinja.getNome().equals("Itachi")) {
            return primeiroNinja;
        } else if (segundoNinja != null && segundoNinja.getNome().equals("Itachi")) {
            return segundoNinja;
        }else{
            for (int i=0; i < 3; i++){
                primeiroNinja.atacar(segundoNinja);
                segundoNinja.atacar(primeiroNinja);
            }
            if (primeiroNinja.getChakra() == segundoNinja.getChakra() || primeiroNinja.getChakra() > segundoNinja.getChakra()){
                return primeiroNinja;
            } else {
                return segundoNinja;
            }
        }
    }

}
