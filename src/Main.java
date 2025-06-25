public class Main {
    public static void main(String[] args) {
        // Testes de contagem com árvore avl
        Contador contador = new Contador();
        Arvore arvoreAVL = new Arvore();
        No noA = new No("A");
        No noB = new No("B");
        No noC = new No("C");
        No noD = new No("D");
        No noE = new No("E");

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

        int qtdeNos = contador.contadorNos(noA);
        System.out.println("\nTotal de nós-folha iterativo: " + qtdeNos);

        int qtdeNosPilha = contador.contadorNosPilha(noA);
        System.out.print("\nTotal de nós com pilha: " + qtdeNosPilha);

        // Teste AVL - Exercício 11
        int[] chaves = {1, 2, 3, 4, 5, 6};
        for (int chave : chaves) {
            arvoreAVL.raiz = arvoreAVL.inserir(arvoreAVL.raiz, chave);
        }

        System.out.println("\nPercurso em ordem da árvore AVL:");
        arvoreAVL.emOrdem(arvoreAVL.raiz);

        // Árvore RB
        System.out.println("\nÁrvore Rubro-Negra: ");
        ArvoreRB arvoreRB = new ArvoreRB();
        int[] valoresRB = {10, 20, 30, 15, 25, 5};

        for (int valor : valoresRB) {
            arvoreRB.inserir(valor);
        }

        System.out.println("\nTravessia em ordem (RB):");
        arvoreRB.emOrdemRB();

        System.out.println("\nTravessia pré-ordem (RB):");
        arvoreRB.preOrdemRB();

        System.out.println("\nTravessia pós-ordem (RB):");
        arvoreRB.posOrdemRB();

        int totalNosRB = arvoreRB.contarNos(arvoreRB.getRaiz());
        System.out.println("\nTotal de nós RB: " + totalNosRB);

        int folhasRB = arvoreRB.contarNosFolha(arvoreRB.getRaiz());
        System.out.println("Total de folhas RB: " + folhasRB);
    }
}
