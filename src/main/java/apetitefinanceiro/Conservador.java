package apetitefinanceiro;

public class Conservador extends ApetiteFinanceiro {
    final double taxa = 1.4;
    @Override
    public double getTaxa() {
        return this.taxa;
    }
}
