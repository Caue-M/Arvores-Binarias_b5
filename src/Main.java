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
        System.out.println();
        System.out.println("Exibição em pré ordem: ");
        contador.contarPreOrdem(noA);
        System.out.println("\nExibição Em Ordem: ");
        contador.contarEmOrdem(noA);
    }
}