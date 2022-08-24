package dicionario;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {

    private Map<String, String> dicionarioPortugues;
    private Map<String, String> dicionarioIngles;

    public Dicionario(){
        this.dicionarioPortugues = new HashMap<>();
        this.dicionarioIngles = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String traducao, TipoDicionario dicionario){
        if(TipoDicionario.PORTUGUES.equals(dicionario)){
                this.dicionarioPortugues.put(palavra, traducao);
        }else if (TipoDicionario.INGLES.equals(dicionario)){
                this.dicionarioIngles.put(palavra, traducao);
        }
    }

    public String traduzir(String palavra, TipoDicionario dicionarioDeBusca){
        String palavraTraduzida = null;
        if(TipoDicionario.PORTUGUES.equals(dicionarioDeBusca)){
            palavraTraduzida = this.dicionarioPortugues.get(this.formataPrimeiraLetraMaiusculaERestoMinuscula(palavra));
            if(palavraTraduzida == null){
                throw new PalavraNaoEncontradaException();
            }
        }else if (TipoDicionario.INGLES.equals(dicionarioDeBusca)){
            palavraTraduzida = this.dicionarioIngles.get(this.formataPrimeiraLetraMaiusculaERestoMinuscula(palavra));
            if(palavraTraduzida == null){
                throw new PalavraNaoEncontradaException();
            }
        }
        return palavraTraduzida;
    }

    private String formataPrimeiraLetraMaiusculaERestoMinuscula(String palavra){
        String primeiraLetra = palavra.substring(0, 1);
        String restoDaPalavra = palavra.substring(1, palavra.length());

        return primeiraLetra.toUpperCase()+restoDaPalavra.toLowerCase();
    }

}
