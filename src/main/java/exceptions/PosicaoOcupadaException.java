package exceptions;

public class PosicaoOcupadaException extends RuntimeException{
    public PosicaoOcupadaException(){
        super("Posicao Ocupada");
    }
}
