package planetas;

import java.util.ArrayList;

public class Planetas {

    private int posicao;
    private ArrayList<String> recursos;

    public Planetas(int posicao, ArrayList<String> recursos) {
        this.posicao = posicao;
        this.recursos = recursos;
    }

    public ArrayList<String> getRecursos() {
        return recursos;
    }

    public int getPosicao() {
        return posicao;
    }

    public int valorTotal() {
        int valorTotal = 0;
        for (String recurso : this.recursos) {
            switch (recurso) {
                case "Agua":
                    valorTotal += 180;
                    break;
                case "Oxigenio":
                    valorTotal += 300;
                    break;
                case "Silicio":
                    valorTotal += 60;
                    break;
                case "Ouro":
                    valorTotal += 120;
                    break;
                case "Ferro":
                    valorTotal += 30;
                    break;
            }
        }
        return valorTotal;
    }

    public int valorPorPeso() {
        int valorPorPeso = 0;
        for (String recurso : this.recursos) {
            switch (recurso) {
                case "Agua":
                    valorPorPeso += 18;
                    break;
                case "Oxigenio":
                    valorPorPeso += 150;
                    break;
                case "Silicio":
                    valorPorPeso += 3;
                    break;
                case "Ouro":
                    valorPorPeso += 4;
                    break;
                case "Ferro":
                    valorPorPeso += 0;
                    break;
            }
        }
        return valorPorPeso;
    }

}
