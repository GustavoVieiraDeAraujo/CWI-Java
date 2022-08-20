public class Calculadora{
    // Qual o problema? Criar uma calculadora
    // Quais são os dados necessarios ? Dois valores para realizar as operações
    // Quais operações necessarias? soma, subtração, divisão, multiplicação

    public double soma(double valor1, double valor2){
        return valor1+valor2;
    }

    public double subtracao(double valor1, double valor2){
        return valor1-valor2;
    }

    public double multiplicacao(double valor1, double valor2){
        return  valor1*valor2;
    }

    public double divisao(double valor1, double valor2){
        return valor1 / valor2;
    }

    public double radiciacao(double qualValorQuerTirarRaiz, double indiceDaRaiz){
        return (qualValorQuerTirarRaiz >= 1) ? Math.pow(qualValorQuerTirarRaiz, 1/indiceDaRaiz) : 0;
    }

    public double potenciacao(double qualValorQuerElevar, double expoente){
        return (expoente >= 1) ? Math.pow(qualValorQuerElevar, expoente) : 0;
    }

    public double bhaskara(double a, double b, double c){
        double delta = (Math.pow(b, 2)) - (4*a*c) ;
        double x1 = (-b - Math.sqrt(delta)) / (2*a);
        double x2 = (-b + Math.sqrt(delta)) / (2*a);
        return x1+x2;
    }
}
