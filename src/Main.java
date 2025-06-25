public class Main {
    public static void main(String[] args) {
        //Testes de contagem
        Contador contador = new Contador();
        No noA = new No("A");
        No noB = new No("B");
        No noC = new No("C");
        No noD = new No("D");
        No noE = new No("E");
        //Definição da estrutura
        noA.esquerda = noB;
        noA.direita = noC;
        noB.esquerda = noD;
        noB.direita = noE;

        System.out.println("Contador de nós: ");
        System.out.println(contador.contar(noA));

        System.out.println("\nExibição em pré ordem: ");
        contador.contarPreOrdem(noA);

        System.out.println("\nExibição Em Ordem: ");
        contador.contarEmOrdem(noA);

        System.out.println("\nExibição em Pós-Ordem");
        contador.contarPosOrdem(noA);

        System.out.println("\nBusca na árvore");
        contador.busca(noA);

        //Contador de nós-folha iterativo
        int qtdeNos = contador.contadorNos(noA);
        System.out.println("\nTotal de nós-folha iterativo: " + qtdeNos);

        //Contador de nós com pilha
        int qtdeNosPilha = contador.contadorNosPilha(noA);
        System.out.print("\nTotal de nós com pilha: " + qtdeNosPilha);
    }
}
