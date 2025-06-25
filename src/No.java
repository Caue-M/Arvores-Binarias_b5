public class No {
    String valor;
    No direita;
    No esquerda;
    int dado;

    public No(String valor){
        this.valor = valor;
        direita = null;
        esquerda = null;
    }
    public No(int dado) {
        this.dado = dado;
        this.esquerda = this.direita = null;
    }
}