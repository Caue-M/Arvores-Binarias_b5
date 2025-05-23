import java.util.LinkedList;
import java.util.Queue;

public class No {
        String valor;
        No esquerda;
        No direita;
        No raiz;

        public No(String valor){
            this.valor = valor;
            esquerda = null;
            direita = null;
        }

        public void busca(){
        if (raiz == null) return;
        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while(!fila.isEmpty()){
            No atual = fila.poll();
            System.out.println((atual.valor + ", "));
            if(atual.esquerda != null){
                fila.add(atual.esquerda);
            }
            if (atual.direita != null){
                fila.add(atual.direita);
            }
        }
    }
}
