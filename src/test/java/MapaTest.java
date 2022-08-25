import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.PosicaoOcupadaException;

import mapa.Mapa;
import org.junit.Assert;
import org.junit.Test;
import personagens.*;


public class MapaTest {

    @Test
    public void testandoABuscaDeUmPersonagemPeloObjetoQuandoEleEstaNoMapa(){
        Mapa mapa = new Mapa();
        Personagem aragorn = new Aragorn();
        Personagem legolas = new Legolas();
        Personagem orc = new Orc();
        Personagem goblim1 = new Goblim();
        mapa.inserir(0, aragorn);
        mapa.inserir(1, legolas);
        mapa.inserir(7, orc);
        mapa.inserir(9, goblim1);

        int goblim2 = mapa.buscarPosicao(goblim1);

        Assert.assertEquals(9, goblim2);
    }

    @Test(expected = PersonagemNaoEncontradoNoMapaException.class)
    public void testandoABuscaDeUmPersonagemPeloObjetoQuandoEleNãoEstaNoMapa(){
        Mapa mapa = new Mapa();
        Personagem aragorn = new Aragorn();
        Personagem legolas = new Legolas();
        Personagem orc = new Orc();
        Personagem goblim1 = new Goblim();
        mapa.inserir(0, aragorn);
        mapa.inserir(1, legolas);
        mapa.inserir(7, orc);

        int goblim2 = mapa.buscarPosicao(goblim1);

    }

    @Test(expected = PosicaoOcupadaException.class)
    public void tentandoEnserirUmPersonagemEmUmaPosicaoOcupada(){
        Mapa mapa = new Mapa();
        Personagem aragorn = new Aragorn();
        Personagem legolas = new Legolas();
        Personagem orc = new Orc();
        mapa.inserir(1, aragorn);
        mapa.inserir(2, legolas);
        mapa.inserir(1, orc);
    }

    @Test(expected = PersonagemJaEstaNoMapaException.class)
    public void tentandoEnserirUmPersonagemMaisDeUmaVez(){
        Mapa mapa = new Mapa();
        Personagem aragorn = new Aragorn();
        Personagem legolas = new Legolas();
        Personagem orc = new Orc();
        mapa.inserir(1, aragorn);
        mapa.inserir(2, legolas);
        mapa.inserir(3, aragorn);
    }

    @Test
    public void imprimirMapa(){
        String resultadoEsperado = "|A|L| | | | | |O| |M|";
        Aragorn aragorn = new Aragorn();
        Legolas legolas = new Legolas();
        Orc orc = new Orc();
        Goblim goblim = new Goblim();
        Mapa mapa = new Mapa();

        mapa.inserir(0, aragorn);
        mapa.inserir(1, legolas);
        mapa.inserir(7, orc);
        mapa.inserir(9, goblim);

        Assert.assertEquals(resultadoEsperado, mapa.exibir());
    }

    @Test
    public void verificarSeUmPersonagemEstaNoMapa(){
        Aragorn aragorn = new Aragorn();
        Legolas legolas = new Legolas();
        Orc orc = new Orc();
        Goblim goblim = new Goblim();
        Mapa mapa = new Mapa();

        mapa.inserir(0, aragorn);
        mapa.inserir(1, legolas);
        mapa.inserir(7, orc);
        mapa.inserir(9, goblim);

        boolean estaNoMapa = mapa.personagemEstaNoMapa(goblim);

        Assert.assertTrue(estaNoMapa);
    }

    @Test
    public void verificarSeUmPersonagemNaoEstaNoMapa(){
        Aragorn aragorn = new Aragorn();
        Legolas legolas = new Legolas();
        Orc orc = new Orc();
        Goblim goblim = new Goblim();
        Mapa mapa = new Mapa();

        mapa.inserir(0, aragorn);
        mapa.inserir(1, legolas);
        mapa.inserir(7, orc);

        boolean estaNoMapa = mapa.personagemEstaNoMapa(goblim);

        Assert.assertFalse(estaNoMapa);
    }


}
