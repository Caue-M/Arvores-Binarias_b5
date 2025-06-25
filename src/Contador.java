import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Classe contador, utilizado para o EX - 2
//Implementa teste na main
public class Contador {
    public int contar(No valor){
        if(valor == null) return 0;
        return 1 + contar(valor.esquerda) + contar(valor.direita);
    }

    //Contador em pré ordem, utilizado para o exercício 3
    public void contarPreOrdem(No no) {
        if (no != null) {
            System.out.print(no.valor + ", ");
            contarPreOrdem(no.esquerda);
            contarPreOrdem(no.direita);
        }
    }
    //contador "em ordem", utilizado para o exercicio 4
    public void contarEmOrdem(No no) {
        if (no != null) {
            contarEmOrdem(no.esquerda);
            System.out.print(no.valor + ", ");
            contarEmOrdem(no.direita);
        }
    }
    //Contador pos ordem, exercicio 5
    public void contarPosOrdem(No no) {
        if (no != null) {
            contarPosOrdem(no.esquerda);
            contarPosOrdem(no.direita);
            System.out.print(no.valor + ", ");
        }
    }
    //Localizador de nós, exercício 6
    public void busca(No raiz){
        if (raiz == null) return;
        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while(!fila.isEmpty()){
            No atual = fila.poll();
            System.out.print((atual.valor + ", "));
            if(atual.esquerda != null){
                fila.add(atual.esquerda);
            }
            if (atual.direita != null){
                fila.add(atual.direita);
            }
        }
    }
    //Contador de nós-folha recursivo, exercício 7
    public int contarNosFolha(No no){
        if (no == null)return 0;
        if (no.esquerda == null && no.direita == null) return 1;
        return contarNosFolha(no.esquerda) + contarNosFolha(no.direita);
    }

    //Exercicio 9, contador de nós reursivo
    public int contarNosFolhaRecursivo(No no){
        if (no == null)return 0;
        if (no.esquerda == null && no.direita == null) return 1;
        return contarNosFolha(no.esquerda) + contarNosFolha(no.direita);
    }

    //Contador de nós recursivo, exercício 8
    int contadorNos(No raiz) {
        if (raiz == null) return 0;

        int cont = 0;
        Queue<No> queue = new LinkedList<>();
        queue.add(raiz);

        while (!queue.isEmpty()) {
            No atual = queue.poll();
            if (atual.esquerda == null && atual.direita == null) {
                cont++;
            }
            if (atual.direita != null) queue.add(atual.direita);
            if (atual.esquerda != null) queue.add(atual.esquerda);
        }

        return cont;
    }

    int contadorNosPilha(No raiz) {
        if (raiz == null) return 0;

        int cont = 0;
        Stack<No> pilha = new Stack<>();
        pilha.add(raiz);

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            cont++;
            if (atual.esquerda != null) pilha.push(atual.esquerda);
            if (atual.direita != null) pilha.push(atual.direita);
        }

        return cont;
    }

}
