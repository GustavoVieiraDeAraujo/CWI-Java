public class Jutsu {
    private int quantidadeDeChakra;
    private int quantidadeDeChakraQueAbateDoOponente;

    public Jutsu (int quantidadeDeChakra, int quantidadeDeChakraQueAbateDoOponente){
        if (quantidadeDeChakra <= 5 && quantidadeDeChakraQueAbateDoOponente <= 10){
            this.quantidadeDeChakra = quantidadeDeChakra;
            this.quantidadeDeChakraQueAbateDoOponente = quantidadeDeChakraQueAbateDoOponente;
        }
    }

    public int getQuantidadeDeChakra() {
        return quantidadeDeChakra;
    }

    public int getQuantidadeDeChakraQueAbateDoOponente() {
        return quantidadeDeChakraQueAbateDoOponente;
    }
}
