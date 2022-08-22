public class Ninja {
    private int chakra = 100;
    private String nome;
    private Jutsu jutsuPrincipal;

    public Ninja(String nome, Jutsu jutsuPrincipal){
        this.nome = nome;
        this.jutsuPrincipal = jutsuPrincipal;
    }

    public void atacar(Ninja ninjaOponente){
        ninjaOponente.receberGolpe(this.jutsuPrincipal.getQuantidadeDeChakraQueAbateDoOponente());
        this.chakra -= jutsuPrincipal.getQuantidadeDeChakra();
    }

    private void receberGolpe(int danoDoGolpe){
        this.chakra -= danoDoGolpe;
    }

    public int getChakra() { return chakra;}

    public String getNome() { return nome;}
}
