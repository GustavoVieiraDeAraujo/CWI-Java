
import org.junit.Assert;
import org.junit.Test;
import personagens.*;


public class RacasTest {

    @Test
    public void aragornDeveFalarSuaFrase(){
        Aragorn aragorn = new Aragorn();
        Assert.assertEquals("A day may come when the courage of men fails… but it is not THIS day.", aragorn.falar());
    }

    @Test
    public void aragornDevePerder1PontoDeConstituicaoQuandoEnvelhecer(){
        Aragorn aragorn = new Aragorn();

        aragorn.envelhecer();

        Assert.assertEquals(59, aragorn.getConstituicao());
    }

    @Test
    public void aragornDevePerder5PontoDeConstituicaoQuandoEnvelhecer5vezes(){
        Aragorn aragorn = new Aragorn();

        aragorn.envelhecer();
        aragorn.envelhecer();
        aragorn.envelhecer();
        aragorn.envelhecer();
        aragorn.envelhecer();

        Assert.assertEquals(55, aragorn.getConstituicao());
    }

    @Test
    public void gimliDeveFalarSuaFraseQuandoNãoEstaBebado(){
        Gimli gimli = new Gimli();
        Assert.assertEquals("Let them come. There is one Dwarf yet in Moria who still draws breath.", gimli.falar());
    }

    @Test
    public void gimliDeveFalarSuaFraseQuandoEstaBebado(){
        Gimli gimli = new Gimli();
        gimli.beber();
        gimli.beber();
        gimli.beber();
        Assert.assertEquals("What did I say? He can't hold his liquor!", gimli.falar());
    }

    @Test
    public void legolasDeveFalarSuaFraseNormal(){
        Legolas legolas = new Legolas();
        Assert.assertEquals("They're taking the Hobbits to Isengard!", legolas.falar());
    }

    @Test
    public void legolasDeveFalarSuaFraseElfica(){
        Legolas legolas = new Legolas();
        Assert.assertEquals("I amar prestar aen, han mathon ne nem, han mathon ne chae, a han noston ned.", legolas.falaEmElfico());
    }


    @Test
    public void quandoGandalfRessucitarDeveRetornarUmaNovaInstaciaDeleMesmo(){
        Gandalf gandalf = new Gandalf();

        Assert.assertEquals(gandalf.toString(), gandalf.ressucitar().toString());
    }

    @Test
    public void quandoGandalfRessucitar1VezNãoDeveConseguirRessucitarDenovo(){
        Gandalf gandalf = new Gandalf();

        gandalf.ressucitar();

        Assert.assertEquals(null, gandalf.ressucitar());
    }


    @Test
    public void quandoSarumanRessucitarDeveRetornarNull(){
        Saruman saruman = new Saruman();

        Assert.assertEquals(null, saruman.ressucitar());
    }

    @Test
    public void orcDeveGrunir(){
        Orc orc = new Orc();
        Assert.assertEquals("Arrrggghhh", orc.grunir());
    }

    @Test
    public void urukhaiDeveGrunir(){
        Urukhai urukhai = new Urukhai();
        Assert.assertEquals("Uuurrrrrr", urukhai.grunir());
    }

    @Test
    public void urukhaiDeveFalar(){
        Urukhai urukhai = new Urukhai();
        Assert.assertEquals("Looks like meat's back on the menu boys!", urukhai.falar());
    }


    @Test
    public void urukhaiDevePerder2PontoDeConstituicaoQuandoEnvelhecer(){
        Urukhai urukhai = new Urukhai();

        urukhai.envelhecer();

        Assert.assertEquals(43, urukhai.getConstituicao());
    }

    @Test
    public void urukhaiDevePerder10PontoDeConstituicaoQuandoEnvelhecer5Vezes(){
        Urukhai urukhai = new Urukhai();

        urukhai.envelhecer();
        urukhai.envelhecer();
        urukhai.envelhecer();
        urukhai.envelhecer();
        urukhai.envelhecer();

        Assert.assertEquals(35, urukhai.getConstituicao());
    }

    @Test
    public void deveAtualizarConstituicaoQuandoReceberDano(){
        Urukhai urukhai = new Urukhai();

        urukhai.receberDanoNaConstituicao(10);

        Assert.assertEquals(35, urukhai.getConstituicao());
    }

    @Test
    public void deveDeixarAConstituicaoIgualAZeroQuandoReceberUmDanoMaiorQueAConstituicao(){
        Urukhai urukhai = new Urukhai();

        urukhai.receberDanoNaConstituicao(100);

        Assert.assertEquals(0, urukhai.getConstituicao());
    }

}
