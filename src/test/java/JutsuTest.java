import org.junit.Assert;
import org.junit.Test;

public class JutsuTest {

    @Test
    public void verificaSeOsAtributosDoJutsuEstaoCorreto(){
        Jutsu jutsu = new Jutsu(5,10);
        Assert.assertArrayEquals(new int[] {5, 10}, new int[] {jutsu.getQuantidadeDeChakra(), jutsu.getQuantidadeDeChakraQueAbateDoOponente()});
    }

    @Test
    public void verificaSeOsAtributosDoJutsuEstaoIncorretos(){
        Jutsu jutsu = new Jutsu(7,17);
        Assert.assertArrayEquals(new int[] {0, 0}, new int[] {jutsu.getQuantidadeDeChakra(), jutsu.getQuantidadeDeChakraQueAbateDoOponente()});
    }

}
