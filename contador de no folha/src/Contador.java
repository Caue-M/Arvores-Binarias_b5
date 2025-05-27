import java.util.LinkedList;
import java.util.Queue;

public class Contador {
    No raiz;
    int cont = 0;

    int contadorNos() {
        if (raiz == null) {
            return 0;
        }
        Queue<No> queue = new LinkedList<>();
        queue.add(raiz);

        while (!queue.isEmpty()) {
            No atual = queue.poll();

            if (atual.esq == null && atual.dir == null) {
                cont++;
            }
            if (atual.dir != null) {
                queue.add(atual.dir);
            }
            if (atual.esq != null) {
                queue.add(atual.esq);

            }
        }
        return cont;
    }
}
