import dicionario.Dicionario;
import dicionario.PalavraNaoEncontradaException;
import dicionario.TipoDicionario;

import org.junit.Assert;
import org.junit.Test;

public class DicionarioTest {

    @Test
    public void deveTraduzirCarroELivroDoInglesParaPortuguesEDoPortuguesParaOIngles() {
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavra("Carro", "Car", TipoDicionario.INGLES);
        dicionario.adicionarPalavra("Livro", "Book", TipoDicionario.INGLES);
        dicionario.adicionarPalavra("Tiger", "Tigre", TipoDicionario.PORTUGUES);
        dicionario.adicionarPalavra("Paper", "Papel", TipoDicionario.PORTUGUES);

        Assert.assertEquals("Car", dicionario.traduzir("carro", TipoDicionario.INGLES));
        Assert.assertEquals("Book", dicionario.traduzir("lIVRO", TipoDicionario.INGLES));

        Assert.assertEquals("Papel", dicionario.traduzir("pApEr", TipoDicionario.PORTUGUES));
        Assert.assertEquals("Tigre", dicionario.traduzir("TIGER", TipoDicionario.PORTUGUES));
    }

    @Test(expected = PalavraNaoEncontradaException.class)
    public void deveLancarExceptionQuandoUmaPalavraNaoForEncontrada() {
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavra("Carro", "Car", TipoDicionario.INGLES);
        dicionario.adicionarPalavra("Livro", "Book", TipoDicionario.INGLES);

        String traducao = dicionario.traduzir("Caneta", TipoDicionario.INGLES);
    }

    @Test(expected = PalavraNaoEncontradaException.class)
    public void deveLancarExceptionQuandoNãoAcharUmaPalavraNoDicionarioDePortugues() {
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavra("Car", "Carro", TipoDicionario.PORTUGUES);
        dicionario.adicionarPalavra("Book", "Livro", TipoDicionario.PORTUGUES);

        String traducao = dicionario.traduzir("Caneta", TipoDicionario.INGLES);
    }


}