public class Batalha {
    public Ninja lutar(Ninja primeiroNinja, Ninja segundoNinja){
        if (primeiroNinja.getNome() == "Itachi") {
            return primeiroNinja;
        } else if (segundoNinja.getNome() == "Itachi") {
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
