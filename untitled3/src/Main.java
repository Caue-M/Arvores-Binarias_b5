public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();

        int[] chaves = {1, 2, 3, 4, 5, 6};
        for (int chave : chaves){
            arvore.raiz = arvore.inserir(arvore.raiz, chave);
        }

        System.out.println("Percurso em ordem da arvore AVL");
        arvore.emOrdem(arvore.raiz);
    }
}
