package nave;

import planetas.Planetas;

import java.util.ArrayList;
import java.util.List;

public class Nave {

    private int posicao = 0;
    private int quantidadeDeCombustível;

    public Nave(int quantidadeDeCombustível) {
        this.quantidadeDeCombustível = quantidadeDeCombustível;
    }

    public int getQuantidadeDeCombustivel() {
        return quantidadeDeCombustível;
    }

    public int getPosicao() {
        return posicao;
    }

    public List<String> explorar(Planetas planetaDestino) {

        // Lista dos recursos explorados;
        List<String> recursosExplorados = new ArrayList<String>();
        // Flag para saber se conseguiu chegar no Planeta;
        boolean flag = false;

        // Indo para o Planeta
        for (int posicao = 0; posicao != planetaDestino.getPosicao(); posicao++) {
            // Se a Nave ainda tem combustivel continua andando;
            if (this.quantidadeDeCombustível >= 3) {
                this.quantidadeDeCombustível -= 3;
                // Se não tiver combustivel, para e atualiza sua posição;
            } else {
                this.posicao = posicao;
                flag = true;
                break;
            }
        }

        // Explora os Recursos
        if (!flag) {
            for (String recurso : planetaDestino.getRecursos()) {
                if (!recursosExplorados.contains(recurso)){
                    recursosExplorados.add(recurso);

                }
            }
        }

        // Voltando do Planeta
        if (!flag) {
            for (posicao = planetaDestino.getPosicao(); posicao != 0; posicao--) {
                if (this.quantidadeDeCombustível >= 3) {
                    this.quantidadeDeCombustível -= 3;
                } else {
                    this.posicao = posicao;
                    break;
                }
            }
        }
        return recursosExplorados;
    }

    public List<String> explorar(ArrayList<Planetas> listaDePlanetas){
        // Planeta mais longe;
        Planetas planetaMaisLonge = null;

        // Posição do planeta mais longe;
        int posicaoDoPlanetaMaisLonge = 0;

        // Lista dos recursos explorados;
        List<String> recursosExplorados = new ArrayList<String>();

        // Pega a posição do planeta mais longe e os recursos dos planetas;
        for(Planetas planetaDestino: listaDePlanetas){
            if (planetaDestino.getPosicao() > posicaoDoPlanetaMaisLonge){
                posicaoDoPlanetaMaisLonge = planetaDestino.getPosicao();
                planetaMaisLonge = planetaDestino;
            }
            for (String recurso: planetaDestino.getRecursos()){
                if(!recursosExplorados.contains(recurso)){
                    recursosExplorados.add(recurso);
                }
            }
        }

        // Atualiza a posição da nave
        this.explorar(planetaMaisLonge);

        return recursosExplorados;
    }
}

