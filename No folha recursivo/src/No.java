public class No {
    No esq, dir, raiz;
    int dado;

    public No(int dado) {
        this.dado = dado;
        this.esq = this.dir = null;
    }
}