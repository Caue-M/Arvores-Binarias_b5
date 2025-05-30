public class Main {
    public static void main(String[] args) {

        Contador contador = new Contador();
        contador.raiz = new No(1);
        contador.raiz.esq = new No(2);
        contador.raiz.dir = new No(3);
        contador.raiz.esq.esq = new No(4);
        contador.raiz.dir.dir = new No(5);

        int qtdeNos = contador.contadorNos();
        System.out.println("Total: " + qtdeNos);

    }
}