import java.util.LinkedList;
import java.util.Stack;

public class Contador {
    No raiz;
    int cont = 0;

    int contadorNos() {
        if (raiz == null) {
            return 0;
        }
        Stack<No> pilha = new Stack<>();
        pilha.add(raiz);

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            cont++;

            if (atual.esq != null) {
                pilha.push(atual.esq);
            }
            if (atual.dir != null) {
                pilha.push(atual.dir);
            }
        }
        return cont;
    }
}