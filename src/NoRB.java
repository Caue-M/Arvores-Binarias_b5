public class NoRB {
    int valor;
    NoRB esquerda, direita, pai;
    Cores cor;

    public NoRB(int valor) {
        this.valor = valor;
        this.cor = Cores.VERMELHO;
    }
}
